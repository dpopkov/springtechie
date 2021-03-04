How-to
======

7 - Permission Based Authentication
-----------------------------------
* Add admin-trainee role to ApplicationUserRole.
* Add user details for him to userDetailsService().
* Add StudentManagementController class annotated @RestController, @RequestMapping for management.
* Implement and map methods in StudentManagementController.
* Disable CSRF in ApplicationSecurityConfig.
* Option 1: use `antMatchers(httpMethod, pattern)` with `hasAuthority("permissionName")` in ApplicationSecurityConfig.
* Order of antMatchers does matter!
* Add Authorities to Users: implement `getGrantedAuthorities()` in ApplicationUserRole, update building user details.

6 - Role based Authentication
-----------------------------
* Add `antMatchers("url").hasRole("role")` to configure() in ApplicationSecurityConfig.
* Now only STUDENT is allowed to access "/api".

5 - Roles and Permissions using Enum
------------------------------------
* Add user in ApplicationSecurityConfig with role ADMIN.
* Add enum ApplicationUserPermission that should contain all possible permissions.
* Add guava dependency for helper methods.
* Add enum ApplicationUserRole containing set of ApplicationUserPermission values.
* Attach the roles to UserDetails in ApplicationSecurityConfig.
* At this point the Roles are not used to secure API yet.

4 - Password Encoding with BCrypt
---------------------------------
* Add security.PasswordConfig class, annotate it with @Configuration.
* Add method `passwordEncoder()` returning PasswordEncoder and annotated with @Bean.
* Return instance of BCryptPasswordEncoder.
* Add field `PasswordEncoder passwordEncoder` to ApplicationSecurityConfig and constructor.
* Use this passwordEncoder to encode password for UserDetails in method `userDetailsService()`.

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
