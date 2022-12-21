package br.com.sistemaVotacao.service.excpetion;

public class EleitorJaVotouExcpetion extends GlobalException {
    public EleitorJaVotouExcpetion() {
        super("O eleitor ja votou.");
    }

}
