package on.focus0147.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataJpaConfiguration.class)
public class TestConfiguration {
}
