package br.com.jurosboleto.core.domain;

import br.com.jurosboleto.core.domain.enums.TipoBoleto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class BoletoCalculado {
    private String codigo;
    private BigDecimal valorOriginal;
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal juros;
    private TipoBoleto tipo;
}
