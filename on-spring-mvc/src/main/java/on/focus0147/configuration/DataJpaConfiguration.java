package on.focus0147.configuration;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Import(DataSourceConfiguration.class)
@ComponentScan(basePackages = {"on.focus0147.repositories"})
@EnableJpaRepositories("on.focus0147.repositories")
@EnableTransactionManagement
public class DataJpaConfiguration {

    private final DataSource dataSource;

    @Autowired
    DataJpaConfiguration(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public Properties jpaProperties() {
        Properties jpaProps = new Properties();
        jpaProps.put(AvailableSettings.HBM2DDL_AUTO, "none");
        jpaProps.put(AvailableSettings.FORMAT_SQL, true);
        jpaProps.put(AvailableSettings.USE_SQL_COMMENTS, true);
        jpaProps.put(AvailableSettings.SHOW_SQL, true);
        return jpaProps;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        var factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPackagesToScan("on.focus0147.model");
        factory.setDataSource(dataSource);
        factory.setJpaProperties(jpaProperties());
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(AbstractEntityManagerFactoryBean entityManagerFactoryBean) {
        var transactionManager =  new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
        return transactionManager;
    }

}
