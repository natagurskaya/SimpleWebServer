package ua.com.gurskaya.simplewebserver.util;

import ua.com.gurskaya.simplewebserver.entity.Method;
import ua.com.gurskaya.simplewebserver.entity.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {
    public static Request parse(InputStream inputStream) {
        Request request = new Request();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = bufferedReader.readLine();
            String[] firstLineArray = parseFirstLine(line);
            Method method = Method.valueOf(firstLineArray[0]);
            request.setMethod(method);
            request.setPathToResource(firstLineArray[1]);
            request.setHttpVersion(firstLineArray[2]);

            Map<String, String> headersMap = new HashMap<>();
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")){
                request.setHeaders(parseHeaders(line, headersMap));}
                else{
                    break;
                }
            }
        } catch (IOException e) {
          throw new RuntimeException("Couldn't parse request", e);
        }
        return request;
    }

    private static String[] parseFirstLine(String line) {
        return line.split(" ");
    }

    private static Map<String, String> parseHeaders(String line, Map<String,String> headersMap) {

        String[] split = line.split(":");
        headersMap.put(split[0], split[1]);
        return headersMap;
    }
}