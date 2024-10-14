package on.focus0147.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import on.focus0147.service.MessageService;

@Path("/message")
public class FromServiceResource {

    // DI via HK2
    @Inject
    private MessageService messageService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloHK2() {
        return messageService.getInfo();
    }

}
