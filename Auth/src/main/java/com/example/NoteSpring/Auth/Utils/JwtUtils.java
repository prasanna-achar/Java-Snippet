package com.example.NoteSpring.Auth.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

import java.security.SignatureException;
import java.util.Date;


public class JwtUtils {

    private static final String SECRET = "QnL5lWbPNRrF2c3pN4o5f7W2g8u2Zx9pB0q3c6v7t1m2s8r9d0l4f8k2n1p9x0z3";
    // change will be uploaded after some tasks
    private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());


    public  static  String generateToken(String userId){
        return Jwts.builder()
                .setSubject(userId)
                .setIssuer("Auth")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (1000L* 60 * 60 * 24 * 7)))
                .signWith(key)
                .compact();

    }

    public static Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public static String extractUserId(String token) throws SignatureException {
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
