package br.com.sistemaVotacao.service;

import br.com.sistemaVotacao.model.dto.CriaVotoDto;
import br.com.sistemaVotacao.model.dto.PautaDto;
import br.com.sistemaVotacao.model.dto.SessaoPautaCriarDto;
import br.com.sistemaVotacao.model.dto.VotoDto;
import br.com.sistemaVotacao.model.entity.Pauta;
import br.com.sistemaVotacao.model.entity.Voto;
import br.com.sistemaVotacao.model.entity.VotoSessao;
import br.com.sistemaVotacao.model.mapper.PautaMapper;
import br.com.sistemaVotacao.model.mapper.VotoMapper;
import br.com.sistemaVotacao.repository.PautaRepository;
import br.com.sistemaVotacao.repository.VotoRepository;
import br.com.sistemaVotacao.repository.VotoSessaoRepository;
import br.com.sistemaVotacao.service.excpetion.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PautaServiceImpl implements PautaService {

    @Value("${sessao.statica}")
    private Integer sessaoStatica;

    private final PautaRepository pautaRepository;
    private final PautaMapper pautaMapper;
    private final VotoSessaoRepository votoSessaoRepository;

    private final VotoMapper votoMapper;

    private final VotoRepository votoRepository;


    @Override
    public Optional<PautaDto> criaPauta(PautaDto pautaDto) {
        Optional<PautaDto> pautaSavedOptional =
                Optional.ofNullable(pautaMapper.toPautaDto(pautaRepository.save(pautaMapper.toPauta(pautaDto))));
        return pautaSavedOptional;
    }

    @Override
    public VotoDto sessaoVotacaoInicio(Long idPauta, SessaoPautaCriarDto sessaoPautaCriarDto) {
        Pauta pauta = pautaRepository.findById(idPauta)
                .orElseThrow(PautaNaoLocalizadaException::new);

        Optional<VotoSessao> votoSessao = votoSessaoRepository.findByPauta(idPauta);
        if (votoSessao.isPresent()) {
            throw new JaExisteSessaoParaPautaException();
        }

        if (sessaoPautaCriarDto.getDataHoraFechamentoSessao() != null && LocalDateTime.now().isAfter(sessaoPautaCriarDto.getDataHoraFechamentoSessao())) {
            throw new DataSessaoInferiorException();
        }
        VotoSessao votoSessaoSaved = criaSessaoParaVotacao(pauta, sessaoPautaCriarDto.getDataHoraFechamentoSessao());
        if (votoSessaoSaved != null)
            return VotoDto.builder()
                    .dataHoraVoto(LocalDateTime.now())
                    .build();
        return null;
    }

    @Override
    public VotoDto votarInicio(Long idPauta, CriaVotoDto criaVotoDto) {
        VotoSessao votoSessao = getVotoSessao(idPauta)
                .orElseThrow(() -> new PautaNaoLocalizadaException())
                .orElseThrow(() -> new SessaoNaoLocalizadaException());

        if (LocalDateTime.now().isAfter(votoSessao.getDataFechamento())) {
            throw new SessaoEncerradaExcpetion();
        }
        verificaEleitorJaVotou(votoSessao, criaVotoDto);
        var voto = votoRepository.save(votoMapper.toVoto(criaVotoDto));
        voto.setVotoSessao(votoSessao);
        return votoMapper.toVotoDto(voto);
    }

    private Optional<Optional<VotoSessao>> getVotoSessao(Long idPauta) {
        return Optional.ofNullable(votoSessaoRepository.findByPauta(idPauta));
    }

    private void verificaEleitorJaVotou(VotoSessao votoSessao, CriaVotoDto criaVotoDto) {
        Optional<Voto> voto = votoRepository.findById(criaVotoDto.getIdEleitor());
        if (voto.isPresent()) {
            votoSessao.getVotos().stream().forEach(votoEleitorSessao -> {
                if (votoEleitorSessao.getIdEleitor() == voto.get().getIdEleitor()) {
                    throw new EleitorJaVotouExcpetion();
                }
            });
        }
    }

    private VotoSessao criaSessaoParaVotacao(Pauta pauta, LocalDateTime dataHoraFechamento) {
        return votoSessaoRepository.save(VotoSessao.builder()
                .dataAbertura(LocalDateTime.now())
                .dataFechamento(verificaDataHoraFechamento(dataHoraFechamento))
                .pauta(pauta)
                .build());
    }

    private LocalDateTime verificaDataHoraFechamento(LocalDateTime dataHoraFechamento) {
        return dataHoraFechamento == null ? LocalDateTime.now().plusSeconds(sessaoStatica) : dataHoraFechamento;
    }

}
