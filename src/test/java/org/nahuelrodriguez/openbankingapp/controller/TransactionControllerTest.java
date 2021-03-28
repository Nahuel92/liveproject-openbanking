package org.nahuelrodriguez.openbankingapp.controller;

import org.junit.jupiter.api.Test;
import org.nahuelrodriguez.openbankingapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean // We are replacing the real object with a mock as we do not want to test end-to-end here.
    private TransactionService transactionService;

    @Test
    void when_unauthenticated_an_unauthorized_response_should_be_returned() throws Exception {
        mockMvc.perform(get("/transactions/123456")
                .header("Authorization", "Bearer ")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void when_valid_username_and_password_are_used_an_ok_response_should_be_returned() throws Exception {
        mockMvc.perform(get("/transactions/123456")
                .header("Authorization", "Bearer " + getAuthToken())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    private String getAuthToken() throws Exception {
        final var response = mockMvc.perform(post("/oauth/token")
                .params(createAuthRequestParameters())
                .with(httpBasic("openBankingApp", "t0p53cr3t"))
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        return new JacksonJsonParser()
                .parseMap(response)
                .get("access_token")
                .toString();
    }

    private LinkedMultiValueMap<String, String> createAuthRequestParameters() {
        final var params = new LinkedMultiValueMap<String, String>();
        params.add("grant_type", "password");
        params.add("client_id", "openBankingApp");
        params.add("username", "Mike");
        params.add("password", "12345");
        return params;
    }
}
