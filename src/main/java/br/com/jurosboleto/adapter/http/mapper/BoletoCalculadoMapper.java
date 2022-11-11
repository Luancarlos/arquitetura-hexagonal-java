package br.com.jurosboleto.adapter.http.mapper;

import br.com.jurosboleto.adapter.http.dto.CalculoBoletoResponse;
import br.com.jurosboleto.core.domain.BoletoCalculado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoletoCalculadoMapper {
    CalculoBoletoResponse toDTO(BoletoCalculado boletoCalculado);
}
