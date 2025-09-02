package bernadinusnaisau.spring.webmvc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceImplTest {

    @Autowired
    private HelloService helloService;

    @Test
    void helloGuest() {
        Assertions.assertEquals("Hello Guest", helloService.hello(null));
        Assertions.assertEquals("Hello Bernad", helloService.hello("Bernad"));
    }
}
