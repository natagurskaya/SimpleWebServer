import org.junit.Test;
import ua.com.gurskaya.simplewebserver.entity.Response;
import ua.com.gurskaya.simplewebserver.util.ResponseWriter;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResponseWriterTest {
    @Test
    public void testResponseWrite() throws IOException {
        //prepare
        Response response = new Response();
        response.setHttpVersion("HTTP/1.1");
        response.setCode("200 OK");
        response.setPath("/home.html");

        //then
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("test/resources/test.txt"));
            ResponseWriter.write(response, outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
