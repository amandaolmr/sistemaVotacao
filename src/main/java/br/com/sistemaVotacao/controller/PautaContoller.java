package br.com.sistemaVotacao.controller;

import br.com.sistemaVotacao.controller.mapper.PautaRequestMapper;
import br.com.sistemaVotacao.controller.request.CriarPautaRequest;
import br.com.sistemaVotacao.controller.request.CriarSessaoPautaRequest;
import br.com.sistemaVotacao.model.dto.PautaDto;
import br.com.sistemaVotacao.model.dto.VotoDto;
import br.com.sistemaVotacao.service.PautaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;
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

    @PostMapping(value = "cria-sessao/{idPauta}")
    public ResponseEntity<?> sessaoVotacao(@PathVariable Long idPauta, CriarSessaoPautaRequest criarSessaoPautaRequest) {
        VotoDto votoDto = pautaService.sessaoVotacaoInicio(idPauta,
                pautaRequestMapper.toSessaoPautaCriarDto(criarSessaoPautaRequest));
        if (Objects.nonNull(votoDto.getDataHoraVoto())) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.badRequest().build();
    }
}