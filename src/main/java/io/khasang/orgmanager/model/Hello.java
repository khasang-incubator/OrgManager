package io.khasang.orgmanager.model;

import org.springframework.stereotype.Component;

@Component
public class Hello {
    private String hello = "Hello";

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
