Steps of Implementation
=======================

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
