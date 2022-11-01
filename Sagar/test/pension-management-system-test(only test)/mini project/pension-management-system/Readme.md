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

request POST 'localhost:8080/add' \
--header 'Content-Type: application/json' \
--data-raw
'{
"id":1001,
"name":"Sagar",
"age":21,
"bal":100000,
"contact":9191919191,
"empStatus":"R",
"penStatus":"Y",
"lastPension":"21/09/2022",
"installment":11000
}'

# Get data: 

Get all data
request GET 'localhost:8080/all/employee'

Get data by id
request GET 'localhost:8080/employee/{id}'

# Update data:

request PUT 'localhost:8080/update'

# Remove Data:

request DELETE 'localhost:8080/delete/pension/{id}'

# Check Status:

For Employment Status
request GET 'localhost:8080/empStatus/{id}'

For Pension Status
request GET 'localhost:8080/penStatus/{id}'

# Add money in pension acc:

request PUT 'localhost:8080/add/penAmt'

# Check balance:

request GET 'localhost:8080/getBalance/{id}'

# Approve application:

request PUT 'localhost:8080/approve/{id}'

# Issue pension:

request PUT 'localhost:8080/issue/pension/{id}'

# Get last pension date:

request GET 'localhost:8080//lastPension'

# Create docker image

docker-compose -f docker-compose-mysql.yml up -d
