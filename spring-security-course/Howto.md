How-to
======

1 - Implement Basic Auth
------------------------
* Add package security
* Add ApplicationSecurityConfig class 
* Annotate it @Configuration, @EnableWebSecurity
* Extend from WebSecurityConfigurerAdapter
* Override configure(HttpSecurity)
* Add `http.authorizeRequests().anyRequest().authenticated().and().httpBasic();`
* It works, but you cannot logout, because username and password are sent in every request.
