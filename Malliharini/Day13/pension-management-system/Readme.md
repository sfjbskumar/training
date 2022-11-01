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
http://localhost:8081/create/applicant
``` 
Accept: application/json
Content-type: application/json
Body:
``` 
{
    "id":3,
    "name":"harini",
    "age":20,
    "balance":10000,
    "mobile":"9888923422",
    "empStatus":"R",
    "pensionStatus":"N",
    "pensionMMYY":"0122",
    "installment":1000
}
``` 

# 2.Editing Applicant details (Admin's operation)
POST
```
http://localhost:8081/edit/applicant
```
Accept: application/json
Content-type: application/json
Body:
``` 
{
    "id":3,
    "name":"harini",
    "age":22,
    "balance":10000,
    "mobile":"9888923422",
    "empStatus":"R",
    "pensionStatus":"N",
    "pensionMMYY":"0122",
    "installment":1000
}
``` 
# 3.Approve the pension application if empStatus is R, i.e., retired (Admin's operation)
POST
``` 
http://localhost:8081/approve/3
``` 

# 4.Issue Pensions for all Retired employees (Admin's operation)
POST
``` 
http://localhost:8081/issuePension
``` 

# 5.Load Pensions for all Active employees (Admin's operation)
POST
``` 
http://localhost:8081/loadPension
``` 

# 6. Check Balance (User's operation)
GET 
``` 
http://localhost:8081/checkBalance/3
``` 

# 7. Check Status (User's operation)
GET
``` 
http://localhost:8081/checkStatus/3
``` 

# 8. Check Application Information (User's operation)

GET
``` 
http://localhost:8081/checkApplication/3
``` 

# Extra operations for testing

Fetch All Applications
GET
``` 
http://localhost:8081/get/applicants
``` 

Delete application
DELETE
``` 
http://localhost:8081/delete/applicant/3
``` 

# build docker file
```
mvn install dockerfile:build
```
# Run Docker
```
docker-compose -f docker-compose-mysql.yml up -d
```
#docker login
```
 docker push <malliharini>/pension-management-system:0.0.1-SNAPSHOT
```
# Getting inside container
``` 
docker exec -it <container-id>/bash
```
### Running the application in docker container

```
 docker run -p 8080:8080 malliharini/pension-management-system:0.0.1-SNAPSHOT

```
# docker pull and up
```
docker pull malliharini/pension-management-system:0.0.1-SNAPSHOT

docker-compose  up

```
## Looking docker image
```
docker exec -it <img id> bash
```

