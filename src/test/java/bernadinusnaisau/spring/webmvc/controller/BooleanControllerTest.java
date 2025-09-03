package bernadinusnaisau.spring.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BooleanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void ConvertStringToBoolean() throws Exception {
        mockMvc.perform(get("/role").queryParam("role", "admin"))
                .andExpectAll(status().isOk(), content()
                .string(Matchers.containsString("Role: kocak")));
}
}
