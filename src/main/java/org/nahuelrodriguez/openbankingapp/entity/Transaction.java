package org.nahuelrodriguez.openbankingapp.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Transaction implements Serializable {
    private String type;
    private LocalDateTime date;
    private String accountNumber;
    private String currency;
    private String amount;
    private String merchantName;
    private String merchantLogo;
}
