package br.com.sistemaVotacao.service;

import br.com.sistemaVotacao.model.dto.PautaDto;

import java.util.Optional;

public interface PautaService {

    Optional<PautaDto> criaPauta(PautaDto pautaDto);

}
