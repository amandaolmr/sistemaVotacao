package br.com.sistemaVotacao.controller.request;

import javax.validation.constraints.NotBlank;

public class CriarPautaRequest {

    @NotBlank(message = "O titulo informado não pode ser vazio.")
    private String titulo;

    @NotBlank(message = "A descrição precisa ser informada.")
    private String descricao;
}
