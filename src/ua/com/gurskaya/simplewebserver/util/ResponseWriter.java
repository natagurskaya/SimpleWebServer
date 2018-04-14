package ua.com.gurskaya.simplewebserver.util;

import ua.com.gurskaya.simplewebserver.entity.Response;

import java.io.*;

public class ResponseWriter {
    public static void write(Response response, OutputStream outputStream) {
        String string = response.getHttpVersion() + " " + response.getCode();
        try {
            outputStream.write(string.getBytes());
            outputStream.write("\n\n".getBytes());
            sendData(response.getPath(), outputStream);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write response", e);
        }
    }

    private static void sendData(String path, OutputStream outputStream) {
        File file = new File("resources" + path);
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[4096];
            int read;
            while ((read = bufferedInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, read);
                outputStream.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write response", e);
        }
    }
}
