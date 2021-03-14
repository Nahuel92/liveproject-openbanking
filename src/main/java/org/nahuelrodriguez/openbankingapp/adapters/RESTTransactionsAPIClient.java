package org.nahuelrodriguez.openbankingapp.adapters;

import com.external.api.model.OBTransaction6;
import org.nahuelrodriguez.openbankingapp.entities.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class RESTTransactionsAPIClient implements TransactionApiClient {
    private final OBTransactionAdapter transactionAdapter;

    @Value("external.banking.api.url")
    private String externalBankingApiUrl;

    public RESTTransactionsAPIClient(final OBTransactionAdapter transactionAdapter) {
        this.transactionAdapter = transactionAdapter;
    }

    @Override
    public Collection<Transaction> getTransactions(final String accountNumber) {
        return WebClient.create(externalBankingApiUrl)
                .get()
                .retrieve()
                .bodyToFlux(OBTransaction6.class)
                .map(transactionAdapter::convert)
                .toStream()
                .collect(Collectors.toList());
    }
}
