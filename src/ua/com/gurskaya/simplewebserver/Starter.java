package ua.com.gurskaya.simplewebserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Starter {
    public static void main(String[] args) {
        Starter st = new Starter();
        try {
            st.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();

            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

                String line = bufferedReader.readLine();
                String[] firstLine = line.split(" ");
                if (Objects.equals(firstLine[0], "GET")) {
                    File file = new File("resources" + firstLine[1]);
                    if (file.exists()) {
                        sendResponse(bufferedOutputStream);
                    } else {
                        System.out.println("404");
                    }
                    sendData(file, bufferedOutputStream);
                } else {
                    System.out.println("400");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   /* private static String[] parseRequest(String line) {
        return
    }*/

    private static void sendResponse(BufferedOutputStream bufferedOutputStream) {
        String response = "HTTP/1.0 200 OK" + "\n\n";
        try {
            bufferedOutputStream.write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendData(File file, BufferedOutputStream bufferedOutputStream) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[4096];
            int read;
            while ((read = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
