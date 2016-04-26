package io.khasang.orgmanager.config;

import io.khasang.orgmanager.model.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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
