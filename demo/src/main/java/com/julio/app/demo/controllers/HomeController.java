package com.julio.app.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        //REDIRECCIONA Y REINICIA LA PETICIÓN
        //return "redirect:/app/index";

        //LOS LOS PARAMETROS DEL REQUEST SE MANTIENEN NO SE REINICIA LA PETICIÓN
        //POR DEBAJO EJECUTA EL METODO RequestDispatcher.forward()
        return "forward:/app/index";
    }
}
