package com.ali.sourcesocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SourceSocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SourceSocketApplication.class, args);
    }

}
