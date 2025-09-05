package bernadinusnaisau.spring.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@AutoConfigureMockMvc
@SpringBootTest
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void PostLoginSuccess() throws Exception {
        mockMvc.perform(post("/auth/login")
                .contentType(   MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("name", "admin")
                .param("password", "rahasia"))
                .andExpectAll(status().isOk(), content()
                        .string(Matchers.containsString("Welcome Admin!")));
    }

    @Test
    void PostLoginFail() throws Exception {
        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("name", "bukan admin")
                .param("password", "gagal"))
                .andExpectAll(status().isUnauthorized(), content()
                        .string(Matchers.containsString("Invalid Credentials")));
    }
}
