package it.template;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/hello")
public class GreetingResource {

    @GET
    @Operation(
        summary = "Hello world API",
        description = "Hello World description"
    )
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive, prova prova";
    }
}