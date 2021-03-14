package org.nahuelrodriguez.openbankingapp.adapters;

import org.nahuelrodriguez.openbankingapp.entities.Transaction;

import java.util.Collection;

public interface TransactionApiClient {
    Collection<Transaction> getTransactions(final String accountNumber);
}
