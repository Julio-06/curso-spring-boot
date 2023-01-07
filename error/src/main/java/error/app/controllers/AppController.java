package error.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/index")
    public String index() {
        //Integer num = 100/0;
        Integer num = Integer.parseInt("s");
        return "index";
    }
    
}
