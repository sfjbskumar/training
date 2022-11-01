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

curl --location --request POST 'localhost:8081/save/student' \
--header 'Content-Type: application/json' \
--data-raw '{
"id":23 ,
"age":90 ,
"name":"siva" ,
"balance":5000 ,
"phone":978566643 ,
"empstatus":"W" ,
"penstatus":"Y" ,
"penmmyy":"07/22" ,
"installment":1000
}'

Get data:
curl --location --request GET 'localhost:8088/pensions'

Update data:

curl --location --request PUT 'localhost:8088/issue_Pension'

Remove Data:

curl --location --request DELETE 'localhost:8088/deletePension?id=1'
