# quarkus-api-template Project

This project aims to be a baseline for REST microservices development based on the Quarkus Frameworks.
It is a commodity repository meant to be cloned and adapted later to any further use, this template ships with the features I require most during my everyday development activity such as:

* OpenAPI 3.0 swagger generation
* Exception handling
* ...more to come

## Adaptation to your use

After cloning this repository you might want to customize it for your needs.
Inside your __pom.xml__ you may edit the groudId and the artifactId
```xml
<groupId>it.template</groupId>
<artifactId>quarkus-api-template</artifactId>
<version>1.0.0-SNAPSHOT</version>
```

After that, by using a IDE of your choice, you may refactor the __it.template__ package name to your groupId.
## Extending the Exception handling logic
The Exception handling logic is nested inside the __ExceptionHandler.java__ file. It is built to catch Subclasses of the object ApiException and to return a response body that looks like 
```json
{
    "errorCode": "HTTP_400",
    "errorCodeDescription": "BAD_REQUEST",
    "errorMessage": "Testing BAD_REQUEST",
    "exception": null
}
```
You can customize and create new Exception classes by:

1) Creating a specific ErrorCode enum inside the ErrorCode.java class
```java
public enum ErrorCode {
    HTTP_400("BAD_REQUEST"),
    HTTP_500("INTERNAL_SERVER_ERROR");
    ...
}
```

2) Creating a new class that extends the APIException class, and build the ExceptionResponse accordingly with the given ErrorCodes 
```java
public BadRequestException() {
    super();
    ErrorCode error = ErrorCode.HTTP_400;
    ExceptionResponse response = new ExceptionResponse(error, error.getDescription(), null);
    this.setResponse(response);
}

public BadRequestException(String message) {
    super();
    ErrorCode error = ErrorCode.HTTP_400;
    ExceptionResponse response = new ExceptionResponse(error, error.getDescription(), null);
    this.setResponse(response);
    response.setErrorMessage(message);
}
```
3) Adding a case switch for your specific ErrorCode inside the ExceptionHandler class, for each error code you may decide which http code has to be returned to the client by setting the related Response.Status object
```java
switch (e.getResponse().getErrorCode()) {
            case HTTP_400: {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(
                        new ExceptionResponse(
                            e.getResponse().getErrorCode(),
                            e.getResponse().getErrorMessage(),
                            null)
                    ).build();
}
case ...

```

## Building and running docker image

Prerequisites:
* GraalVM 22.2.0
* Quarkus toolchain
* Docker

```bash
quarkus build --native --no-tests -D quarkus.native.container-build=true
docker build -f src/main/docker/Dockerfile.native-micro -t quarkus/quarkus-api-template .
docker run -i --rm -p 8080:8080 quarkus/quarkus-api-template
```

