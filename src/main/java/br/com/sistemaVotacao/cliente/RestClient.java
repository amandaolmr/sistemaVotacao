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

@Component
public class RestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Retryable(value = HttpClientErrorException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public <T> T enviaRequisicao(String uri, ParameterizedTypeReference<T> clazz, HttpMethod metodo, Object body,
                                 HttpHeaders headers) {

        HttpEntity<Object> request = new HttpEntity<>(body, headers);

        ResponseEntity<T> exchange = null;

        exchange = restTemplate.exchange(uri, metodo, request, clazz);

        return exchange.getBody();
    }
}
