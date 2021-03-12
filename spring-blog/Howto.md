How to implement
================

1 - Configure Spring Security
-----------------------------
* Add `spring-boot-starter-security` and `spring-security-test` dependencies.
* Create class config.SecurityConfig extends WebSecurityConfigurerAdapter.
* Override configure(HttpSecurity):
    * `.csrf().disable()` - do not need
    * `.authorizeRequests().antMatchers("/api/auth/**").permitAll()` - permit for authentication
    * `.anyRequest().authenticated();` - any other request should be authenticated.
* Create controller to check authentication (controller.AuthController).
* Create DTO for registering (dto.RegisterRequest).
* Create AuthService to signup and save the new user.
* Run application with testing POST request to create the first user.
