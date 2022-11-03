# Create project

``` 
https://start.spring.io/
```

# Build the project

``` 
mvn clean install
```

# Run application

``` 
mvn spring-boot:run
```

# Testing the application

(Using Postman)

# 1.Creating Applicant (Admin's operation)
POST 
``` 
http://localhost:8082/create/applicant
``` 
Accept: application/json
Content-type: application/json
Body:
``` 
{
    "id": 105,
    "name": "Alisha",
    "age": 22,
    "balance": 11990,
    "mobile": "9949586034",
    "empStatus": "A",
    "pensionStatus": "N",
    "pensionMMYY": "0822",
    "installment": 1000
}
``` 

# 2.Editing Applicant details (Admin's operation)
POST
```
http://localhost:8082/edit/applicant
```
Accept: application/json
Content-type: application/json
Body:
``` 
{
    "id": 105,
    "name": "Alisha",
    "age": 22,
    "balance": 11990,
    "mobile": "9949586034",
    "empStatus": "A",
    "pensionStatus": "N",
    "pensionMMYY": "0822",
    "installment": 1000
}
``` 
# 3.Approve the pension application if empStatus is R, i.e., retired (Admin's operation)
POST
``` 
http://localhost:8082/approve/105
``` 

# 4.Issue Pensions for all Retired employees (Admin's operation)
POST
``` 
http://localhost:8082/issuePension
``` 

# 5.Load Pensions for all Active employees (Admin's operation)
POST
``` 
http://localhost:8082/loadPension
``` 

# 6. Check Balance (User's operation)
GET 
``` 
http://localhost:8082/checkBalance/105
``` 

# 7. Check Status (User's operation)
GET
``` 
http://localhost:8082/checkStatus/105
``` 

# 8. Check Application Information (User's operation)

GET
``` 
http://localhost:8082/checkApplication/105
``` 

# Extra operations for testing

Fetch All Applications
GET
``` 
http://localhost:8082/get/applicants
``` 

Delete application
DELETE
``` 
http://localhost:8082/delete/applicant/101
``` 