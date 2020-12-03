# london
Lists all the users living in London. By living in London, living within 50 miles of London. The api gets list of users from https://bpdts-test-app.herokuapp.com

### Documentation
- springdoc-openapi: `http://localhost:8080/v3/api-docs/`
- Swagger UI: `http://localhost:8080/swagger-ui.html`

### Building and running
The project uses maven wrapper for building and running various targets. Please note the following:
- To run on unix/linux use the `mvnw` script.
- To run on windows use the `mvnw.cmd` script.
- All the examples on this page assume you are running on unix/linux. If you are running on windows please use `mvnw.cmd` instead of `./mvnw`.

### Run it locally
To run the service locally use the following command:
```
./mvnw spring-boot:run
```
The service is available at the following url:
```access transformers
http://localhost:8080/london/users
```

### Build OCI image
To build OCI image run the following command:
```access transformers
./mvnw spring-boot:build-image
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.0/reference/htmlsingle/#boot-features-developing-web-applications)
