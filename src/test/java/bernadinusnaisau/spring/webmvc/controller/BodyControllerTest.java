package bernadinusnaisau.spring.webmvc.controller;

import bernadinusnaisau.spring.webmvc.model.HelloRequest;
import bernadinusnaisau.spring.webmvc.model.HelloRespons;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class BodyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postBody() throws Exception {
        HelloRequest request = new HelloRequest();
        request.setName("Bernad");

        mockMvc.perform(post("/body/hello").contentType(
                MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
                .andExpectAll(status().isOk()).andExpect(result -> {
                    String responseBody = result.getResponse().getContentAsString();
                    HelloRespons helloRespons = objectMapper.readValue(responseBody, HelloRespons.class);
                    Assertions.assertEquals("Hello Bernad", helloRespons.getHello());
                });
    }
}
