package br.com.sistemaVotacao.service;

import br.com.sistemaVotacao.model.dto.CriaVotoDto;
import br.com.sistemaVotacao.model.dto.PautaDto;
import br.com.sistemaVotacao.model.dto.SessaoPautaCriarDto;
import br.com.sistemaVotacao.model.dto.VotoDto;

import java.util.Optional;

public interface PautaService {

    Optional<PautaDto> criaPauta(PautaDto pautaDto);

    VotoDto sessaoVotacaoInicio(Long idPauta, SessaoPautaCriarDto sessaoPautaCriarDto);

    VotoDto votarInicio(Long idPauta, CriaVotoDto criaVotoDto);


}
