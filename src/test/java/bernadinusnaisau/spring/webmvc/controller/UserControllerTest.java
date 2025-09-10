package bernadinusnaisau.spring.webmvc.controller;

import bernadinusnaisau.spring.webmvc.model.User;
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
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUser() throws Exception {
        mockMvc.perform(get("/user/current")
                .sessionAttr("user", new User("admin")))
                .andExpectAll(status().isOk(),
                        content().string(Matchers.containsString("Hello :admin")));
    }

    @Test
    void getUserInValid() throws Exception {
        mockMvc.perform(get("/user/current"))
                .andExpectAll(status().is3xxRedirection());
    }
}
