package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.publisher.TestPublisher;

@SpringBootTest
public class ServiceTestPublisher {

    @Test
    void testPublisher(){
        TestPublisher
                .<String>create()
                .next("Primero", "Segundo", "Tercero")
                .error(new RuntimeException("Message"));

    }

}
