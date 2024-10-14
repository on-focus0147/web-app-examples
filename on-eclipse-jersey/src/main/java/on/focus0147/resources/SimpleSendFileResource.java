package on.focus0147.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.server.mvc.Viewable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Path("/res")
public class SimpleSendFileResource {

    @Path("/fis")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public FileInputStream mainResource() throws FileNotFoundException {
        File f = new File("src/main/resources/sloganSweet.html");
        return new FileInputStream(f);
    }

    @Path("/view")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable sloganView() {
        return new Viewable("/slogan.ftl", "Darling");
    }
}
