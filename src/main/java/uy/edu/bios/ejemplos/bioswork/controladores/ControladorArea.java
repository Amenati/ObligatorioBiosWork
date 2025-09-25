package uy.edu.bios.ejemplos.bioswork.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.validation.Valid;
import uy.edu.bios.ejemplos.bioswork.modelos.Area;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/areas")
public class ControladorArea {

    @Autowired
    MessageSource messageSource;

    @GetMapping("/ingresar")
    public String ingresarArea(@ModelAttribute Area area) {
        return "areas/ingresar";
    }

    @PostMapping("/ingresar")
    public String ingresarArea(@ModelAttribute @Valid Area area, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "areas/ingresar";
        }
        
        attributes.addFlashAttribute("mensaje", "Área ingresada correctamente");

        return "redirect:/areas/listar";
    }
    
    @GetMapping("/areas/modificar")
    public String modificarArea(@ModelAttribute Area area) {
        return "areas/modificar";
    }

    @PostMapping("/areas/modificar")
    public String modificarArea(@ModelAttribute @Valid Area area, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "areas/modificar";
        }
        
        model.addAttribute("mensaje", "Área modificada correctamente");

        return "redirect:/areas/listar";
    }
   
    
    
}
