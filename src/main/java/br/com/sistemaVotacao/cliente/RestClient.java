package br.com.sistemaVotacao.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component // Essa anotação indica ao Spring que essa classe é um componente gerenciado pelo framework, ou seja ela pode ser injetada em outras classes e utilizada como um bean.
public class RestClient { //cliente REST genérico para enviar requisições HTTP

    @Autowired //@Autowired para injetar um objeto RestTemplate, que é uma classe do Spring usada para realizar chamadas HTTP.
    private RestTemplate restTemplate;

    @Retryable(value = HttpClientErrorException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public <T> T enviaRequisicao(String uri, ParameterizedTypeReference<T> clazz, HttpMethod metodo, Object body,
                                 HttpHeaders headers) {

        HttpEntity<Object> request = new HttpEntity<>(body, headers);

        ResponseEntity<T> exchange = null;

        exchange = restTemplate.exchange(uri, metodo, request, clazz);

        return exchange.getBody(); // retorna o corpo da resposta da requisição.
    }
}
