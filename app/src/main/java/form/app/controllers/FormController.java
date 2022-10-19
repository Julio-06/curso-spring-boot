package form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import form.app.models.domain.Usuario;

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
        
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(password);
        
        
        model.addAttribute("titulo", "resultado");
        model.addAttribute("usuario", usuario);

        return "resultado";
    }

}
