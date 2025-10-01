package uy.edu.bios.ejemplos.bioswork.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ControladorInicio {
    @GetMapping
    public String inicio() {
        return "inicio";
    }

    
    

    
}
