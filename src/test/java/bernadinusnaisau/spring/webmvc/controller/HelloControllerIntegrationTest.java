package bernadinusnaisau.spring.webmvc.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private Integer port;

    @Test
    void helloGuest() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/hello", String.class);
        String response  = responseEntity.getBody() ;
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.trim(), "Hello Guest!");
    }

    @Test
    void helloParamName() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/hello?name=Bernad", String.class);
        String response = responseEntity.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.trim(), "Hello Bernad");
    }
}
