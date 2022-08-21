package com.julio.app.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app") //RUTA DE PRIMER NIVEL
public class IndexController {
    //POR DEFECTO LAS RUTAS SE CREAN DE TIPO GET CUANDO USAS EL REQUESTMAPPING
    
    //LOS METODOS DE LA CLASE SON LAS RUTAS DE SEGUNDO NIVEL
    @GetMapping({"/index", "/", "/home"})
    public String index(Model model) {
        /*
         * FORMAS DE PASAR DATOS A UNA VISTA
         * 
         * PASAMOS POR PARAMETRO AL METODO DE LA RUTA EL Map<String, Object> map
         * Y LO UTILIZAMOS map.put("titulo", "Hola mundo desde Sprint Boot")
         * 
         * ModelAndView mv.addObject("titulo", "Hola mundo desde Sprint Boot")
         * ademas de con ModelAndView podemos definir el template y retornamos un ModelAndView
         * mv.setViewName("index")
         * 
         * TAMBIEN PUEDES USAR EL MODELMAP ES UNA IMPLEMENTRACIÓN DISTINTA PERO ES LO MISMO
         * 
         */
        
        model.addAttribute("titulo", "Hola mundo desde Sprint Boot");
        return "index";
    }
    
}
