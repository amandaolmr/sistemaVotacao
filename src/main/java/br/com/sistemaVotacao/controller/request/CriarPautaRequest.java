package br.com.sistemaVotacao.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class CriarPautaRequest {

    @NotBlank(message = "O titulo informado não pode ser vazio.")
    private String titulo;

    @NotBlank(message = "A descrição precisa ser informada.")
    private String descricao;
}
