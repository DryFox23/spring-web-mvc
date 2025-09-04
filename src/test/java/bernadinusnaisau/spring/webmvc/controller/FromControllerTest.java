package bernadinusnaisau.spring.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FromControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void formPost() throws Exception {
        mockMvc.perform(post("/hello/form")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .queryParam("name", "Bernad"))
                .andExpectAll(status().isOk(),
                        header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(MediaType.TEXT_HTML_VALUE)),
                        (content().string(Matchers.containsString("Hello Bernad"))));
    }

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(post("/form/person").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Bernad")
                .param("birthDate", "2003-08-23")
                .param("address", "JLGG"))
                .andExpectAll(status().isOk(), content()
                .string(Matchers.containsString(
                        "Sucess Create Person With Name: Bernad"
                        + "Birth Date: 2003-08-23"
                        + "Address: JLGG")));
    }
}
