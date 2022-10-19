package form.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import form.app.models.domain.Usuario;

@Controller
public class FormController {
    
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("user", new Usuario());
        return "form";
    }

    @PostMapping("/form")
    public String procesar(
            @Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model
            /* @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password */
        ){
        
        if(result.hasErrors()){
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
            });

            model.addAttribute("error", errores);

            return "form";
        }
        /* Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(password); */
        
        
        model.addAttribute("titulo", "resultado");
        model.addAttribute("usuario", usuario);

        return "resultado";
    }

}
