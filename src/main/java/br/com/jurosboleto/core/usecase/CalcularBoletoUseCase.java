package br.com.jurosboleto.core.usecase;

import br.com.jurosboleto.core.domain.Boleto;
import br.com.jurosboleto.core.domain.BoletoCalculado;
import br.com.jurosboleto.core.domain.enums.TipoBoleto;
import br.com.jurosboleto.core.domain.enums.TipoExecao;
import br.com.jurosboleto.core.exception.ApplicationException;
import br.com.jurosboleto.core.port.in.CalculoBoletoPort;
import br.com.jurosboleto.core.port.out.ComplementarBoletoPort;
import br.com.jurosboleto.core.port.out.SalvarCalculoBoletoPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class CalcularBoletoUseCase implements CalculoBoletoPort {

    private static final BigDecimal JUROS_DIARIO = BigDecimal.valueOf(0.033);

    private final ComplementarBoletoPort complementarBoletoPort;
    private final SalvarCalculoBoletoPort salvarCalculoBoletoPort;

    public CalcularBoletoUseCase(ComplementarBoletoPort complementarBoletoPort, SalvarCalculoBoletoPort salvarCalculoBoletoPort) {
        this.complementarBoletoPort = complementarBoletoPort;
        this.salvarCalculoBoletoPort = salvarCalculoBoletoPort;
    }

    @Override
    public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {
        var boleto = complementarBoletoPort.executar(codigo);
        validar(boleto);

        var diasVencidos = getDiasVencidos(boleto.getDataVencimento(), dataPagamento);
        var valorJurosDia = JUROS_DIARIO.multiply(boleto.getValor()).divide(new BigDecimal(100));
        var juros = valorJurosDia.multiply(new BigDecimal(diasVencidos)).setScale(2, RoundingMode.HALF_EVEN);
        var boletoCalculado = BoletoCalculado.builder()
                .codigo(boleto.getCodigo())
                .dataPagamento(dataPagamento)
                .juros(juros)
                .dataVencimento(boleto.getDataVencimento())
                .valorOriginal(boleto.getValor())
                .valor(boleto.getValor().add(juros))
                .tipo(boleto.getTipo())
                .build();

        salvarCalculoBoletoPort.executar(boletoCalculado);
        return boletoCalculado;
    }

    private void validar(Boleto boleto)  {
        if (boleto == null) {
            throw new ApplicationException(TipoExecao.BOLETO_INVALIDO);
        }

        if (boleto.getTipo() != TipoBoleto.XPTO) {
            throw new ApplicationException(TipoExecao.TIPO_BOLETO_INVALIDO);
        }

        if (boleto.getDataVencimento().isAfter(LocalDate.now())) {
            throw new ApplicationException(TipoExecao.BOLETO_NAO_VENCIDO);
        }
    }


    private Long getDiasVencidos(LocalDate dataVencimento, LocalDate dataPagamento) {
        return ChronoUnit.DAYS.between(dataVencimento, dataPagamento);
    }


}
