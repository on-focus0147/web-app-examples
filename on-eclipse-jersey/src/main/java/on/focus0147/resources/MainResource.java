package on.focus0147.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import on.focus0147.model.FullPaths;
import org.glassfish.jersey.server.mvc.Template;

@Path("/")
public class MainResource {
    @GET
    @Template(name = "/index.ftl")
    @Produces(MediaType.TEXT_HTML)
    public FullPaths getAllFruit() {
        return new FullPaths();
    }
}
