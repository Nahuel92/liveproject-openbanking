package org.nahuelrodriguez.openbankingapp.adapter;

import org.nahuelrodriguez.openbankingapp.entity.Transaction;

import java.util.Collection;

public interface TransactionApiClient {
    Collection<Transaction> getTransactions(final String accountNumber);
}
