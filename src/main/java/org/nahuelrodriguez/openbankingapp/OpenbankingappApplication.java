package org.nahuelrodriguez.openbankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OpenbankingappApplication {
    public static void main(final String[] args) {
        SpringApplication.run(OpenbankingappApplication.class, args);
    }
}
