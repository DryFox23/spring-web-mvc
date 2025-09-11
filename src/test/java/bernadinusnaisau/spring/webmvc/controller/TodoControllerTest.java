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
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void AddTodos() throws Exception {
        mockMvc.perform(post("/add/todo")
                        .param("todo", "Learn Spring Web MVC")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void getTodos() throws Exception {
        mockMvc.perform(get("/get/todo")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpectAll(status().isOk(),
                        content().string(Matchers.containsString("Learn Spring Web MVC")));
    }
}
