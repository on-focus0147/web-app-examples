package on.focus0147.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;

public class ViewApplicationConfig extends ResourceConfig {
    public ViewApplicationConfig() {
        packages("on.focus0147");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(FreemarkerMvcFeature.TEMPLATE_BASE_PATH, "templates/freemaker");
        register(FreemarkerMvcFeature.class);
    }
}
