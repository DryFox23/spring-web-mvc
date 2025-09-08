package bernadinusnaisau.spring.webmvc.controller;

import bernadinusnaisau.spring.webmvc.model.CreatePersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PersonController {

        @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        @ResponseBody
        @ResponseStatus(HttpStatus.OK)
        public String createPerson(@ModelAttribute CreatePersonRequest request) {
                System.out.println(request);
            return new StringBuilder()
                    .append("Succesfully Create Person ")
                    .append(request.getFirstName()).append(" ")
                    .append(request.getLastName()).append(" ")
                    .append(" with email ").append(request.getEmail())
                    .append(" and phone number ").append(request.getPhoneNumber())
                    .append(" with address ")
                    .append(request.getAddress().getStreet())
                    .append(request.getAddress().getCity())
                    .append(request.getAddress().getState())
                    .toString();
        }
}
