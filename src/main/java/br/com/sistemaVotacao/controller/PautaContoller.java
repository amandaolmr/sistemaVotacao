package br.com.sistemaVotacao.controller;

import br.com.sistemaVotacao.controller.mapper.PautaRequestMapper;
import br.com.sistemaVotacao.controller.request.CriarPautaRequest;
import br.com.sistemaVotacao.model.dto.PautaDto;
import br.com.sistemaVotacao.service.PautaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/pauta/")
@RequiredArgsConstructor
public class PautaContoller {
    private final PautaService pautaService;
    private final PautaRequestMapper pautaRequestMapper;

    @PostMapping(value = "criar")
    public ResponseEntity<?> criarPauta(@RequestBody @Valid CriarPautaRequest criarPautaRequest) {
        Optional<PautaDto> pautaDto = pautaService.criaPauta(pautaRequestMapper.toPautaDto(criarPautaRequest));
        if (pautaDto.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(pautaDto);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
