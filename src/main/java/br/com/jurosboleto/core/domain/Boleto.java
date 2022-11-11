package br.com.jurosboleto.core.domain;

import br.com.jurosboleto.core.domain.enums.TipoBoleto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Boleto {
    private String codigo;
    private LocalDate dataVencimento;
    private BigDecimal valor;
    private TipoBoleto tipo;
}
