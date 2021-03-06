package com.example.demo.auth;

import com.example.demo.security.ApplicationUserRole;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;
    private final List<ApplicationUser> users;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        users = createApplicationUsers();
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return users
                .stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    private List<ApplicationUser> createApplicationUsers() {
        return Lists.newArrayList(
                createUserDetails("admin", "pass11", ApplicationUserRole.ADMIN),
                createUserDetails("tom", "pass11", ApplicationUserRole.ADMINTRAINEE),
                createUserDetails("alice", "pass22", ApplicationUserRole.STUDENT)
        );
    }

    private ApplicationUser createUserDetails(String name, String password, ApplicationUserRole role) {
        log.trace("######### Creating user {} with password {}", name, password);
        return new ApplicationUser(name, passwordEncoder.encode(password), role.getGrantedAuthorities());
    }
}
