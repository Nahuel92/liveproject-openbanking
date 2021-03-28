package org.nahuelrodriguez.openbankingapp.adapter;

import com.external.api.model.*;
import org.nahuelrodriguez.openbankingapp.entity.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class OBTransactionAdapter {
    public Transaction convert(final OBTransaction6 obTransaction) {
        Objects.requireNonNull(obTransaction, "OBTransaction object is null!");

        final var transaction = new Transaction();
        transaction.setAccountNumber(obTransaction.getAccountId());
        transaction.setAmount(calculateAmount(obTransaction));
        transaction.setCurrency(getUnitCurrency(obTransaction));
        transaction.setDate(getDateTime(obTransaction));
        transaction.setType(getType(obTransaction));
        transaction.setMerchantName(getMerchantName(obTransaction));
        return transaction;
    }

    private String getMerchantName(final OBTransaction6 obTransaction) {
        return Optional.ofNullable(obTransaction.getMerchantDetails())
                .map(OBMerchantDetails1::getMerchantName)
                .orElseGet(String::new);
    }

    private String getType(final OBTransaction6 obTransaction) {
        return Optional.ofNullable(obTransaction.getCreditDebitIndicator())
                .map(OBCreditDebitCode1::getValue)
                .orElseGet(String::new);
    }

    private LocalDateTime getDateTime(final OBTransaction6 obTransaction) {
        return Optional.ofNullable(obTransaction.getValueDateTime())
                .map(OffsetDateTime::toLocalDateTime)
                .orElseGet(LocalDateTime::now);
    }

    private String calculateAmount(final OBTransaction6 obTransaction) {
        final var amount = Optional.ofNullable(obTransaction.getAmount())
                .map(OBActiveOrHistoricCurrencyAndAmount9::getAmount)
                .map(BigDecimal::new)
                .orElse(BigDecimal.ZERO);

        final var exchangeRate = Optional.ofNullable(obTransaction.getCurrencyExchange())
                .map(OBCurrencyExchange5::getExchangeRate)
                .orElse(BigDecimal.ZERO);

        return amount.multiply(exchangeRate).toString();
    }

    private String getUnitCurrency(final OBTransaction6 obTransaction) {
        return Optional.ofNullable(obTransaction.getCurrencyExchange())
                .map(OBCurrencyExchange5::getUnitCurrency)
                .orElseGet(String::new);
    }
}
