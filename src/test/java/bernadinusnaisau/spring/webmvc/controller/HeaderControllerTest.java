package bernadinusnaisau.spring.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class HeaderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getHeaderValid() throws Exception {
        mockMvc.perform(get("/header/token").header("X-TOKEN", "admin"))
                .andExpectAll(status().isOk(),content()
                        .string(Matchers.containsString("valid token")));
    }

    @Test
    void getHeaderInValid() throws Exception {
        mockMvc.perform(get("/header/token").header("X-TOKEN", "salah"))
                .andExpectAll(status().isOk(),content()
                        .string(Matchers.containsString("invalid token")));
    }
}
