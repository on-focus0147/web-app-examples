package on.focus0147;

import on.focus0147.config.ViewApplicationConfig;
import on.focus0147.model.FullPaths;
import on.focus0147.service.MessageService;
import on.focus0147.service.impl.MessageServiceImpl;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

    // Starts Grizzly HTTP server
    public static HttpServer startServer() {
        final ResourceConfig config = new ViewApplicationConfig();
        config.packages(true, "on.focus0147.resources");
        config.register(new AbstractBinder(){
            @Override
            protected void configure() {
                // map this service to this contract
                bind(MessageServiceImpl.class).to(MessageService.class);
            }
        });


        LOGGER.info("Starting Server........");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(FullPaths.BASE_URI), config);

    }

    public static void main(String[] args) {

        try {

            final HttpServer httpServer = startServer();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    System.out.println("Shutting down the application...");

                    httpServer.shutdownNow();

                    System.out.println("Done, exit.");
                } catch (Exception e) {
                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e);
                }
            }));

            System.out.println(String.format("Application started.%nStop the application using CTRL+C"));

            // block and wait shut down signal, like CTRL+C
            Thread.currentThread().join();

        } catch (InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}