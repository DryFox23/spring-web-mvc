package bernadinusnaisau.spring.webmvc.controller;

import bernadinusnaisau.spring.webmvc.model.HelloRequest;
import bernadinusnaisau.spring.webmvc.model.HelloRespons;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BodyController {

    @Autowired
    private ObjectMapper objectMapper;

    public BodyController(ObjectMapper objectMapper) {
    }

    @PostMapping(path = "/body/hello",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String body(@RequestBody String requestBody) throws JsonProcessingException {
        HelloRequest request = objectMapper.readValue(requestBody, HelloRequest.class);
        HelloRespons response = new HelloRespons();
        response.setHello("Hello " + request.getName());

        return objectMapper.writeValueAsString(response);
    }
}
