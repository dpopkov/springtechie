Steps of Implementation
-----------------------

1. Create model Employee.
2. Create service EmployeeService.
3. Add HttpClientModule to app.modules.ts.
4. Use EmployeeService in AppComponent.
5. Display received Employees in app.component.html.
6. Create `apiBaseUrl` field in environment.ts and use it EmployeeService.
7. Add EmployeeService to providers in app.module.ts (not sure about it because EmployeeService is Injectable).
8. Configure Cross-Origin Resource Sharing (CORS) on Back-End.
9. Add UI to Front-End.
10. Add UI Modal logic.
11. Add FormsModule to app.module.ts.
12. Use #addForm as reference to the form and (ngSubmit) to specify handling method.
13. Implement method `onAddEmployee(NgForm)`.
