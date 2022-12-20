package br.com.sistemaVotacao.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VotoDto {

    private LocalDateTime dataHoraVoto;
}
