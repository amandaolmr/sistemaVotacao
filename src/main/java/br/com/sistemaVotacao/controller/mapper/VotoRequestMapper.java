package br.com.sistemaVotacao.controller.mapper;


import br.com.sistemaVotacao.controller.request.CriaVotoRequest;
import br.com.sistemaVotacao.model.dto.CriaVotoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VotoRequestMapper {

    CriaVotoDto toCriaVotoDto(CriaVotoRequest criaVotoRequest);
}
