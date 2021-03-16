package com.example.springblog.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Key;

/**
 * Responsible for creating JWT tokens after successful authentication.
 */
@Slf4j
@Service
public class JwtProvider {

    private Key key;
    private JwtParser jwtParser;

    @PostConstruct
    public void init() {
        log.trace("init()");
        key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public String generateToken(Authentication authentication) {
        log.trace("generateToken(Authentication)");
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String jwt) {
        log.trace("validateToken(String) with {}", jwt);
        jwtParser.parseClaimsJws(jwt);  // if executes without errors then the token is valid
        return true;
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = jwtParser.parseClaimsJws(token).getBody();
        String subject = claims.getSubject();
        log.trace("getUsernameFromJWT({}) returns {}", token, subject);
        return subject;
    }
}
