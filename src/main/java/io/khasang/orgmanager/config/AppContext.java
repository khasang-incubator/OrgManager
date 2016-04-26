package io.khasang.orgmanager.config;

import io.khasang.orgmanager.dao.UserDao;
import io.khasang.orgmanager.dao.UserDaoImpl;
import io.khasang.orgmanager.model.Hello;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan("io.khasang.orgmanager")
public class AppContext {
    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setHello("Hello my App!!!");
        return hello;
    }

}
