package br.com.jurosboleto.adapter.datasource.integration.dto;

import br.com.jurosboleto.core.domain.enums.TipoBoleto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class BoletoDTO {
    private String codigo;
    @JsonProperty("data_vencimento")
    private LocalDate dataVencimento;
    private BigDecimal valor;
    private TipoBoleto tipo;
}
