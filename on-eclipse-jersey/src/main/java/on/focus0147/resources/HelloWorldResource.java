package on.focus0147.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello!";
    }

    @Path("/{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        return "Hello, " + name;
    }

    @Path("/low/{name: [a-z]*}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hiLow(@PathParam("name") String name) {
        return "Hi, low, " + name;
    }
    @Path("/query")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hiUp(@QueryParam("name") String name) {
        return "Hi, query, " + name;
    }

}
