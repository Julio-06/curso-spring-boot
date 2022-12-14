package com.julio.app.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.julio.app.demo.models.Usuario;

@Controller
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@RequestMapping("/app") //RUTA DE PRIMER NIVEL
public class IndexController {
    @Value(value =  "${texto.indexController.index.titulo}")
    private String textoIndex;

    @Value(value =  "${texto.indexController.perfil.titulo}")
    private String textoPerfil;

    @Value(value =  "${texto.indexController.listar.titulo}")
    private String textoListar; 
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
        
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Magisk");
        usuario.setApellido("OnlyHeadShot");
        usuario.setEmail("correo.com");

        model.addAttribute("titulo", textoPerfil);
        model.addAttribute("usuario", usuario);

        return "usuario/perfil";
    }
    
    @RequestMapping("listar")
    public String listar(Model model){
        List<Usuario> usuarios = Arrays.asList(
            new Usuario("Magisk", "OnlyHeadShot", "correo.com"),
            new Usuario("Pepito", "Noob", "noob.com"),
            new Usuario("Hitman", "OnlyHeadShot", null)
        );
    
        model.addAttribute("titulo", textoListar);
        model.addAttribute("usuarios", usuarios);

        return "usuario/listar";
    }

    /* DE ESTA MANERA PODEMOS PASAR ESA VARIABLE DE USUARIOS A TODOS LOS METODOS DEL Controller
    NORMALMENTE SE UTILIZA EN EL CASO DE LOS SELECT, LISTAS, ETC. */

     //DE ESTA MANERA SE LLAMARA NUESTRA VARIABLE EN LA VISTA
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(
            new Usuario("Magisk", "OnlyHeadShot", "correo.com"),
            new Usuario("Pepito", "Noob", "noob.com"),
            new Usuario("Hitman", "OnlyHeadShot", null)
        );

        return usuarios;
    }
    
}
