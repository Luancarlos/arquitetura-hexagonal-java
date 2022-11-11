package br.com.jurosboleto.core.port.out;

import br.com.jurosboleto.core.domain.BoletoCalculado;

public interface SalvarCalculoBoletoPort {
    void executar(BoletoCalculado boletoCalculado);
}
