package nxu.it;

import io.avaje.inject.test.InjectTest;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import jakarta.inject.Inject;
import okhttp3.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@InjectTest
public class MainTestCase {
    @Inject
    static Javalin javalin;

    @Test
    public void testHello() {
        JavalinTest.test(javalin, (server, client) -> {
            Response response = client.get("/hello");
            Assertions.assertEquals(200, response.code());
            Assertions.assertEquals("hello!", response.body().string());
        });
    }
}
