package com.pizzeria.springdatajpa.web.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    private static String SECRET_KEY = "@@edwingqgq123$$";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);
    public String crete(String username){
        return JWT.create()
                .withSubject(username)
                .withIssuer("pizzeria")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis()+ TimeUnit.DAYS.toMillis(15)))
                .sign(ALGORITHM);
    }
}

