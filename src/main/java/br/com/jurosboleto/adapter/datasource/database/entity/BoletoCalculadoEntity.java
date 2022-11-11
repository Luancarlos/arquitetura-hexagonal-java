package br.com.jurosboleto.adapter.datasource.database.entity;

import br.com.jurosboleto.core.domain.enums.TipoBoleto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "boleto_calculado")
@Getter
@Setter
public class BoletoCalculadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codigo;

    @Column
    private BigDecimal valorOriginal;

    @Column
    private BigDecimal valor;

    @Column
    private LocalDate dataVencimento;

    @Column
    private LocalDate dataPagamento;

    @Column
    private BigDecimal juros;

    @Column
    private TipoBoleto tipo;


}
