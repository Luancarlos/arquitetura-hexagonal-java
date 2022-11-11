package br.com.jurosboleto.core.exception;


import br.com.jurosboleto.core.domain.enums.TipoExecao;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException {
    private TipoExecao tipoExecao;
}
