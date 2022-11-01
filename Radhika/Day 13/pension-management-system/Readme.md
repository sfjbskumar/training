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
Save Data:

curl --location --request POST 'localhost:8088/createApplicant' \
--header 'Content-Type: application/json' \
--data-raw '
{
"id":1,
"name":"Harshit",
"age":22,
"balance":100000,
"mobile":98889955,
"empStatus":"R",
"pensionStatus":"N",
"pensionMMYY":"09-22",
"installment":10000
}

# Admin Oprations

# Create a Applicant

http://localhost:8088/createApplicant

# Edit Applicant's details

http://localhost:8088/editApplicant

# Issue Pension to Employees

http://localhost:8088/issuePension

# Load Balance to Employees

http://localhost:8088/loadBalance

# Approve pension

http://localhost:8088/approve

# User Operations

# Check Pension Status

http://localhost:8088/checkStatus/{id}

# Check Balance status

http://localhost:8088/checkBalance/{id}

# Check Application details

http://localhost:8088/checkApplication/{id}