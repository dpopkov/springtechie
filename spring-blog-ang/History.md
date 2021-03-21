Steps of Implementation
=======================

3 - Implement Login
-------------------
* Add Router to constructor in RegisterComponent 
* Use it in onSubmit method to go to RegisterSuccessComponent: `navigateByUrl('/register-success')`
* Add path to RegisterSuccessComponent in app.module.ts
* Add html to RegisterSuccessComponent
* Add html and create loginForm group in LoginComponent.
* Add onSubmit() method LoginComponent.
* Create class LoginPayload, and add field to LoginComponent.
* Add AuthService parameter to LoginComponent.
* Add method login(LoginPayload) to AuthService.
* Create class JwtAuthResponse.
* Add ngx-webstorage to package.json.
* Add LocalStorageService parameter to AuthService and use it in login method.
* Add NgxWebstorageModule to app.module.ts
* Add `href="/login"` to header component html.
* Init loginPayload in LoginComponent constructor.

2 - Implement Registration
--------------------------
* Create component Register: `ng g c auth/register --skipTests`
    * Create registration form in register.component.html
    * Add FormsModule and ReactiveFormsModule to app.module.ts
    * Add formControlName directives to all fields in register.component.html form
    * Add formGroup directive to register.component.html form
    * Assign registerForm, declare the fields in register.component.ts, add method onSubmit()
    * Create class RegisterPayload and ass as field to Register component
    * Create AuthService to send register data to back-end: `ng g s auth --skipTests`.
    * Add HttpClientModule to app.module.ts
    * Add HttpClient parameter to AuthService constructor.
    * Add method register to AuthService.
    * Add parameter AuthService to RegisterComponent constructor and use it in onSubmit() method.
    * Add `RouterModule.forRoot([{path: 'register', component: RegisterComponent}])` to app.module.ts
    * Add href="/register" to register link in header.component.html
    * Add `<router-outlet></router-outlet>` to app.component.html
* Create component Login: `ng g c auth/login --skipTests`
* Create component RegisterSuccess: `ng g c auth/register-success --skipTests`

1- Add Header component
-----------------------
* Install Bootstrap: `npm i --save bootstrap`
* Create component Header: `ng g c header --skipTests`
* Add css properties to styles.css
* Create html template for Header component and add it to App component.
* Add css to Header style.
* Add link to Bootstrap to styles.css.
