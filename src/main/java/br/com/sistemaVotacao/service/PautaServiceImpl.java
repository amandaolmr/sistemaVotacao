package br.com.sistemaVotacao.service;

import br.com.sistemaVotacao.model.dto.PautaDto;
import br.com.sistemaVotacao.model.mapper.PautaMapper;
import br.com.sistemaVotacao.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PautaServiceImpl implements PautaService{
    @Value("${sessao.statica}")
    private Integer sessaoStatica;

    private final PautaRepository pautaRepository;
    private final PautaMapper pautaMapper;
    @Override
    public Optional<PautaDto> criaPauta(PautaDto pautaDto) {
        Optional<PautaDto> pautaSavedOptional =
                Optional.ofNullable(pautaMapper.toPautaDto(pautaRepository.save(pautaMapper.toPauta(pautaDto))));
        return pautaSavedOptional;
    }
}
