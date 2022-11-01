# Create project

``` 
https://start.spring.io/
```

# Build the project

``` 
mvn clean install
```

# Build docker

...
mvn install dockerfile:build
...

# Run application

``` 
mvn spring-boot:run
```

# Testing the application

(Using Postman)

# 1.Creating Applicant (Admin operation)
POST 
``` 
http://localhost:8083/create/applicant
``` 
Accept: application/json
Content-type: application/json
Body:
``` 
{
   "id":5,
"name":"sri5",
"age":"24",
"phone":79787216,
"empStatus":"A",
"balance":1000,
"pensionStatus":"N",
"pensionmmyy":"28-june-22",
"installment":1000
}
``` 

# 2.Editing Applicant details (Admin operation)
POST
```
http://localhost:8083/edit/applicant
```
Accept: application/json
Content-type: application/json
Body:
``` 
{
"id":5,
"name":"sri T",
"age":"24",
"phone":79787216,
"empStatus":"A",
"balance":1000,
"pensionStatus":"N",
"pensionmmyy":"28-june-22",
"installment":1000
}
``` 
# 3.Approve the pension application if empStatus is R, i.e., retired (Admin operation)
POST
``` 
http://localhost:8083/approve/1
``` 

# 4.Issue Pensions for all Retired employees (Admin operation)
POST
``` 
http://localhost:8083/issuePension
``` 

# 5.Load Pensions for all Active employees (Admin operation)
POST
``` 
http://localhost:8083/loadPension
``` 

# 6. Check Balance (User operation)
GET 
``` 
http://localhost:8083/checkBalance/8
``` 

# 7. Check Status (User operation)
GET
``` 
http://localhost:8083/checkStatus/1
``` 

# 8. Check Application Information (User operation)

GET
``` 
http://localhost:8083/checkApplication/7
``` 

# Extra operations for testing

Fetch All Applications
GET
``` 
http://localhost:8083/get/applicants
``` 

Delete application
DELETE
``` 
http://localhost:8083/delete/applicant/11
``` 