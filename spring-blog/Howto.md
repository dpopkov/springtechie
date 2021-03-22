How to implement
================

7 - JWT using Public and Private Key
------------------------------------
* Implement Asymmetric Encryption using Java Keystore:
    * create keystore: 
        * `keytool -genkey -alias springblog -keyalg RSA -keystore springblog.jks -keysize 2048`
        * `keytool -importkeystore -srckeystore springblog.jks -destkeystore springblog.jks -deststoretype pkcs12`
        * copy springblog.jks to resources folder
    * use keystore in JwtProvider
        * create field KeyStore
        * add methods getPrivateKey() and getPublicKey()
        * use private key for token generation and public key for token validation

6 - Fix Authentication
----------------------
* create class AuthenticationResponse
* fix login methods in AuthController and AuthService

5 - Implement CORS
------------------
* create @Configuration @EnableWebMvc class WebConfig implements WebMvcConfigurer
* override addCorsMappings(CorsRegistry) method.

4 - Manage Posts
----------------
* create class PostController
* create class PostDto
* create @Service class PostService
* add method getCurrentUser() to AuthService
* use PostRepository in PostService
* use PostService in PostController to create post
* implement createPost(@RequestBody PostDto) method in PostController
* add methods showAllPosts() and getSinglePost(id) to PostController
* implement methods getAllPosts() and findById(id) in PostService

3 - Validate JWT
----------------
* create class JwtAuthenticationFilter extends OncePerRequestFilter
* override method doFilterInternal
* implement method getJwtFromRequest(HttpServletRequest)
* add method validateToken(String) to JwtProvider
* use jwtProvider and userDetailsService in doFilterInternal method in JwtAuthenticationFilter
* add jwtAuthenticationFilter() bean method to SecurityConfig
* register JwtAuthenticationFilter in method configure in SecurityConfig

2 - Implement Login using JWT
-----------------------------
* Implement end point to login:
    * add DTO LoginRequest
    * add login(LoginRequest) method to AuthController
    * add login(LoginRequest) method to AuthService
    * add configureGlobal(AuthenticationManagerBuilder) method to SecurityConfig
    * create @Service class UserDetailsServiceImpl implements UserDetailsService
    * add method findByUserName(String) to UserRepository
    * override authenticationManagerBean() method in SecurityConfig
    * add AuthenticationManager field to AuthService and use it in login method
    * add jjwt dependency to pom.xml
    * create package 'security'
    * create class JwtProvider and add JwtProvider field to AuthService
    * use it to generate token 

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
* Provide PasswordEncoder bean (BCryptPasswordEncoder).
