package es.manu.proyectofinaldespring.controlador.AControlador;

import es.manu.proyectofinaldespring.entidades.Compania;
import es.manu.proyectofinaldespring.servicio.CompaniaService;
import es.manu.proyectofinaldespring.servicio.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/tipo/compania")
public class CompaniaControlador {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private CompaniaService companiaService;


    @GetMapping("/")
    public String index(Model model, @RequestParam(name = "q", required = false) String consulta) {
        List<Compania> resultado = (consulta == null) ? companiaService.listar() : companiaService.buscador(consulta);
        model.addAttribute("compania", resultado);
        return "editar/companias";
    }

    @GetMapping("/crear")
    public String nuevaCompania(Model model) {
        model.addAttribute("compania", new Compania());
        model.addAttribute("servicio", servicioService.listar());

        return "formularios/formularioCompania";
    }


    @PostMapping("/crear/enviar")
    public String enviarNuevoCompania(@Valid Compania compania) {


        companiaService.save(compania);
        return "redirect:/admin/tipo/compania/";

    }


    @GetMapping("/editar/{id}")
    public String editarCompania(@PathVariable("id") Long id, Model model) {

        Compania compania = companiaService.findById(id);
        model.addAttribute("compania", compania);
        model.addAttribute("servicios", servicioService.listar());


        return "formularios/formularioCompania";
    }


    @GetMapping("/borrar/{id}")
    public String borrarCompania(@PathVariable("id") Long id) {

        Compania compania = companiaService.findById(id);

        companiaService.delete(compania);


        return "redirect:/admin/tipo/compania/";

    }
}
