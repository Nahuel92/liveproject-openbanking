package org.nahuelrodriguez.openbankingapp.service.impl;

import org.nahuelrodriguez.openbankingapp.model.Transaction;
import org.nahuelrodriguez.openbankingapp.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public Collection<Transaction> findAllByAccountNumber(final String accountNumber) {
        return List.of(getMockedTransaction(accountNumber));
    }

    private Transaction getMockedTransaction(final String accountNumber) {
        final var transaction = new Transaction();
        transaction.setAccountNumber(Long.valueOf(accountNumber));
        transaction.setAmount("1500");
        return transaction;
    }
}
