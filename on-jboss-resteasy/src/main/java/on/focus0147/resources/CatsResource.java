package on.focus0147.resources;

import on.focus0147.model.Cat;
import on.focus0147.model.Cats;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.annotation.*;
import on.focus0147.service.CatsService;

import java.net.URI;
import java.net.URISyntaxException;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cats-resource")
@Path("/cats")
public class CatsResource {

  public String hi = "HI";

  @GET
  @Path("/")
  @Produces("application/xml")
  public Cats getAllCats() {
    return new Cats(CatsService.getCats());
  }

  @GET
  @Path("/cat")
  @Produces("application/xml")
  public Cat getCatById(@QueryParam("id") int id) {
    return CatsService.getCatById(id);
  }

  @GET
  @Path("/add")
  @Consumes("application/xml")
  public Response createCat()
      throws URISyntaxException {
    Cat cat = new Cat();
    CatsService.addCat(cat);
    return Response.temporaryRedirect(new URI("/cats")).build();
  }

  @GET
  @Path("/cats-resource")
  @Produces("application/xml")
  public CatsResource getServiceInfo() {
    return new CatsResource();
  }

}

