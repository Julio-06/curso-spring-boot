package form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* import java.util.HashMap;
import java.util.Map; */

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import form.app.editors.NombreMayusculaEditor;
import form.app.editors.PaisPropertyEditor;
import form.app.editors.RolesEditor;
import form.app.models.domain.Pais;
import form.app.models.domain.Role;
import form.app.models.domain.Usuario;
import form.app.services.PaisService;
import form.app.services.RoleService;
import form.app.validations.UsuarioValidador;

@Controller
@SessionAttributes("usuario") /*NOS PERMITE MANETER LOS DATOS DURANTE EL CICLO DEL FORM */
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @Autowired
    private PaisService paisService;

    @Autowired
    private PaisPropertyEditor paisPropertyEditor;

    @Autowired
    private RolesEditor rolesEditor;

    @Autowired
    private RoleService roleService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(validador);

        /* NOS PERMITE CUSTOMIZAR UN DATO QUE OBTENEMOS Y CONVERTIRLO A OTRO. 
            ES LO MISMO SI VALIDAMOS EN EL MODELO CON @DateTimeFormat(pattern = "yyyy-MM-dd")
        */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); /* ES PARA QUE SEA ESTRICTO AL VALIDAR EL FORMATO DE LA FECHA */
        
        /* SI COLOCAMOS NOMBRE DEL CAMPO AL registerCustomEditor NO VALIDARA DE FORMA GLOBAL LOS CAMPOS DE FORMATO FECHA SI NO SOLO ES ESPECIFICADO */
        binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, false));

        /* NOS PERMITE CONVERTIR TODOS LOS STRING ENVIADOS A MAYUSCULA Y QUITANDOLE LOS ESPECIOS EN BLANCO AL INICIO Y AL FINAL */
        binder.registerCustomEditor(String.class, new NombreMayusculaEditor());

        binder.registerCustomEditor(Pais.class, "pais", paisPropertyEditor);

        binder.registerCustomEditor(Role.class, "roles", rolesEditor);

    }

    @ModelAttribute("paises")
    public Map<String, String> paisesMap(){
        Map<String, String> paises = new HashMap<String, String>();
        paises.put("ES", "España");
        paises.put("MX", "Mexico");
        paises.put("PA", "Panamá");

        return paises;
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises(){
        return this.paisService.listar();
    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRoleStrings(){
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");

        return roles;
    }

    @ModelAttribute("listaRolesMap")
    public Map<String, String> listaRolesMap(){
        Map<String, String> roles = new HashMap<String, String>();
        roles.put("ROLE_ADMIN", "ADMINISTRADOR");
        roles.put("ROLE_USER", "USUARIO");
        roles.put("ROLE_MODERATOR", "MODERADOR");

        return roles;
    }

    @ModelAttribute("listaRolesObject")
    public List<Role> listaRolesObject(){
        return this.roleService.listar();
    }

    @ModelAttribute("generos")
    public List<String> generos(){
        return Arrays.asList("Hombre", "Mujer");
    }
    
    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Julio Cesar");
        usuario.setApellido("Tejeira Armuelles");
        usuario.setIdentificador("12.456.789-K");
        usuario.setHabilitar(true);
        usuario.setValorSecreto("Algún valor secreto *****");
        usuario.setPais(new Pais(1, "PA", "Panamá"));
        usuario.setRoles(Arrays.asList(new Role(1, "ADMINISTRADOR", "ROLE_ADMIN")));
        model.addAttribute("usuario", usuario);

        return "form";
    }

    @PostMapping("/form")
    public String procesar(
            @Valid Usuario usuario,
             BindingResult result, 
             Model model
            /* @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password */
        ){
        //validador.validate(usuario, result); VALIDACIÓN
        /*
         * UTILIZAMOS EL SESSIONSTATUS PARA COMPLETAR EL CLICLO DEL OBJETO DE LA SESSION Y CON 
         * STATUS.SETCOMPLETE ELIMINAMOS EL OBJETO DE LA SESSION 
         * 
         */
        if(result.hasErrors()){
            model.addAttribute("titulo", "resultado");
            /* Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
            });

            model.addAttribute("error", errores); */

            return "form";
        }
        /* Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(password); */
        
        return "redirect:/ver";
    }

    @GetMapping("/ver")
    public String ver(
        @SessionAttribute(name = "usuario", required = false) Usuario usuario, 
        Model model, 
        SessionStatus status
    ){
        if(usuario == null){
            return "redirect:/form";
        }

        model.addAttribute("titulo", "resultado");
        model.addAttribute("usuario", usuario);

        status.setComplete();
        return "resultado";
    }

}
