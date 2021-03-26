Steps of Implementation
=======================

6 - Implement Logout
--------------------
* Add Logout button to Header component and css style for it.
* Create logout() method in HeaderComponent.
* Create logout() method in AuthService and use localStorageService to clear stored token and username.
* Use ngIf with ng-template in html to control appearance of Login/Logout.

5 - Display Blog Posts
----------------------
* Add html to Home component.
* Add getAllPosts() method to AddPostService.
* Add AddPostService parameter to HomeComponent constructor, use it to get posts when init.
* Map Home component to root path: `{path: '', component: HomeComponent}`
* Add PostComponent: `ng g c post --skipTests`. 
* Add ActivatedRoute and AddPostService parameters to PostComponent constructor.
* Add method getPost() to AddPostService. 
* Define route in app.modules.ts: `{path: 'post/:id', component: PostComponent}`.

4 - Adding Blog Posts with Editor
---------------------------------
* Create Home page component: `ng g c home --skipTests`
    * Add route for home to app.module.ts
    * Add Router parameter to LoginComponent constructor.
    * Call `router.navigateByUrl("/home")` in onSubmit() method.
* Create 'Add Post' button to Header component.
    * Create helper method in AuthService.
    * Add AuthService parameter to HeaderComponent constructor.
    * Add `*ngIf="authService.isAuthenticated()"` to 'Add Post' div.
    * Add style class new-post for 'Add Post' button.
* Create AddPost component: `ng g c add-post --skipTests`
    * Add route for add-post to app.module.ts
    * Add WYSIWYG editor to add-post page
        * Install TinyMCE editor
            * Add `"@tinymce/tinymce-angular"` dependency to package.json
            * then run npm install when IDE prompts
            * Add EditorModule import to app.module.ts
        * Add html form to app-post page
        * Add css for add-post page
    * Add `[formGroup]` and `[formControlName]` directives to add-post page
    * Create method addPost() and addPostForm, title, body fields in AddPostComponent
    * Create class PostPayload
* Create AddPostService to communicate to backend: `ng g s add-post --skipTests`.
    * Add AddPostService parameter to AddPostComponent constructor
    * Add Router to AddPostComponent constructor, use it in addPost() method.
* Add JWT token before posting new data to server
    * Create class HttpClientInterceptor.
    * Add HttpClientInterceptor to providers in app.module.ts.

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
