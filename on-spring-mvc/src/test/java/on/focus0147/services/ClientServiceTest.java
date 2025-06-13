package on.focus0147.services;

import on.focus0147.configuration.TestConfiguration;
import on.focus0147.model.ClientEntity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Need DB")
class ClientServiceTest {

    @Test
    void findAll() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        ClientService service = context.getBean("clientService", ClientService.class);
        Optional<ClientEntity> users = service.getByName("");
        assertTrue(users.isEmpty());

    }

}