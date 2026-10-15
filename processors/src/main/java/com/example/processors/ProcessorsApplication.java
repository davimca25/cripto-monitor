package com.example.processors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class ProcessorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessorsApplication.class, args);
    }

}
