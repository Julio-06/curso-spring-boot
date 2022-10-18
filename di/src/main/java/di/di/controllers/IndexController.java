package di.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import di.di.models.services.IServicio;

@Controller
public class IndexController {

    @Autowired
    private IServicio servicio;

    /* MEDIANTE EL CONSTRUCTOR TAMBIEN PODEMOS HACER LA INYECCIÓN DE DEPENDENCIA */
    /* @Autowired
    public IndexController(IServicio servicio) {
        this.servicio = servicio;
    } */

    @GetMapping({"/", "", "/index"})
    public String index(Model model) {
        model.addAttribute("objeto", servicio.operacion());
        return "index";
    }


    /* 
    MEDIANTE EL METODO SET PODEMOS REALIZAR LA INYECCIÓN DE DEPENDENCIA
    
    @Autowired
    public void setServicio(IServicio servicio) {
        this.servicio = servicio;
    } */
}
 