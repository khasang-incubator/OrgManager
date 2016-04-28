package io.khasang.orgmanager.config;

import io.khasang.orgmanager.model.SecureAccess;
import io.khasang.orgmanager.model.SuperSecureAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("io.khasang.orgmanager")

public class AppContext {
    @Autowired
    Environment environment;

    @Bean
    public SecureAccess secureAccess(){
        return new SecureAccess();
    }

    @Bean
    public SuperSecureAccess superSecureAccess(){
        return new SuperSecureAccess();
    }

}
