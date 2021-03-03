How-to
======

3 - In Memory User Details Manager
----------------------------------
* In ApplicationSecurityConfig override `userDetailsService()`, add `@Bean` annotation to the method.
* Use `org.springframework.security.core.userdetails.User` builder to add username, password, roles
* Create and return `InMemoryUserDetailsManager` instance.
* This is __not working__ because there is no PasswordEncoder mapped yet.

2 - Use Ant Matchers
--------------------
* In ApplicationSecurityConfig after authorizeRequests() add `antMatchers("url").permitAll()` 

1 - Implement Basic Auth
------------------------
* Add package security
* Add ApplicationSecurityConfig class 
* Annotate it @Configuration, @EnableWebSecurity
* Extend from WebSecurityConfigurerAdapter
* Override configure(HttpSecurity)
* Add `http.authorizeRequests().anyRequest().authenticated().and().httpBasic();`
* It works, but you cannot logout, because username and password are sent in every request.
