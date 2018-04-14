
import org.junit.Test;
import ua.com.gurskaya.simplewebserver.entity.Request;
import ua.com.gurskaya.simplewebserver.util.RequestParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RequestParserTest {

    @Test
    public void testParse() throws IOException {
        //prepare
        String request = "GET /wiki/страница HTTP/1.1\n" +
                "Host: ru.wikipedia.org\n" +
                "User-Agent: Mozilla/5.0 (X11; U; Linux i686; ru; rv:1.9b5) Gecko/2008050509 Firefox/3.0b5\n" +
                "Accept: text/html\n" +
                "Connection: close\n" +
                "\n";
        InputStream inputStream = new ByteArrayInputStream(request.getBytes());

        //when
        Request result = RequestParser.parse(inputStream);

        //then
        assertEquals("GET", result.getMethod().toString());
        assertEquals("HTTP/1.1", result.getHttpVersion());
        System.out.println(result);
        assertTrue(result.getHeaders().containsKey("Connection"));
        assertTrue(result.getHeaders().containsValue(" close"));
        assertEquals(4, result.getHeaders().size());
    }
}