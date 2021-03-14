package org.nahuelrodriguez.openbankingapp.adapters;

import com.external.api.model.*;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class OBTransactionAdapterTest {
    private OBTransactionAdapter subject;

    @BeforeEach
    void setUp() {
        subject = new OBTransactionAdapter();
    }

    @Test
    void when_obTransaction_is_null_fail_fast() {
        assertThatNullPointerException()
                .isThrownBy(() -> subject.convert(null))
                .withMessage("OBTransaction object is null!");
    }

    @Test
    void when_obTransaction_has_only_account_number_map_other_values_with_default_ones() {
        // given
        final var obTransaction = new OBTransaction6();
        obTransaction.setAccountId("123567");

        // when
        final var converted = subject.convert(obTransaction);

        // then
        assertThat(converted)
                .hasFieldOrPropertyWithValue("accountNumber", "123567")
                .hasFieldOrPropertyWithValue("amount", "0")
                .hasFieldOrPropertyWithValue("currency", "")
                .hasFieldOrPropertyWithValue("type", "")
                .hasFieldOrPropertyWithValue("merchantName", "")
                .extracting("date")
                .asInstanceOf(InstanceOfAssertFactories.LOCAL_DATE_TIME)
                .isEqualToIgnoringSeconds(LocalDateTime.now());
    }

    @Test
    void when_obTransaction_has_account_number_and_amount_but_not_rate_exchange_map_other_values_with_default_ones() {
        // given
        final var amount = new OBActiveOrHistoricCurrencyAndAmount9();
        amount.setAmount("123");
        // and
        final var obTransaction = new OBTransaction6();
        obTransaction.setAccountId("123567");
        obTransaction.setAmount(amount);

        // when
        final var converted = subject.convert(obTransaction);

        // then
        assertThat(converted)
                .hasFieldOrPropertyWithValue("accountNumber", "123567")
                .hasFieldOrPropertyWithValue("amount", "0")
                .hasFieldOrPropertyWithValue("currency", "")
                .hasFieldOrPropertyWithValue("type", "")
                .hasFieldOrPropertyWithValue("merchantName", "")
                .extracting("date")
                .asInstanceOf(InstanceOfAssertFactories.LOCAL_DATE_TIME)
                .isEqualToIgnoringSeconds(LocalDateTime.now());
    }

    @Test
    void when_obTransaction_has_account_number_and_amount_and_rate_exchange_map_other_values_with_default_ones() {
        // given
        final var amount = new OBActiveOrHistoricCurrencyAndAmount9();
        amount.setAmount("123");
        // and
        final var currencyExchange = new OBCurrencyExchange5();
        currencyExchange.setExchangeRate(BigDecimal.ONE);
        // and
        final var obTransaction = new OBTransaction6();
        obTransaction.setAccountId("123567");
        obTransaction.setAmount(amount);
        obTransaction.setCurrencyExchange(currencyExchange);

        // when
        final var converted = subject.convert(obTransaction);

        // then
        assertThat(converted)
                .hasFieldOrPropertyWithValue("accountNumber", "123567")
                .hasFieldOrPropertyWithValue("amount", "123")
                .hasFieldOrPropertyWithValue("currency", "")
                .hasFieldOrPropertyWithValue("type", "")
                .hasFieldOrPropertyWithValue("merchantName", "")
                .extracting("date")
                .asInstanceOf(InstanceOfAssertFactories.LOCAL_DATE_TIME)
                .isEqualToIgnoringSeconds(LocalDateTime.now());
    }

    @Test
    void when_obTransaction_has_account_number_and_amount_and_rate_exchange_and_currency_map_other_values_with_default_ones() {
        // given
        final var amount = new OBActiveOrHistoricCurrencyAndAmount9();
        amount.setAmount("123");
        // and
        final var currencyExchange = new OBCurrencyExchange5();
        currencyExchange.setExchangeRate(BigDecimal.ONE);
        currencyExchange.setUnitCurrency("US");
        // and
        final var obTransaction = new OBTransaction6();
        obTransaction.setAccountId("123567");
        obTransaction.setAmount(amount);
        obTransaction.setCurrencyExchange(currencyExchange);

        // when
        final var converted = subject.convert(obTransaction);

        // then
        assertThat(converted)
                .hasFieldOrPropertyWithValue("accountNumber", "123567")
                .hasFieldOrPropertyWithValue("amount", "123")
                .hasFieldOrPropertyWithValue("currency", "US")
                .hasFieldOrPropertyWithValue("type", "")
                .hasFieldOrPropertyWithValue("merchantName", "")
                .extracting("date")
                .asInstanceOf(InstanceOfAssertFactories.LOCAL_DATE_TIME)
                .isEqualToIgnoringSeconds(LocalDateTime.now());
    }

    @Test
    void when_obTransaction_has_account_number_and_amount_and_rate_exchange_and_currency_and_date_map_other_values_with_default_ones() {
        // given
        final var amount = new OBActiveOrHistoricCurrencyAndAmount9();
        amount.setAmount("123");
        // and
        final var currencyExchange = new OBCurrencyExchange5();
        currencyExchange.setExchangeRate(BigDecimal.ONE);
        currencyExchange.setUnitCurrency("US");
        // and
        final var obTransaction = new OBTransaction6();
        obTransaction.setAccountId("123567");
        obTransaction.setAmount(amount);
        obTransaction.setCurrencyExchange(currencyExchange);
        obTransaction.setValueDateTime(OffsetDateTime.now());

        // when
        final var converted = subject.convert(obTransaction);

        // then
        assertThat(converted)
                .hasFieldOrPropertyWithValue("accountNumber", "123567")
                .hasFieldOrPropertyWithValue("amount", "123")
                .hasFieldOrPropertyWithValue("currency", "US")
                .hasFieldOrPropertyWithValue("type", "")
                .hasFieldOrPropertyWithValue("merchantName", "")
                .extracting("date")
                .asInstanceOf(InstanceOfAssertFactories.LOCAL_DATE_TIME)
                .isEqualToIgnoringSeconds(LocalDateTime.now());
    }

    @Test
    void when_obTransaction_has_account_number_and_amount_and_rate_exchange_and_currency_and_date_and_type_map_other_values_with_default_ones() {
        // given
        final var amount = new OBActiveOrHistoricCurrencyAndAmount9();
        amount.setAmount("123");
        // and
        final var currencyExchange = new OBCurrencyExchange5();
        currencyExchange.setExchangeRate(BigDecimal.ONE);
        currencyExchange.setUnitCurrency("US");
        // and
        final var obTransaction = new OBTransaction6();
        obTransaction.setAccountId("123567");
        obTransaction.setAmount(amount);
        obTransaction.setCurrencyExchange(currencyExchange);
        obTransaction.setValueDateTime(OffsetDateTime.now());
        obTransaction.setCreditDebitIndicator(OBCreditDebitCode1.CREDIT);

        // when
        final var converted = subject.convert(obTransaction);

        // then
        assertThat(converted)
                .hasFieldOrPropertyWithValue("accountNumber", "123567")
                .hasFieldOrPropertyWithValue("amount", "123")
                .hasFieldOrPropertyWithValue("currency", "US")
                .hasFieldOrPropertyWithValue("type", OBCreditDebitCode1.CREDIT.getValue())
                .hasFieldOrPropertyWithValue("merchantName", "")
                .extracting("date")
                .asInstanceOf(InstanceOfAssertFactories.LOCAL_DATE_TIME)
                .isEqualToIgnoringSeconds(LocalDateTime.now());
    }

    @Test
    void when_obTransaction_has_all_required_values_map_them_to_transaction() {
        // given
        final var amount = new OBActiveOrHistoricCurrencyAndAmount9();
        amount.setAmount("123");
        // and
        final var currencyExchange = new OBCurrencyExchange5();
        currencyExchange.setExchangeRate(BigDecimal.ONE);
        currencyExchange.setUnitCurrency("US");
        // and
        final var merchantDetails = new OBMerchantDetails1();
        merchantDetails.setMerchantName("Marty");
        // and
        final var obTransaction = new OBTransaction6();
        obTransaction.setAccountId("123567");
        obTransaction.setAmount(amount);
        obTransaction.setCurrencyExchange(currencyExchange);
        obTransaction.setValueDateTime(OffsetDateTime.now());
        obTransaction.setCreditDebitIndicator(OBCreditDebitCode1.CREDIT);
        obTransaction.setMerchantDetails(merchantDetails);

        // when
        final var converted = subject.convert(obTransaction);

        // then
        assertThat(converted)
                .hasFieldOrPropertyWithValue("accountNumber", "123567")
                .hasFieldOrPropertyWithValue("amount", "123")
                .hasFieldOrPropertyWithValue("currency", "US")
                .hasFieldOrPropertyWithValue("type", OBCreditDebitCode1.CREDIT.getValue())
                .hasFieldOrPropertyWithValue("merchantName", "Marty")
                .extracting("date")
                .asInstanceOf(InstanceOfAssertFactories.LOCAL_DATE_TIME)
                .isEqualToIgnoringSeconds(LocalDateTime.now());
    }
}
