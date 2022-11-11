package br.com.jurosboleto.adapter.http.exception;

import br.com.jurosboleto.core.domain.enums.TipoExecao;
import br.com.jurosboleto.core.exception.ApplicationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApplicationExceptionHandle extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> notFound(ApplicationException ex, WebRequest request) {
        var response = ErrorResponse.builder()
                .messages(Arrays.asList(ex.getTipoExecao().getMensagemErro()))
                .error(ex.getTipoExecao().toString().toLowerCase())
                .timestamp(new Date())
                .code(HttpStatus.NOT_FOUND.value())
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var erros = e.getFieldErrors().stream()
                .map(item -> item.getField() + " " + item.getDefaultMessage())
                .collect(Collectors.toList());

        var response = ErrorResponse.builder()
                .messages(erros)
                .error(TipoExecao.CONTEUDO_INVALIDO.toString().toLowerCase())
                .timestamp(new Date())
                .code(HttpStatus.BAD_REQUEST.value())
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
