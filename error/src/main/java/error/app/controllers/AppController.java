package error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import error.app.errors.UsuarioNotFoundException;
import error.app.models.domain.Usuario;
import error.app.services.UsuarioService;

@Controller
public class AppController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/index")
    public String index() {
        //Integer num = 100/0;
        Integer num = Integer.parseInt("s");
        return "index";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model) {
        /* Usuario usuario = usuarioService.obtenerPorId(id);

        if(usuario == null) throw new UsuarioNotFoundException(id.toString()); */

        Usuario usuario = usuarioService.obtenerPorIdOptional(id).orElseThrow(() -> new UsuarioNotFoundException(id.toString()));

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombreCompleto()));

        return "ver";
    }
    
    
}
