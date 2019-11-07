package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Random;

@Getter
@Setter
public class Token {
    private String token;
    private LocalTime generated;
    private LocalTime expires;

    public Token(LocalTime generated, LocalTime expires) {
        this.token = generateToken(15);
        this.generated = generated;
        this.expires = expires;
    }

    private String generateToken(int tokenLength) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokenLength; i++) {
            if (random.nextBoolean()) {
                sb.append((char) (97 + random.nextInt(25)));
            } else {
                sb.append((char) (48 + random.nextInt(10)));
            }
        }
        return sb.toString();
    }
}
