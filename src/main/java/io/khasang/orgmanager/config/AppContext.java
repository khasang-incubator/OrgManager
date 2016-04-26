package io.khasang.orgmanager.config;

import io.khasang.orgmanager.model.DataSelect;
import io.khasang.orgmanager.model.Hello;
import io.khasang.orgmanager.model.SecureAccess;
import io.khasang.orgmanager.model.SuperSecureAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:util.properties")
@ComponentScan("io.khasang.orgmanager")

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

}
