package it.template;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import it.template.exception.throwables.BadRequestException;
import it.template.model.ExampleModel;

@Path("/")
public class GreetingResource {

    @GET
    @Operation(
        summary = "Hello world API",
        description = "Hello World description"
    )
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
    @GET
    @Operation(
        summary = "Endpoint to test Exception handler",
        description = "Endpoint to test Exception handle"
    )
    @Path("/test_exception")
    @Produces(MediaType.APPLICATION_JSON)
    public String testException() {
        throw new BadRequestException("Testing BAD_REQUEST");
    }
    @GET
    @Operation(
        summary = "Endpoint to test Exception handler",
        description = "Endpoint to test Exception handle"
    )
    @Path("/example_model")
    @Produces(MediaType.APPLICATION_JSON)
    public ExampleModel getExample() {
        ExampleModel toReturn = new ExampleModel("fieldA", "fieldB");
        return toReturn;
    }
}