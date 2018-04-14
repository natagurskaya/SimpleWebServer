package ua.com.gurskaya.simplewebserver.entity;

import java.util.Map;

public class Request {
    private Method method;
    private String pathToResource;
    private String httpVersion;
    private Map<String, String> headers;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getPathToResource() {
        return pathToResource;
    }

    public void setPathToResource(String pathToResource) {
        this.pathToResource = pathToResource;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method=" + method +
                ", pathToResource='" + pathToResource + '\'' +
                ", httpVersion='" + httpVersion + '\'' +
                '}';
    }
}
