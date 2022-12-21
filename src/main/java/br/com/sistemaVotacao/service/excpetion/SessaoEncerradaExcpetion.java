package br.com.sistemaVotacao.service.excpetion;

public class SessaoEncerradaExcpetion extends GlobalException {
    public SessaoEncerradaExcpetion() {
        super("A sessão já está encerrada.");
    }

}
