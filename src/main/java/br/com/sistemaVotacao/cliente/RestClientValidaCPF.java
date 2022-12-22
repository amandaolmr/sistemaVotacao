package br.com.sistemaVotacao.cliente;

import br.com.sistemaVotacao.cliente.dto.ResponseStatusCpfDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class RestClientValidaCPF {

    @Autowired
    private RestClient restClient;

    @Value("${uri.validacao.cpf}")
    private String uriValidaCPF;

    private static final ParameterizedTypeReference<ResponseStatusCpfDto> CLASSE_RETORNO =
            new ParameterizedTypeReference<ResponseStatusCpfDto>() {
            };

    public ResponseStatusCpfDto getValidaCPFStatus(String cpf) {
        String url = uriValidaCPF+cpf;

        ResponseStatusCpfDto responseStatusCpfDto =
                restClient.enviaRequisicao(url,CLASSE_RETORNO, HttpMethod.GET, null, null);

        return responseStatusCpfDto;
    }
}
