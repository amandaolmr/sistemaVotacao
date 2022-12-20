package br.com.sistemaVotacao.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SessaoPautaCriarDto {

    private LocalDateTime dataHoraFechamentoSessao;
}
