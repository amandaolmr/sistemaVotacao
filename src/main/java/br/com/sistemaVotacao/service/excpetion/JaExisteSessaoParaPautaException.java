package br.com.sistemaVotacao.service.excpetion;

public class JaExisteSessaoParaPautaException extends GlobalException {
    public JaExisteSessaoParaPautaException() {
        super("Sessão para pauta já existente");
    }

}
