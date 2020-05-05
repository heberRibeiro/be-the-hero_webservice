![](src/main/resources/assets/logo.svg)

### Description
*Data access API for the project "Be The Hero" (11th week Omnistack), which was developed using Spring Boot*

### Project phases

- [x] Paged search
- [x] Enable CORS
- [x] Migrations Flyway
- [ ] Authentication
- [ ] HATEOAS support
- [ ] Swagger support


### Requirements

The project is in the development phase and in this phase a bank in memory is being used, to continue the project it is necessary to have Maven, Java 11, and IDE preferably, in this case Eclipse was used.

* [Java](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
* [Apache Maven](https://maven.apache.org/download.cgi)
* [IDE (for project development)](https://www.eclipse.org/downloads/packages/)

### Technologies

* Java 11
* Spring Boot version: 2.2.6
* Apache Maven version 3.6.3

### Dependencies
The artifact is managed in org.springframework.boot:spring-boot-dependencies:2.2.6.RELEASE

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

```
```
<dependency>
    <groupId>com.h2database</groupId>
		<artifactId>h2</artifactId>
		<scope>runtime</scope>
</dependency>
```
```
<dependency>
		<groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
```
### Launch

To run the project, you need the apache maven command line type:

> mvn spring-boot:run

But if you don't have apache maven installed, go to the command prompt in the project's root folder and type:

> ./mvnw spring-boot:run

### Endpoints

##### GET

<host:port>/users

<host:port>/ongs

<host:port>/ongs?page=2&limit=500&direction=asc

<host:port>/incidents

#### POST
<host:port>/ongs
```
Headers
user_ong_id = <user id associated with ong>

Body
{
    "name": "Ong",
    "email": "ong@ong.com.br",
    "whatsapp": "999999999",
    "city": "Recfe",
    "uf": "PE"
}
```

<host:port>/incidents
```
Headers
ong_id = <ong id associated with incident>

Body
{
	"title": "Any incident",
    "description": "Any description",
    "value": 350
}
```




### Inspiration
This code is based on the code developed in Rocketeseat's 11th week omnistack.
