package ua.com.gurskaya.simplewebserver.service;

import ua.com.gurskaya.simplewebserver.entity.Request;
import ua.com.gurskaya.simplewebserver.entity.Response;
import ua.com.gurskaya.simplewebserver.util.RequestParser;
import ua.com.gurskaya.simplewebserver.util.ResponseWriter;

import java.io.InputStream;
import java.io.OutputStream;

public class ClientHandler {
    private InputStream inputStream;
    private OutputStream outputStream;

    public ClientHandler(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void handle(){
        Request request = RequestParser.parse(inputStream);
        ResponseGenerator responseGenerator = new ResponseGenerator();
        Response response = responseGenerator.generate(request);
        ResponseWriter.write(response, outputStream);
    }
}
