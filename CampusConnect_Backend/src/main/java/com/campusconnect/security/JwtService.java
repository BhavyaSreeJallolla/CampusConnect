package com.campusconnect.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {


    private static final String SECRET_KEY =
            "CampusConnectSecretKeyForJwtAuthentication2026";


    private final SecretKey key =
            Keys.hmacShaKeyFor(
                    SECRET_KEY.getBytes()
            );



    // Generate JWT Token

    public String generateToken(
            String email,
            String role) {


        return Jwts.builder()

                .subject(email)

                .claim(
                    "role",
                    role
                )

                .issuedAt(
                    new Date()
                )

                .expiration(
                    new Date(
                        System.currentTimeMillis()
                        + 1000 * 60 * 60 * 24
                    )
                )

                .signWith(key)

                .compact();
    }





    // Get Email from Token

    public String extractUsername(
            String token) {


        return extractClaims(token)
                .getSubject();

    }





    // Get Role from Token

    public String extractRole(
            String token) {


        return extractClaims(token)
                .get(
                  "role",
                  String.class
                );

    }





    // Validate Token

    public boolean validateToken(
            String token,
            String email) {


        return extractUsername(token)
                .equals(email)

                &&
                !isTokenExpired(token);

    }





    private boolean isTokenExpired(
            String token) {


        return extractClaims(token)
                .getExpiration()
                .before(
                    new Date()
                );

    }





    private Claims extractClaims(
            String token) {


        return Jwts.parser()

                .verifyWith(key)

                .build()

                .parseSignedClaims(token)

                .getPayload();

    }

}