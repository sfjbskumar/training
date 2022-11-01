# Create project

``` 
https://start.spring.io/
```

# Build the project
mvn clean install

# docker command
docker-compose-mysql.yml up -d

# Run application
mvn spring-boot:run

```
```
# Docker build
mvn install dockerfile:build

# Testing the application
Got to Postman for testing

Only by admin

Save Data/create applicant:
Request: POST 
Url: localhost:8081/create/applicant
Content-Type: application/json 
data-raw :
{
"id" : 3,
"pensinorName": "harshada",
"pensinorAge" : 60,
"balance" : 200000,
"phoneNo" : 9833,
"employmentStatus" : "A",
"pensionStatus" : "N",
"pensionmmyy" : "0422",
"installment" : "2000"
}
Reading data:
1)Get all pensionars information:
Request: GET
Url: localhost:8081/pension

Get pensinor's information by id
Request: GET
Url: localhost:8081/approve/{id}       here {id} should be replaced by a number


Update data:
Request: PUT
Url: localhost:8081/editApplicant
Content-Type: application/json
data-raw :
{
"id" : 2,
"pensinor_Name": "girisha",
"pensinor_Age" : 20,
"balance" : 200000,
"phone_no" : 9833,
"employment_Status" : "A",
"pension_status" : "N",
"pensionmmyy" : "0422",
"installment" : "10000"
}

Issuing Pension:
1) Issue pension by Id:
   Request: PUT
   Url: localhost:8081/issuePensionById/{id}       here {id} should be replaced by a number

2) Issue pension for all eligible pensinors:
   Request: PUT
   Url: localhost:8081/issuePensions       

Load Balance:
1) Load balance by Id:
   Request: PUT
   Url: localhost:8081/loadBalanceById/{id}        here {id} should be replaced by a number

2) Load balance for all eligible applicant:
   Request: PUT
   Url: localhost:8081/loadBalance       

Remove Data:
Delete applicant by Id:
Request: PUT
Url: localhost:8081/delete/applicant/{id}          here {id} should be replaced by a number

By Applicant/ Pensinor

Check Application:
Applicant checks their application:
Request: GET
Url: localhost:8081/checkApplication/{id}          here {id} should be replaced by a number

Check Balance
Applicant checks balance
Request: GET
Url: localhost:8081/checkBalance/{id}              here {id} should be replaced by a number

Applicant checks their employment/pension status
Request: GET
Url: localhost:8081/checkStatus/{id}               here {id} should be replaced by a number