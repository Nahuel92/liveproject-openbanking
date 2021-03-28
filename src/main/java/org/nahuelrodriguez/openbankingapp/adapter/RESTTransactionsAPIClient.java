package org.nahuelrodriguez.openbankingapp.adapter;

import com.external.api.model.OBReadDataTransaction6;
import com.external.api.model.OBReadTransaction6;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nahuelrodriguez.openbankingapp.entity.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class RESTTransactionsAPIClient implements TransactionApiClient {
    private final OBTransactionAdapter transactionAdapter;

    @Value("${external.banking.api.url}")
    private String externalBankingApiUrl;

    @Value("${external.banking.api.clientId}")
    private String clientId;

    @Value("${external.banking.api.secret}")
    private String secret;

    public RESTTransactionsAPIClient(final OBTransactionAdapter transactionAdapter) {
        this.transactionAdapter = transactionAdapter;
    }

    @Override
    public Collection<Transaction> getTransactions(final String accountNumber) {
        return WebClient.builder()
                .defaultUriVariables(Map.of("accountNumber", accountNumber))
                .baseUrl(externalBankingApiUrl + "/accounts/{accountNumber}/transactions")
                .build()
                .get()
                .headers(h -> h.setBearerAuth(getAuthorizationToken()))
                .retrieve()
                .bodyToFlux(OBReadTransaction6.class)
                .map(OBReadTransaction6::getData)
                .map(OBReadDataTransaction6::getTransaction)
                .toStream()
                .flatMap(Collection::stream)
                .map(transactionAdapter::convert)
                .collect(Collectors.toList());
    }

    private String getAuthorizationToken() {
        return WebClient.create(externalBankingApiUrl + "/oauth/token")
                .post()
                .headers(setHeaders())
                .bodyValue("grant_type=client_credentials")
                .retrieve()
                .toEntity(AuthorizationServiceResponse.class)
                .blockOptional()
                .filter(HttpEntity::hasBody)
                .map(HttpEntity::getBody)
                .map(AuthorizationServiceResponse::getAccessToken)
                .orElseThrow();
    }

    private Consumer<HttpHeaders> setHeaders() {
        return headers -> {
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.setBasicAuth(clientId, secret);
        };
    }

    @Data
    @NoArgsConstructor
    private static class AuthorizationServiceResponse {
        @JsonProperty("access_token")
        private String accessToken;
        @JsonProperty("token_type")
        private String tokenType;
        @JsonProperty("expires_in")
        private String expiresIn;
        private String scope;
    }
}
