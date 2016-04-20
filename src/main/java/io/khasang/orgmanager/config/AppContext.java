package io.khasang.orgmanager.config;

import io.khasang.orgmanager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppContext {

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
    public DataSelect dataSelect() {
        return new DataSelect(jdbcTemplate());
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public UserList userList() {
        return new UserList(jdbcTemplate());
    }
    @Bean DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/orgmanager");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
}
