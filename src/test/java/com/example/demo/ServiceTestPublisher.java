package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;
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

    @Test
    void testUpperCase() {
        final TestPublisher<String> testPublisher = TestPublisher.create();
            UppercaseConverter uppercaseConverter = new UppercaseConverter(testPublisher.flux());
            StepVerifier.create(uppercaseConverter.getUpperCase())
                    .then(() -> testPublisher.emit("datos", "GeNeRaDoS", "Sofka"))
                    .expectNext("DATOS", "GENERADOS", "SOFKA")
                    .verifyComplete();
    }
}
