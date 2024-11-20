package com.mensageria.mensageria_12;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mensageria12Application implements CommandLineRunner {
    private final Producer producer;

    public Mensageria12Application(Producer producer) {
        this.producer = producer;
    }

    public static void main(String[] args) {
        SpringApplication.run(Mensageria12Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        producer.sendMassiveMessages();
    }
}
