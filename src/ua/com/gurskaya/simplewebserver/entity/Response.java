package ua.com.gurskaya.simplewebserver.entity;

import java.util.Map;

public class Response {
    private String httpVersion;
    private String code;
    private Map<String, String> headers;
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Response{" +
                "httpVersion='" + httpVersion + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
