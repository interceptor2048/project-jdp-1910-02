package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.Setter;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalTime;
import java.util.Random;

@Getter
@Setter
public class Token {
    private String generatedToken;
    private LocalTime generated;
    private LocalTime expires;

    private Random rand = SecureRandom.getInstanceStrong();

    public Token(LocalTime generated, LocalTime expires) throws NoSuchAlgorithmException {
        this.generatedToken = generateToken(15);
        this.generated = generated;
        this.expires = expires;
    }

    private String generateToken(int tokenLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokenLength; i++) {
            if (this.rand.nextBoolean()) {
                sb.append((char) (97 + this.rand.nextInt(25)));
            } else {
                sb.append((char) (48 + this.rand.nextInt(10)));
            }
        }
        return sb.toString();
    }
}
