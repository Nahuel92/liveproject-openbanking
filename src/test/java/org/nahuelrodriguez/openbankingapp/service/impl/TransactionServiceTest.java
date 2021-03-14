package org.nahuelrodriguez.openbankingapp.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionServiceTest {
    private TransactionServiceImpl subject;

    @BeforeEach
    void setUp() {
        //subject = new TransactionServiceImpl();
    }

    @Test
    @Disabled("Until I get more insight on how to manage the webClient endpoing")
    void findAllByAccountNumber() {
        assertThat(subject.findAllByAccountNumber("")).hasSizeGreaterThan(0);
    }
}
