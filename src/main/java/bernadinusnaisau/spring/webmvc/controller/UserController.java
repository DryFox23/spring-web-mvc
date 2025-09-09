package bernadinusnaisau.spring.webmvc.controller;

import bernadinusnaisau.spring.webmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserController {

    @GetMapping(path = "/user/current")
    public String UserController(@SessionAttribute("user") User user) {
        return "Hello : " + user.getUsername();
    }
}
