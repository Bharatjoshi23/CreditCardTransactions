package com.example.transactions;

import com.example.transactions.enums.FeeEvent;
import com.example.transactions.enums.GroupingCalculationType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionsApplication.class, args);
    }

}
