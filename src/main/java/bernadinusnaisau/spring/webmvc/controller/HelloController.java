package bernadinusnaisau.spring.webmvc.controller;

import bernadinusnaisau.spring.webmvc.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Objects;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(path = "/hello")
    public void helloController(HttpServletRequest request, HttpServletResponse response) throws IOException {
       String name = request.getParameter("name");
       String responBody  = helloService.hello(name);
       response.getWriter().println(responBody);
    }
}
