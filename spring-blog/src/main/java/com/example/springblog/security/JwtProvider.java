package com.example.springblog.security;

import com.example.springblog.exceptions.SpringBlogException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * Responsible for creating JWT tokens after successful authentication.
 */
@Slf4j
@Service
public class JwtProvider {

    private KeyStore keyStore;
    private JwtParser jwtParser;

    @PostConstruct
    public void init() {
        log.trace("init()");
        try {
            keyStore = KeyStore.getInstance("JKS");
            try (InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks")) {
                keyStore.load(resourceAsStream, "secret".toCharArray());
            }
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
            throw new SpringBlogException("Exception occurred while loading keystore", e);
        }

        jwtParser = Jwts.parserBuilder().setSigningKey(getPublicKey()).build();
    }

    public String generateToken(Authentication authentication) {
        log.trace("generateToken(Authentication)");
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(getPrivateKey())
                .compact();
    }

    public boolean validateToken(String jwt) {
        log.trace("validateToken(String) with {}", jwt);
        jwtParser.parseClaimsJws(jwt);  // if executes without errors then the token is valid
        return true;
    }

    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("springblog", "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new SpringBlogException("Exception occurred while retrieving private key from keystore", e);
        }
    }

    private PublicKey getPublicKey() {
        try {
            return keyStore.getCertificate("springblog").getPublicKey();
        } catch (KeyStoreException e) {
            throw new SpringBlogException("Exception occurred while retrieving public key from keystore", e);
        }
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = jwtParser.parseClaimsJws(token).getBody();
        String subject = claims.getSubject();
        log.trace("getUsernameFromJWT({}) returns {}", token, subject);
        return subject;
    }
}
