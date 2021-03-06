# Sample REST  API with Spring Boot, Mysql, and JPA 
## Steps to Setup

**1. Clone the application**

```bash
https://github.com/pudi1975/Suburbs.git
```

**2. Create Mysql database**
```bash
create database user_database
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/suburb-names-management-system-0.0.1-SNAPSHOT.jar

```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following APIs.

    GET http://localhost:8080/api/v1/suburbName/2145-2155
    
    POST http://localhost:8080/api/v1/suburbs
    