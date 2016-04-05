package io.khasang.orgmanager.config;

import io.khasang.orgmanager.model.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setHello("Hello my App!!!");
        return hello;
    }
}
