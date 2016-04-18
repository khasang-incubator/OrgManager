package io.khasang.orgmanager.config;

import io.khasang.orgmanager.model.DataSelect;
import io.khasang.orgmanager.model.Hello;
import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class AppContext {
    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setHello("Hello my App!!!");
        return hello;
    }

    @Bean
    JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdt=new JdbcTemplate();
        jdt.setDataSource(dataSource());
        return jdt;
    }

    @Bean
    DataSelect dataSelect(){
        return new DataSelect(jdbcTemplate());
    }

    @Bean
    Driver driver(){
        return new Driver();
    }

    @Bean
    public SimpleDriverDataSource dataSource(){
        SimpleDriverDataSource ds=new SimpleDriverDataSource();
        ds.setDriver(driver());
        ds.setUrl("jdbc:postgresql://localhost:5432/orgmanager");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }
}
