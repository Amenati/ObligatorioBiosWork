package uy.edu.bios.ejemplos.bioswork.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import uy.edu.bios.ejemplos.bioswork.dominio.Consultor;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionBiosWork;
import uy.edu.bios.ejemplos.bioswork.servicios.IServicioConsultores;

@Controller
@RequestMapping("/consultores")
public class ControladorConsultor {

    @Autowired
    private IServicioConsultores servicioConsultores;

    @GetMapping({"", "/listar"})
    public String listarConsultores(@RequestParam(required = false) String filtro, Pageable pageable, Model model) {
        Page<Consultor> consultores = servicioConsultores.buscar(filtro, pageable);

        model.addAttribute("consultores", consultores);

        return "consultores/listar";
    }

    @GetMapping("/ingresar")
    public String ingresarConsultor(@ModelAttribute Consultor consultor) {
        return "consultores/ingresar";
    }

    @PostMapping("/ingresar")
    public String ingresarConsultor(@ModelAttribute @Valid Consultor consultor, BindingResult result, Model model, RedirectAttributes attributes) {
        
        if (result.hasErrors()) {
            return "consultores/ingresar";
        }

        try {
            servicioConsultores.ingresar(consultor);

            attributes.addFlashAttribute("mensaje", "Consultor ingresado correctamente");

            return "redirect:/consultores/listar";

        } catch (ExcepcionBiosWork e) {
            model.addAttribute("mensaje", "ERROR - " + e.getMessage());

            return "consultores/ingresar";
        }

    }


    @GetMapping("/modificar")
    public String modificarConsultor(String nombreUsuario, Model model) {

        Consultor consultor = servicioConsultores.obtener(nombreUsuario);

        if (consultor != null) {
            model.addAttribute("consultor", consultor);
        } else {
            model.addAttribute("mensaje", "ERROR - EL usuario " + nombreUsuario + " no existe");
        }

        return "consultores/modificar";
    }

    @PostMapping("/modificar")
    public String modificarConsultor(@ModelAttribute @Valid Consultor consultor, BindingResult result, Model model, RedirectAttributes attributes) {
        
        if (result.hasErrors()) {
            return "consultores/modificar";
        }

        try {
            servicioConsultores.modificar(consultor);

            attributes.addFlashAttribute("mensaje", "Consultor modificado correctamente");

            return "redirect:/consultores/listar";

        } catch (ExcepcionBiosWork e) {
            model.addAttribute("mensaje", "ERROR - " + e.getMessage());

            return "consultores/modificar";
        }

    }


    @GetMapping("/eliminar")
    public String eliminarConsultor(String nombreUsuario, Model model) {
        Consultor consultor = servicioConsultores.obtener(nombreUsuario);

        if (consultor != null) {
            model.addAttribute("consultor", consultor);
        } else {
            model.addAttribute("mensaje", "ERROR - El consultor " + nombreUsuario + " no existe");
        }

        return "consultores/eliminar";
    }

    @PostMapping("/eliminar")
    public String eliminarConsultor(String nombreUsuario, Model model, RedirectAttributes attributes) {
        try {
            servicioConsultores.eliminar(nombreUsuario);

            attributes.addFlashAttribute("mensaje", "El consultor fue eliminado correctamente");

            return "redirect:/consultores/listar";

        } catch (ExcepcionBiosWork e) {
            model.addAttribute("mensaje", "ERROR - " + e.getMessage());

            return "consultores/eliminar";
        }
    }

    @GetMapping("/{nombreUsuario}")
    public String mostrarDetalle(@PathVariable("nombreUsuario") String nombreUsuario, Model model) {
        Consultor consultor = servicioConsultores.obtener(nombreUsuario);

        if (consultor != null) {
            model.addAttribute("consultor", consultor);
        } else {
            model.addAttribute("mensaje", "ERROR - El consultor " + nombreUsuario + " no existe");
        }

        return "consultores/detalle";

    }
    
}
 