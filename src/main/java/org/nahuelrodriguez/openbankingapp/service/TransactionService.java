package org.nahuelrodriguez.openbankingapp.service;

import org.nahuelrodriguez.openbankingapp.entity.Transaction;

import java.util.Collection;

public interface TransactionService {
    Collection<Transaction> findAllByAccountNumber(final String accountNumber);
}
