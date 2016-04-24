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
@PropertySource("classpath:config.properties")
public class AppContext {
    @Bean
    public Hello hello(){
        return new Hello();
    }

    @Bean
    public SecureAccess secureAccess(){
        return new SecureAccess();
    }
	
	 JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdt=new JdbcTemplate();
        jdt.setDataSource(dataSource());
        return jdt;
    }

    @Bean
    DataSelect dataSelect(){
        return new DataSelect(jdbcTemplate());
    }
	
    @Autowired
    Environment env;

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setUrl(env.getProperty("db.connstring"));
        ds.setUsername(env.getProperty("db.username"));
        ds.setPassword(env.getProperty("db.password"));
        return ds;
    }

    @Bean
    public SuperSecureAccess superSecureAccess(){
        return new SuperSecureAccess();
    }
}
