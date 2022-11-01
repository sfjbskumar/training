# Create project

``` 
https://start.spring.io/
```

# Build the project

``` 
mvn clean install
```

# Dockerization

docker-compose -f docker-compose-mysql.yml up -d



# Run application

``` 
mvn spring-boot:run
```

# Testing the application
Save Data:

curl --location --request POST 'localhost:8086/create/applicant' \
--header 'Content-Type: application/json' \
--data-raw '{
"id":"101",
"name":"emp1",
"age":"62",
"mobile":"6425424",
"balamt":"1000",
"estatus":"Y",
"pstatus":"R",
"pmonth":"21-11-2022",
"installment":"120"
}'

curl --location --request POST 'localhost:8086/edit/applicant' \
--header 'Content-Type: application/json' \
--data-raw '{
"id":"103",
"name":"emp2",
"age":"52",
"mobile":"2335424",
"balamt":"2000",
"estatus":"R",
"pstatus":"Y",
"pmonth":"2-11-2022",
"installment":"160"
}'


Get data:
curl --location --request GET 'localhost:8086/pension/{id}'

curl --location --request GET 'localhost:8086/checkStatus/{id}'

curl --location --request GET 'localhost:8086/checkBalance/{id}'

curl --location --request GET 'localhost:8086/checkApplication/{id}'


Update data:

curl --location --request PUT 'localhost:8086/issuePension/{id}'

curl --location --request PUT 'localhost:8086/loadPension/{id}'

curl --location --request PUT 'localhost:8086/approve/{id}'

               

                
