package io.github.davimca25.processors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.github.davimca25")
public class ProcessorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessorsApplication.class, args);
    }

}
