package br.com.jurosboleto.adapter.datasource.mapper;

import br.com.jurosboleto.adapter.datasource.database.entity.BoletoCalculadoEntity;
import br.com.jurosboleto.core.domain.BoletoCalculado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoletoCalculoMapper {

    BoletoCalculadoEntity toEntity(BoletoCalculado boletoCalculado);

}
