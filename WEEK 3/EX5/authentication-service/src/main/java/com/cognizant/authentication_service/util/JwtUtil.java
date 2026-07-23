package com.cognizant.authentication_service.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    // Secret key must be at least 32 characters long for HS256
    private static final String SECRET =
            "mysecretkeymysecretkeymysecretkey12";

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String extractUser(String authorizationHeader) {

        String base64Credentials =
                authorizationHeader.substring("Basic ".length());

        byte[] decodedBytes =
                java.util.Base64.getDecoder().decode(base64Credentials);

        String credentials = new String(decodedBytes);

        return credentials.split(":")[0];
    }

    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000))
                .signWith(key)
                .compact();
    }
}