package br.com.sistemaVotacao.controller.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CriarSessaoPautaRequest {

    private LocalDateTime dataHoraFechamentoSessao;
}
