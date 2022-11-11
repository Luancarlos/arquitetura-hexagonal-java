package br.com.jurosboleto.adapter.datasource.database;

import br.com.jurosboleto.adapter.datasource.database.repository.BoletoCalculadoRepository;
import br.com.jurosboleto.adapter.datasource.mapper.BoletoCalculoMapper;
import br.com.jurosboleto.core.domain.BoletoCalculado;
import br.com.jurosboleto.core.port.out.SalvarCalculoBoletoPort;
import org.springframework.stereotype.Component;

@Component
public class SalvarBoletoCalculado implements SalvarCalculoBoletoPort {
    private final BoletoCalculadoRepository repository;
    private final BoletoCalculoMapper mapper;
    public SalvarBoletoCalculado(BoletoCalculadoRepository repository, BoletoCalculoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void executar(BoletoCalculado boletoCalculado) {
        var entity = mapper.toEntity(boletoCalculado);
        repository.save(entity);
    }
}
