package com.julio.app.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("titulo", "ENVIAR PARÁMETROS DE LA RUTA (@PathVariable)");

        return "variables/index";
    }
    
    @GetMapping("/string/{texto}")
    public String variables(@PathVariable String texto, Model model){
        model.addAttribute("titulo", "RECIBIR PARÁMETROS DE LA RUTA (@PathVariable)");
        model.addAttribute("texto", "El texto enviado en la ruta es : " + texto);

        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable String texto, @PathVariable Integer numero,  Model model){
        model.addAttribute("titulo", "RECIBIR PARÁMETROS DE LA RUTA (@PathVariable)");
        model.addAttribute("texto", "El texto enviado en la ruta es : " + texto + " y el número enviado en el path es : " + numero);

        return "variables/ver";
    }
}
