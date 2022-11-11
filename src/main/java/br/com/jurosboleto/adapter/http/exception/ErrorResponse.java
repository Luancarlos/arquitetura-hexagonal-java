package br.com.jurosboleto.adapter.http.exception;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private List<String> messages = new ArrayList<>();
    private String error;
    private int code;
    private Date timestamp;
    private String path;
}
