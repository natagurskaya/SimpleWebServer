package ua.com.gurskaya.simplewebserver.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void start() {
        ServerSocket s;
        try {
            s = new ServerSocket(8080);
        } catch (Exception e) {
            throw new RuntimeException("Error!", e);
        }
        System.out.println("Waiting for connection");
        while (true) {
            try (Socket socket = s.accept();
                 InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream()) {

                ClientHandler clientHandler = new ClientHandler(inputStream, outputStream);
                clientHandler.handle();
            } catch (IOException e) {
                throw new RuntimeException("Couldn't start a socket", e);
            }
        }
    }
}
