package bernadinusnaisau.spring.webmvc.controller;

import bernadinusnaisau.spring.webmvc.model.CreatePersonRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class PersonController {

        @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        @ResponseBody
        @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<String> createPerson(@ModelAttribute @Valid CreatePersonRequest request,
                                   BindingResult bindingResult) {

                List<FieldError> allErrors = bindingResult.getFieldErrors();
                if (!allErrors.isEmpty()) {
                        allErrors.forEach(fieldError -> {
                                System.out.println(fieldError.getField() + ": " + fieldError.getDefaultMessage());
                        });
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You Send Invalid Data");
                }

                System.out.println(request);

                String response = new StringBuilder()
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
                return ResponseEntity.ok(response);
        }
}
