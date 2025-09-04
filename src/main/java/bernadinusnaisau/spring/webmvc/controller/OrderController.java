package bernadinusnaisau.spring.webmvc.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @GetMapping(path = "/orders/{orderId},products/{productId}")
    @ResponseBody
    public String Order(@PathVariable String orderId, @PathVariable String productId) {
        return "order : " + orderId + ", product : " + productId;
    }
}
