package on.focus0147.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:datasource/jdbc.properties")
public class DataSourceConfiguration {

    private record DatabaseProperties(
            String driverName,
            String url,
            String userName,
            String password,
            int maxPoolSize
    ) {}

    private final DatabaseProperties dbProperties;

    public DataSourceConfiguration(
            @Value("${dataSource.driverClassName}") String driverName,
            @Value("${dataSource.url}") String url,
            @Value("${dataSource.username}") String userName,
            @Value("${dataSource.password}") String password,
            @Value("${dataSource.maxPoolSize}") int maxPoolSize
    ) {
        this.dbProperties = new DatabaseProperties(driverName, url, userName, password, maxPoolSize);
    }

    @Bean(destroyMethod = "close")
    DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(dbProperties.driverName());
        config.setJdbcUrl(dbProperties.url());
        config.setUsername(dbProperties.userName());
        config.setPassword(dbProperties.password());
        config.setMaximumPoolSize(dbProperties.maxPoolSize());
        return new HikariDataSource(config);
    }

}
