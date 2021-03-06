package org.nahuelrodriguez.openbankingapp.controller;

import org.nahuelrodriguez.openbankingapp.model.Transaction;
import org.nahuelrodriguez.openbankingapp.service.TransactionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionServiceImpl;

    public TransactionController(final TransactionService transactionServiceImpl) {
        this.transactionServiceImpl = transactionServiceImpl;
    }

    @GetMapping(path = "/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Transaction> getTransactions(@PathVariable final String accountNumber) {
        return transactionServiceImpl.findAllByAccountNumber(accountNumber);
    }
}
