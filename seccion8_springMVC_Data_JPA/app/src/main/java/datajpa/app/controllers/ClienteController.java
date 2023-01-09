package datajpa.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import datajpa.app.dao.IClienteDao;
import datajpa.app.models.entities.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {
    
    @Autowired
    private IClienteDao clienteDao;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteDao.findAll());

        return "client/listar";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model) {
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de Cliente");

        return "client/form";
    }

    @PostMapping("/form")
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("titulo", "Formulario de Cliente");
            return "client/form";
        }

        clienteDao.save(cliente);

        return "redirect:listar";
    }
    
}
