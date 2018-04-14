package ua.com.gurskaya.simplewebserver.controller;


import ua.com.gurskaya.simplewebserver.service.Server;

public class Starter {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
