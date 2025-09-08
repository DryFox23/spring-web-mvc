package bernadinusnaisau.spring.webmvc.controller;

import bernadinusnaisau.spring.webmvc.model.CreatePersonRequest;
import bernadinusnaisau.spring.webmvc.model.SocialMediaRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class PersonApiControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void apiPersonJson() throws Exception {

        CreatePersonRequest request = new CreatePersonRequest();
        request.setHobbies(List.of("Coding", "Reading"));
        request.setSosialMedias(new ArrayList<>());
        request.getSosialMedias().add(new SocialMediaRequest("Facbook", "Facbook.com/gaming123"));

        mockMvc.perform(post("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpectAll(status().isOk(), content().json(objectMapper.writeValueAsString(request)));
    }

    @Test
    void apiPersonJsonNotValid() throws Exception {

        CreatePersonRequest request = new CreatePersonRequest();
        request.setHobbies(List.of("Coding", "Reading"));
        request.setSosialMedias(new ArrayList<>());
        request.getSosialMedias().add(new SocialMediaRequest("Facbook", "Facbook.com/gaming123"));

        mockMvc.perform(post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpectAll(status().isBadRequest());
    }
}
