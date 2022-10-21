##add this in dependencies of pom.xml 
```
	<!-- mongodb -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>
		<!-- mongodb -->

# add this line in repo class of student
extends MongoRepository<Customer, String>{

## Run the app to install mongo

``

docker-compose -f docker-compose-mongo.yml up -d
mvn clean install
mvn spring-boot:run

##to down

docker-compose -f docker-compose-mongo.yml down

```

docker exec -it third-mongo-spring-data_mongo_1 bash

mongo

show dbs

show tables

db.customer.find()
d
docker