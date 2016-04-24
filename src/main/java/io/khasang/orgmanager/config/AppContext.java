package io.khasang.orgmanager.config;

import io.khasang.orgmanager.model.DataSelect;
import io.khasang.orgmanager.model.Hello;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@PropertySource("classpath:config.properties")
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

    @Autowired
    Environment env;

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
       // ds.setDriver(driver());
        ds.setUrl(env.getProperty("db.connstring"));
        ds.setUsername(env.getProperty("db.username"));
        ds.setPassword(env.getProperty("db.password"));

    //    ds.setUsername("root");
     //   ds.setPassword("root");
        return ds;
    }
}
