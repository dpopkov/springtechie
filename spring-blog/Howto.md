How to implement
================

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
