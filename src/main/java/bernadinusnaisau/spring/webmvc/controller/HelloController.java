package bernadinusnaisau.spring.webmvc.controller;

import bernadinusnaisau.spring.webmvc.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(path = "/hello")
    public void helloController(@RequestParam(name = "name", required = false) String name , HttpServletResponse response) throws IOException {
       String responBody  = helloService.hello(name);
       response.getWriter().println(responBody);
    }

    @PostMapping(path = "halo")
    public void helloServicePostMethod(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String name = firstName + " " + lastName;
        String responBody = helloService.hello(name);
        response.getWriter().println(responBody);
    }

    @GetMapping(path = "/web/hello")
    public ModelAndView hello(@RequestParam(name = "name", required = false)String name){
        return new ModelAndView("hello", Map.of(
                "title", "Hello Page",
                "name", name
        ));
    }
}
