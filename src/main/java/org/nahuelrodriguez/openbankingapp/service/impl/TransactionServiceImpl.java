package org.nahuelrodriguez.openbankingapp.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.nahuelrodriguez.openbankingapp.adapter.TransactionApiClient;
import org.nahuelrodriguez.openbankingapp.entity.Transaction;
import org.nahuelrodriguez.openbankingapp.repository.MerchantDetailsRepository;
import org.nahuelrodriguez.openbankingapp.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionApiClient transactionApiClient;
    private final MerchantDetailsRepository merchantDetailsRepository;
    private final Logger log;

    public TransactionServiceImpl(final TransactionApiClient transactionApiClient,
                                  final MerchantDetailsRepository merchantDetailsRepository) {
        this.transactionApiClient = transactionApiClient;
        this.merchantDetailsRepository = merchantDetailsRepository;
        this.log = LoggerFactory.getLogger(TransactionServiceImpl.class);
    }

    @Override
    @CircuitBreaker(name = "allTxsPerAccountNumber", fallbackMethod = "txsPerAccountNumberFallback")
    @Cacheable(cacheNames = "txs", key = "#accountNumber")
    public Collection<Transaction> findAllByAccountNumber(final String accountNumber) {
        log.info("Retrieving transactions from OpenAPI server for the account number: '{}'", accountNumber);
        final var transactions = transactionApiClient.getTransactions(accountNumber);
        transactions.stream()
                .filter(tx -> tx.getMerchantName() != null)
                .forEach(tx -> tx.setMerchantLogo(merchantDetailsRepository.getMerchantLogo(tx.getMerchantName())));
        log.info("Returning '{}' transactions for the account number: '{}'", transactions.size(), accountNumber);
        return transactions;
    }

    private Collection<Transaction> txsPerAccountNumberFallback() {
        return Collections.emptyList();
    }
}
