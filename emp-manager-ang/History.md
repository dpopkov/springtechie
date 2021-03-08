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
