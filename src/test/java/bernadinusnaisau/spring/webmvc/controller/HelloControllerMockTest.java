package bernadinusnaisau.spring.webmvc.controller;

import bernadinusnaisau.spring.webmvc.service.HelloService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private HelloService helloService;

    @BeforeEach
    void setUp() {
        Mockito.when(helloService.hello(Mockito.anyString())).thenReturn("Hello Gusy");
    }

    @Test
    void helloServiceWithParam() throws Exception {
        mockMvc.perform(get("/hello").queryParam("name", "Bernad")).andExpectAll(status()
                .isOk(), content().string(Matchers.containsString("Hello Gusy")));

        Assertions.assertFalse("Hello Bernad!".equals(helloService.hello("Bernad")));
    }
}
