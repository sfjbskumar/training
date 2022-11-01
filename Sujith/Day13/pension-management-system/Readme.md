# Create project

```
# Run
```
 docker-compose -f docker-compose-mysql.yml up -d
```

# Build the project

``` 
mvn clean install
```

# Run application

``` 
mvn spring-boot:run
```

Authorization 

Role : ADMIN

username : admin123
password : password


Authorization 

Role : USER

username : user123
password : password

# Testing the application
Save Data:

curl --location --request POST 'localhost:8080/createPension' \
--header 'Content-Type: application/json' \
--data-raw '{
        "id": 1,
        "age": 22,
        "name": "Raman",
        "balance": 100000,
        "phoneNo": 12345,
        "empStatus": "R",
        "penApproval": "Y",
        "penMmYy": "02/2020",
        "installment": 1000
    }'
    
Role : ADMIN

Get data:
curl --location --request GET 'localhost:8080/get/allPension'

Role : ADMIN

curl --location --request GET 'localhost:8080/pension/{id}'

Role : ADMIN

Update data:

curl --location --request PUT 'localhost:8080/editPension'

Role : ADMIN

--header 'Content-Type: application/json' \
--data-raw '{
        "id": 1,
        "age": 25,
        "name": "Raman",
        "balance": 100000,
        "phoneNo": 12345,
        "empStatus": "R",
        "penApproval": "Y",
        "penMmYy": "02/2020",
        "installment": 1000
    }'
    

Remove Data:

curl --location --request DELETE 'localhost:8080/deletePension/{id}'

Role : ADMIN

Issue Pension:

curl --location --request GET 'localhost:8080/issuePension/{id}'


Role : ADMIN

curl --location --request PUT 'localhost:8080/issuePensions'


Role : ADMIN

Load Balance

curl --location --request PUT 'localhost:8080/loadBalance/{id}'


Role : ADMIN

Approval

curl --location --request PUT 'localhost:8080/approve/{id}'


Role : ADMIN

Applicant status

curl --location --request GET 'localhost:8080/applicantStatus/{id}'


Role : USER
Check Balance

curl --location --request GET 'localhost:8080/checkBalance/{id}'


Role : USER

Check Application

curl --location --request GET 'localhost:8080/checkApplication/{id}'


Role : USER
