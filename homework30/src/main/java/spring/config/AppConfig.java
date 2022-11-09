package spring.config;

import liquibase.integration.spring.SpringLiquibase;
import org.postgresql.jdbc3.Jdbc3PoolingDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "spring")
public class AppConfig {

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("telranDB");

        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    // https://www.baeldung.com/liquibase-refactor-schema-of-java-app
    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase-changeLog.xml");
        liquibase.setDataSource(dataSource());
        return liquibase;
    }

    // https://www.postgresql.org/docs/7.4/jdbc-datasource.html
    @Bean
    public DataSource dataSource() {
        Jdbc3PoolingDataSource source = new Jdbc3PoolingDataSource();
        source.setDataSourceName("Data Source Name");
        source.setServerName("localhost:5432");
        source.setDatabaseName("telran");
        source.setUser("postgres");
        source.setPassword("root");
        return source;
    }
}
