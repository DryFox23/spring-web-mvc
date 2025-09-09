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
//                Ambil total error count pada fieldnya
                int errorCount = bindingResult.getFieldErrorCount();
                if (errorCount > 0) {
                        System.out.println("error count: " + errorCount);
//                        Ambil keterangan error dari fieldnya
                        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
                        for (FieldError fieldError : fieldErrors) {
                                System.out.println(fieldError.getField() + ": " + fieldError.getDefaultMessage() + " " + fieldError.getRejectedValue());
                        }
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error count: " + errorCount);
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
