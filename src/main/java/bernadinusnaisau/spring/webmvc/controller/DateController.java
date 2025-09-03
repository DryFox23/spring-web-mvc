package bernadinusnaisau.spring.webmvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateController {

    //Masukan pattern yang di inginkan untuk di konversi ke tipe data Date misal yyyymmdd
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @GetMapping(path = "/date")
    public void getDate(@RequestParam(name = "date")Date date, HttpServletResponse response) throws IOException {
        response.getWriter().println("Date : " + dateFormat.format(date));
    }
}
