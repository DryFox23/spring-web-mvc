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

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("firstName", "Bernadinus")
                        .param("lastName", "Naisau")
                        .param("email", "bernad@example.com")
                        .param("phoneNumber", "021")
                        .param("address.street", "street123")
                        .param("address.city", "city123")
                        .param("address.state", "state123")
                        .param("hobbies[0],", "hobbies1")
                        .param("hobbies[1],", "hobbies2")
                        .param("sosialMedias.socialMedia[0]", "socialMedia1")
                        .param("sosialMedias.urlSocialMedia[0]", "urlSocialMedia1")
                        .param("sosialMedias.socialMedia[1]", "socialMedia2")
                        .param("sosialMedias.urlSocialMedia[01", "urlSocialMedia2"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Succesfully Create Person Bernadinus" +
                                " Naisau " + " with email bernad@example.com" + " and phone number 021 " + "with address " + "street123" +"city123" + "state123")
                        ));
    }

    @Test
    void createPersonNotValid() throws Exception {
        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//                .param("firstName", "Bernadinus")
                .param("lastName", "Naisau")
                .param("email", "bernad@example.com")
                .param("phoneNumber", "021")
                .param("address.street", "street123")
                .param("address.city", "city123")
                .param("address.state", "state123")
                .param("hobbies[0],", "hobbies1")
                .param("hobbies[1],", "hobbies2")
                .param("sosialMedias.socialMedia[0]", "socialMedia1")
                .param("sosialMedias.urlSocialMedia[0]", "urlSocialMedia1")
                .param("sosialMedias.socialMedia[1]", "socialMedia2")
                .param("sosialMedias.urlSocialMedia[01", "urlSocialMedia2"))
                .andExpectAll(status().isBadRequest());
    }
}
