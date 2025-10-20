package uy.edu.bios.ejemplos.bioswork.controladores;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import uy.edu.bios.ejemplos.bioswork.servicios.interfaces.IServicioDetalleUsuario;


@Controller
public class ControladorIngresarYSalir {

    @Autowired
    public IServicioDetalleUsuario servicioDetalleUsuario;

    @GetMapping("/ingresar")
    public String ingresar(Principal principal) {

        return "ingresar";
        // if (principal == null || principal instanceof AnonymousAuthenticationToken) {
        //     return "ingresar";
        // } 
        // else {
        //     return "redirect:/";
        // }
    }

    @PostMapping("/ingresar")
    public String postMethodName(@RequestParam String username, 
                       @RequestParam String password, 
                       Model model) throws Exception {
        
        
        try {
            UserDetails detallesUsuario = servicioDetalleUsuario.loadUserByUsername(username);

            if(detallesUsuario != null){

                //Aca hay que cambiar .equals por .matches cuando usemos bcrypt
                if(!detallesUsuario.getPassword().toString().equals(password)) throw new Exception("Contraseña invalida");

                Collection<?extends GrantedAuthority> roles = detallesUsuario.getAuthorities();

                for (GrantedAuthority rol : roles) {
                    String nombreRol = rol.getAuthority();

                    switch (nombreRol) {
                        case "POSTULANTE":
                             return "paginaPostulante";
                        case "CONSULTOR":
                             return "paginaConsultor";
                        case "CLIENTE":
                             return "paginaCliente";
                        default:
                        return "inicio";
                    }
                }
            }
            else{
                return "inicio";
            }

        } catch (Exception e) {
           return "redirect:/ingresar?error=true";
        }

        return "redirect:/";
    }
    

    @GetMapping("/logout")
    public String salir() {
        return "salir";
    }

}
