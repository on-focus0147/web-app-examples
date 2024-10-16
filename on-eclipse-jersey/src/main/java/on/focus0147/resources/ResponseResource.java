package on.focus0147.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/response")
public class ResponseResource {

    @GET
    @Path("/ok")
    public Response getOkResponse() {
        return Response
          .status(Response.Status.OK)
          .entity("Im an entity")
          .build();
    }

    @GET
    @Path("/not_ok")
    public Response getNOkTextResponse() {
        return Response
          .status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity("Im an internal server error!")
          .build();
    }

    @GET
    @Path("/text_plain")
    public Response getTextResponseTypeDefined() {

        String message = "This is a plain text response";

        return Response
          .status(Response.Status.OK)
          .entity(message)
          .type(MediaType.TEXT_PLAIN)
          .build();
    }

    @GET
    @Path("/text_plain_annotation")
    @Produces({ MediaType.TEXT_PLAIN })
    public Response getTextResponseTypeAnnotated() {

        String message = "This is a plain text response via annotation";

        return Response
          .status(Response.Status.OK)
          .entity(message)
          .build();
    }

    @GET
    @Path("/json")
    public Response getJsonResponse() {

        String message = "{\"hello\": \"This is a JSON response\"}";

        return Response
          .status(Response.Status.OK)
          .entity(message)
          .type(MediaType.APPLICATION_JSON)
          .build();
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        return "<?xml version=\"1.0\"?>" + "<hello> This is a xml response </hello>";
    }

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "<html> " + "<title>" + " This is a html title  </title>" + "<body><h1>" + " This is a html response body " + "</body></h1>" + "</html> ";
    }
}