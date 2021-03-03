package com.example.demo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Random;

import static com.example.demo.security.ApplicationUserRole.*;

@Slf4j
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        final UserDetails adminUser = createUserDetails("admin", "pass1", ADMIN);
        final UserDetails aliceUser = createUserDetails("alice", "pass2", STUDENT);
        return new InMemoryUserDetailsManager(
                aliceUser,
                adminUser
        );
    }

    /** This random used just for research when restarting the app. It may be removed later. */
    private final Random random = new Random();

    private UserDetails createUserDetails(String name, String password, ApplicationUserRole role) {
        password += random.nextInt(10);

        log.trace("######### Creating details for user {} with password {}", name, password);
        return User.builder()
                .username(name)
                .password(passwordEncoder.encode(password))
                .roles(role.name())
                .build();
    }
}
