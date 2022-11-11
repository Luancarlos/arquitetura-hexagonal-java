package br.com.jurosboleto.adapter.datasource.mapper;

import br.com.jurosboleto.adapter.datasource.integration.dto.BoletoDTO;
import br.com.jurosboleto.core.domain.Boleto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoletoMapper {
    Boleto toDomain(BoletoDTO boletoDTO);
}
