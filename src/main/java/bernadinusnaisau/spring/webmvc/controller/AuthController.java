package bernadinusnaisau.spring.webmvc.controller;

import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> login(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "password") String password,
            HttpServletResponse response) throws Exception {

        if (name.equals("admin") && password.equals("rahasia")) {
            Cookie cookie = new Cookie("name", name);
            cookie.setPath("/");
            response.addCookie(cookie);
            return new ResponseEntity<>("Welcome Admin!", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "/atuh/user")
    public ResponseEntity<String>getUser(@CookieValue("name")String name) throws Exception {
        return ResponseEntity.ok("Welcome Admin!" + name);
    }
}
