package ${package};

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GreetingControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void onHello_whenNoNameIsGiven_thenHelloWorld() {
        String body = this.restTemplate.getForObject("/hello", String.class);
        assertThat(body, is("Hello, World!"));
    }

    @Test
    public void onHello_whenNameIsGiven_thenHelloThisName() {
        String body = this.restTemplate.getForObject("/hello?name=anyName", String.class);
        assertThat(body, is("Hello, anyName!"));
    }
}
