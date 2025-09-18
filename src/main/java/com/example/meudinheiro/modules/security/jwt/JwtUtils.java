package com.example.meudinheiro.modules.security.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.meudinheiro.modules.user.useCases.UserDetailsImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
    
    @Value("${meudinheiro.jwtSecret}")
    private String jwtSecret;

    @Value("${meudinheiro.jwtExpirationMs}")
    private Long jwtExpirationMs;

    public String generateTokenFromUser (UserDetailsImpl userDetail) {
        Key key = getSigninKey();

        return Jwts.builder()
                .subject(userDetail.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(key)
                .compact();
    }   

    public SecretKey getSigninKey() {
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        return key;
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().verifyWith(getSigninKey()).build().parseSignedClaims(authToken);
            return true;
        } catch(Exception e) {
            System.out.println("Token inválido" + e.getMessage());
        } 

        return false;
    }
}
