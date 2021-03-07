package org.nahuelrodriguez.openbankingapp.controller;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nahuelrodriguez.openbankingapp.service.impl.TransactionServiceImpl;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.hasItem;

class TransactionControllerIntegrationTest {
    @BeforeEach
    void setUp() {
        final var subject = new TransactionController(new TransactionServiceImpl());
        RestAssuredMockMvc.standaloneSetup(subject);
    }

    @Test
    void TransactionComponentTest() {
        given().
        when().
            get("/transactions/{accountNumber}", "1234").
        then().
            status(HttpStatus.OK).
            contentType(ContentType.JSON).
            body("accountNumber", hasItem(1234)).
            body("amount", hasItem("1500"));
    }
}
