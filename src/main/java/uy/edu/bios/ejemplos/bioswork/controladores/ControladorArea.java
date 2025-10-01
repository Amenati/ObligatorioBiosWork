package uy.edu.bios.ejemplos.bioswork.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import uy.edu.bios.ejemplos.bioswork.dominio.Area;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionBiosWork;
import uy.edu.bios.ejemplos.bioswork.servicios.IServicioAreas;

@Controller
@RequestMapping("/areas")
public class ControladorArea {

    @Autowired
    private IServicioAreas servicioAreas;

    @GetMapping({"/", "/listar"})
    public String listarAreas(@RequestParam(required = false) String filtro, Pageable pageable, Model model) {
        Page<Area> areas = servicioAreas.buscar(filtro, pageable);

        model.addAttribute("areas", areas);

        return "areas/listar";
    }

    @GetMapping("/ingresar")
    public String ingresarArea(@ModelAttribute Area area) {
        return "areas/ingresar";
    }

    @PostMapping("/ingresar")
    public String ingresarArea(@ModelAttribute @Valid Area area, BindingResult result, Model model, RedirectAttributes attributes) {
        
        if (result.hasErrors()) {
            return "areas/ingresar";
        }

        try {
            servicioAreas.ingresar(area);

            attributes.addFlashAttribute("mensaje", "Área ingresada correctamente");
            return "redirect:/areas/listar";
            
        } catch (ExcepcionBiosWork e) {
            model.addAttribute("mensaje", "ERROR - " + e.getMessage());

            return "areas/ingresar";
        }
        
    }       


    @GetMapping("/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        Area area = servicioAreas.obtener(id);

        if (area != null) {
            model.addAttribute("area", area);
        } else {
            model.addAttribute("mensaje", "¡ERROR! No se encontró el área con el id " + id + ".");
        }

        return "areas/detalle";
    }

    @GetMapping("/modificar")
    public String mostrarFormularioModificar( Long id, Model model ) {

        Area area = servicioAreas.obtener(id);

        if (area != null ) {
            model.addAttribute("area", area);
        } else {
            model.addAttribute("Mensaje","ERROR!, no se encontro area"+ area + ".");
        }

        return "areas/modificar";

    }

    @PostMapping("/modificar")
    public String procesarModificar(@ModelAttribute @Valid Area area, BindingResult result, Model model, RedirectAttributes attributes) {
        
        if (result.hasErrors()) {
            return "areas/modificar";
        }

        try {
            servicioAreas.modificar(area);

            attributes.addFlashAttribute("mensaje", "Área modificada correctamente.");

            return "redirect:/areas/listar";

        } catch (ExcepcionBiosWork e) {
            model.addAttribute("mensaje", "¡ERROR! No se pudo modificar el área: " + e.getMessage());

            return "areas/modificar";
        }
        
    }   

    @GetMapping("/eliminar")
        public String mostrarEliminar(Long id, Model model) {
            Area area = servicioAreas.obtener(id);

            if (area != null) {
                model.addAttribute("area", area);
            } else {
                model.addAttribute("mensaje", "¡ERROR! No se encontró el área con el id " + id + ".");
            }

            return "areas/eliminar";
    }

    @PostMapping("/eliminar")
        public String procesarEliminar(Long id, Model model, RedirectAttributes attributes) {
            try {
                servicioAreas.eliminar(id);

                attributes.addFlashAttribute("mensaje", "Área eliminada con éxito.");

                return "redirect:/areas/listar";

            } catch (ExcepcionBiosWork e) {
                model.addAttribute("mensaje", "¡ERROR! " + e.getMessage());

                return "areas/eliminar";
            }
    }

}