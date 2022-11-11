package br.com.jurosboleto.core.port.in;

import br.com.jurosboleto.core.domain.BoletoCalculado;

import java.time.LocalDate;

public interface CalculoBoletoPort {
   BoletoCalculado executar(String codigo, LocalDate dataPagamento);
}
