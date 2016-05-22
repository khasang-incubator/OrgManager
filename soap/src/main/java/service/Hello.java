package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(portName = "http://127.0.0.1:8080/Service")
public class Hello {
    private String message = new String("Hello, ");

    public Hello() {}

    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
