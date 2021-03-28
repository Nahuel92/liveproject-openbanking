package org.nahuelrodriguez.openbankingapp.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.nahuelrodriguez.openbankingapp.adapter.TransactionApiClient;
import org.nahuelrodriguez.openbankingapp.entity.Transaction;
import org.nahuelrodriguez.openbankingapp.repository.MerchantDetailsRepository;
import org.nahuelrodriguez.openbankingapp.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionApiClient transactionApiClient;
    private final MerchantDetailsRepository merchantDetailsRepository;

    public TransactionServiceImpl(final TransactionApiClient transactionApiClient,
                                  final MerchantDetailsRepository merchantDetailsRepository) {
        this.transactionApiClient = transactionApiClient;
        this.merchantDetailsRepository = merchantDetailsRepository;
    }

    @Override
    @CircuitBreaker(name = "allTxsPerAccountNumber", fallbackMethod = "txsPerAccountNumberFallback")
    public Collection<Transaction> findAllByAccountNumber(final String accountNumber) {
        final var transactions = transactionApiClient.getTransactions(accountNumber);
        transactions.stream()
                .filter(tx -> tx.getMerchantName() != null)
                .forEach(tx -> tx.setMerchantLogo(merchantDetailsRepository.getMerchantLogo(tx.getMerchantName())));
        return transactions;
    }

    private Collection<Transaction> txsPerAccountNumberFallback() {
        return Collections.emptyList();
    }
}
