package form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    
    @GetMapping("/form")
    public String form(Model model){
        return "form";
    }

    @PostMapping("/form")
    public String procesar(
            Model model, 
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password
        ){
        model.addAttribute("titulo", "resultado");
        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("password", password);

        return "resultado";
    }

}
