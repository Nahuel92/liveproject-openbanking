package org.nahuelrodriguez.openbankingapp.controller;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.hasItem;

class TransactionControllerIntegrationTest {
    @BeforeEach
    void setUp() {
        // TODO fix this
        final var subject = new TransactionController(null);
        RestAssuredMockMvc.standaloneSetup(subject);
    }

    @Test
    @Disabled("Until I get more insight on how to manage the webClient endpoing")
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
