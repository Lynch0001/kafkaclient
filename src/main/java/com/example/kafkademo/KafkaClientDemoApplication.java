package com.example.kafkademo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class KafkaClientDemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(KafkaClientDemoApplication.class, args);

    }
}
