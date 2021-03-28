package org.nahuelrodriguez.openbankingapp.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nahuelrodriguez.openbankingapp.adapter.TransactionApiClient;
import org.nahuelrodriguez.openbankingapp.entity.Transaction;
import org.nahuelrodriguez.openbankingapp.repository.MerchantDetailsRepository;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @InjectMocks
    private TransactionServiceImpl subject;

    @Mock
    private TransactionApiClient transactionApiClient;

    @Mock
    private MerchantDetailsRepository merchantDetailsRepository;

    @Test
    void when_tx_is_returned_by_api_client_then_enrich_it_with_merchant_logo() {
        // given
        final var accountNumber = "123456";
        final var merchantName = "acme";
        // and
        final var transaction = new Transaction();
        transaction.setMerchantName(merchantName);
        transaction.setAccountNumber(accountNumber);
        // and
        doReturn(Collections.singletonList(transaction)).when(transactionApiClient).getTransactions(any());
        doReturn("acme-logo.png").when(merchantDetailsRepository).getMerchantLogo(merchantName);

        // when
        final var txsByAccountNumber = subject.findAllByAccountNumber(accountNumber);

        // then
        assertThat(txsByAccountNumber).hasSize(1)
                .asList()
                .extracting("merchantLogo")
                .contains("acme-logo.png");
    }
}
