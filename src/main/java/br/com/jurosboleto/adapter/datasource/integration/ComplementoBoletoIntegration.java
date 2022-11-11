package br.com.jurosboleto.adapter.datasource.integration;

import br.com.jurosboleto.adapter.datasource.integration.client.ComplementoBoletoClient;
import br.com.jurosboleto.adapter.datasource.mapper.BoletoMapper;
import br.com.jurosboleto.core.domain.Boleto;
import br.com.jurosboleto.core.port.out.ComplementarBoletoPort;
import org.springframework.stereotype.Component;

@Component
public class ComplementoBoletoIntegration implements ComplementarBoletoPort {

    private final BoletoMapper mapper;
    private final ComplementoBoletoClient client;

    public ComplementoBoletoIntegration(BoletoMapper mapper, ComplementoBoletoClient client) {
        this.mapper = mapper;
        this.client = client;
    }

    @Override
    public Boleto executar(String codigo) {
        var boletoDTO = client.getBoleto(codigo);
        return mapper.toDomain(boletoDTO);
    }
}
