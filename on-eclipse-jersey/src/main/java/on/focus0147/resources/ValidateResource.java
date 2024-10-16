package on.focus0147.resources;

import jakarta.validation.constraints.NotEmpty;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/valid")
public class ValidateResource {

    @Path("/q")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@NotEmpty(message = "Found empty param") @QueryParam("name") String name) {
        return "Hello, " + name;
    }
}
