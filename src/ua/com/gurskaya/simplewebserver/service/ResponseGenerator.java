package ua.com.gurskaya.simplewebserver.service;

import ua.com.gurskaya.simplewebserver.entity.Method;
import ua.com.gurskaya.simplewebserver.entity.Request;
import ua.com.gurskaya.simplewebserver.entity.Response;

import java.io.File;

public class ResponseGenerator {
    public Response generate(Request request){
        Response response = new Response();

        if (request.getMethod().equals(Method.GET) && checkPath(request.getPathToResource())) {
            response.setHttpVersion(request.getHttpVersion());
            response.setCode("200 OK");
            response.setPath(request.getPathToResource());
        }else if(!request.getMethod().equals(Method.GET)){
            response.setHttpVersion(request.getHttpVersion());
            response.setCode("400 Bad Request");
        }else if (!checkPath(request.getPathToResource())){
            response.setHttpVersion(request.getHttpVersion());
            response.setCode("404 Not Found");
        }
        return response;
    }

    private boolean checkPath (String path){
        File file = new File("resources" + path);
        return file.exists();
    }
}
