package org.nahuelrodriguez.openbankingapp.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {
    private TransactionServiceImpl subject;

    @BeforeEach
    void setUp() {
        subject = new TransactionServiceImpl();
    }

    @Test
    void findAllByAccountNumber() {
        assertThat(subject.findAllByAccountNumber("")).hasSizeGreaterThan(0);
    }
}
