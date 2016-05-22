package service;

import javax.xml.ws.Endpoint;

public class Server {

    private static String address = "http://127.0.0.1:8080/Service";

    protected Server() throws Exception {
        System.out.println("Starting Server");
        Object implementor = new Hello();
        Endpoint.publish(address, implementor);
    }

    public static void main(String args[]) throws Exception {
        new Server();
        System.out.println("Service listening at " + address);
        System.out.println("WSDL hosted at " + address + "?wsdl");

    }
}