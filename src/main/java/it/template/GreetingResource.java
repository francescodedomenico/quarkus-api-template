package it.template;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import it.template.exception.throwables.BadRequestException;
import it.template.model.ExampleModel;

@Path("/")
public class GreetingResource {

    private Set<ExampleModel> examples = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public GreetingResource() {
        examples.add(new ExampleModel("Apple", "Winter fruit"));
        examples.add(new ExampleModel("Pineapple", "Tropical fruit"));
    }


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
    public Set<ExampleModel> getExample() {
        return examples;
    }
    @POST
    @Operation(
        summary = "Endpoint to test Exception handler",
        description = "Endpoint to test Exception handle"
    )
    @Path("/example_model")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Set<ExampleModel> addExample(ExampleModel exampleModel) {
        examples.add(exampleModel);
        return examples;
    }
    @DELETE
    @Operation(
        summary = "Endpoint to test Exception handler",
        description = "Endpoint to test Exception handle"
    )
    @Path("/example_model")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Set<ExampleModel> deleteExample(ExampleModel exampleModel) {
        examples.remove(exampleModel);
        return examples;
    }
}