package com.app.kata.component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
    @Component
    public class JwtUtil {
        @Value("${jwt.secret}")
        private String SECRET_KEY;

        @Value("${security.jwt.expiration-time}")
        private long expirationTime;

        public String generateToken(String username) {
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // 10 horas
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        }

        public String extractUsername(String token) {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
        }

        public boolean validateToken(String token, String username) {
            return extractUsername(token).equals(username) && !isTokenExpired(token);
        }

        private boolean isTokenExpired(String token) {
            Date expiration = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
            return expiration.before(new Date());
        }
    }
