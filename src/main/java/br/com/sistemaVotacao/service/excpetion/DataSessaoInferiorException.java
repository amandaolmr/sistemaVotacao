package br.com.sistemaVotacao.service.excpetion;

public class DataSessaoInferiorException extends GlobalException {
    public DataSessaoInferiorException() {
        super("Data e hora de fechamento da sessao" +
                "inferior a atual no sistema");
    }

}
