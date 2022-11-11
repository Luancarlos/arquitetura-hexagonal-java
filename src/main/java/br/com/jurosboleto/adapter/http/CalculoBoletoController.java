package br.com.jurosboleto.adapter.http;

import br.com.jurosboleto.adapter.http.dto.CalculoBoletoRequest;
import br.com.jurosboleto.adapter.http.dto.CalculoBoletoResponse;
import br.com.jurosboleto.adapter.http.mapper.BoletoCalculadoMapper;
import br.com.jurosboleto.core.port.in.CalculoBoletoPort;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/boleto")
public class CalculoBoletoController {

    private final CalculoBoletoPort calculoBoletoPort;
    private final BoletoCalculadoMapper mapper;

    public CalculoBoletoController(CalculoBoletoPort calculoBoletoPort, BoletoCalculadoMapper mapper) {
        this.calculoBoletoPort = calculoBoletoPort;
        this.mapper = mapper;
    }

    @PostMapping("/calculo")
    @Operation(summary = "Calcula juros de um boleto")
    public ResponseEntity<CalculoBoletoResponse> calcularBoleto(@Valid @RequestBody CalculoBoletoRequest boleto) {
        var boletoCalculado = calculoBoletoPort.executar(boleto.getCodigo(), boleto.getDataPagamento());
        return ResponseEntity.ok(mapper.toDTO(boletoCalculado));
    }
}
