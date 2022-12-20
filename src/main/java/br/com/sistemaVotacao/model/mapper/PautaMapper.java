package br.com.sistemaVotacao.model.mapper;

import br.com.sistemaVotacao.model.dto.PautaDto;
import br.com.sistemaVotacao.model.entity.Pauta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PautaMapper {

    Pauta toPauta(PautaDto pautaDto);
    PautaDto toPautaDto(Pauta pauta);
}
