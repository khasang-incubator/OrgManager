package io.khasang.orgmanager.config;

import io.khasang.orgmanager.model.DataSelect;
import io.khasang.orgmanager.model.Hello;
import io.khasang.orgmanager.model.SecureAccess;
import io.khasang.orgmanager.model.SuperSecureAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:util.properties")
public class AppContext {
    @Autowired
    Environment environment;

    @Bean
    public Hello hello(){
        return new Hello();
    }

    @Bean
    public SecureAccess secureAccess(){
        return new SecureAccess();
    }

    @Bean
    public SuperSecureAccess superSecureAccess(){
        return new SuperSecureAccess();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public DataSelect dataSelect(){
        return new DataSelect(jdbcTemplate());
    }
}
