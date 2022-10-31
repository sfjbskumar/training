# Create project

``` 
https://start.spring.io/
```

# Build the project

``` 
mvn clean install
```

# Run docker

...
docker-compose -f docker-compose-mysql.yml up -d
...

# Run application

``` 
mvn spring-boot:run
```

# Testing the application
Save Data:

curl --location --request POST 'localhost:8083/create' \
--header 'Content-Type: application/json' \ 
--Basic Auth 'Give username and password' \
--data-raw '{
"id":5,
"name":"sri5",
"age":"24",
"phone":79787216,
"empStatus":"A",
"balance":1000,
"pensionStatus":"N",
"pensionmmyy":"28-june-22",
"installment":1000
}'

Get data:
curl --location --request GET 'localhost:8083//pensions'

Update data:

curl --location --request PUT 'localhost:8083/edit'

Remove Data:

curl --location --request DELETE 'localhost:8083/pension/{id}'
