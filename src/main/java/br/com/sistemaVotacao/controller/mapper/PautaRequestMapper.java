package br.com.sistemaVotacao.controller.mapper;

import br.com.sistemaVotacao.controller.request.CriarPautaRequest;
import br.com.sistemaVotacao.controller.request.CriarSessaoPautaRequest;
import br.com.sistemaVotacao.model.dto.PautaDto;
import br.com.sistemaVotacao.model.dto.SessaoPautaCriarDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PautaRequestMapper {

    PautaDto toPautaDto(CriarPautaRequest criarPautaRequest);

    SessaoPautaCriarDto toSessaoPautaCriarDto(CriarSessaoPautaRequest criarSessaoPautaRequest);

}
