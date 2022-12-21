package br.com.sistemaVotacao.model.dto;

import br.com.sistemaVotacao.model.enums.IntencaoVoto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CriaVotoDto {

    private LocalDateTime dataHoraVoto;
    private Long idEleitor;
    private IntencaoVoto intencaoVoto;
}
