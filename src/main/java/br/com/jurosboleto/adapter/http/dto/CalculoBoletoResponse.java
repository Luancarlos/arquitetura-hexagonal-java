package br.com.jurosboleto.adapter.http.dto;

import br.com.jurosboleto.core.domain.enums.TipoBoleto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CalculoBoletoResponse {

    private String codigo;

    @JsonProperty("data_vencimento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVencimento;

    private BigDecimal valor;

    private TipoBoleto tipo;
}
