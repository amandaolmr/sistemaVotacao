package br.com.sistemaVotacao.service.excpetion;

public class PautaNaoLocalizadaException extends GlobalException {
    public PautaNaoLocalizadaException() {
        super("Pauta não localizada");
    }

}
