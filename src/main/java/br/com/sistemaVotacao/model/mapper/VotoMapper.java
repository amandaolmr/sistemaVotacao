package br.com.sistemaVotacao.model.mapper;

import br.com.sistemaVotacao.model.dto.CriaVotoDto;
import br.com.sistemaVotacao.model.dto.VotoDto;
import br.com.sistemaVotacao.model.entity.Voto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VotoMapper {

    Voto toVoto(CriaVotoDto criaVotoDto);
    VotoDto toVotoDto(Voto voto);
}
