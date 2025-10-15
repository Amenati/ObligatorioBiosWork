package uy.edu.bios.ejemplos.bioswork.controladores;

import java.security.Principal;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorIngresarYSalir {

    @GetMapping("/login")
    public String ingresar(Principal principal) {
        if (principal == null || principal instanceof AnonymousAuthenticationToken) {
            return "ingresar";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String salir() {
        return "salir";
    }

}
