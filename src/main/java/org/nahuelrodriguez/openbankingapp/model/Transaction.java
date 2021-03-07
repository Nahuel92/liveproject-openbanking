package org.nahuelrodriguez.openbankingapp.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transaction {
    private String type;
    private LocalDateTime date;
    private Long accountNumber;
    private String currency;
    private String amount;
    private String merchantName;
    private String merchantLogo;
}
