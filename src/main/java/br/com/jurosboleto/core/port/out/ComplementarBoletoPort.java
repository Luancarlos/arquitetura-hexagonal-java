package br.com.jurosboleto.core.port.out;

import br.com.jurosboleto.core.domain.Boleto;

public interface ComplementarBoletoPort {
   Boleto executar(String codigo);
}
