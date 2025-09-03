package bernadinusnaisau.spring.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BooleanController {


    @GetMapping(path = "role")
    @ResponseBody
    public String checkRole(@RequestParam(name = "role") Boolean role) {
        Boolean isAdmin = "admin".equalsIgnoreCase(String.valueOf(role));
        return isAdmin ? "Role : admin" : "Role : Not admin";
   }
}
