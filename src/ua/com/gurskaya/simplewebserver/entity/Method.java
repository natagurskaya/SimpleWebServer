package ua.com.gurskaya.simplewebserver.entity;

public enum Method {
    GET("GET"), POST("POST"), PUT("PUT"), DELETE("DELETE");

    private String name;

    Method(String name) {
        this.name = name;
    }
}
