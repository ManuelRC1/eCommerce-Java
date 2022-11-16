package es.manu.proyectofinaldespring.controlador;

import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.entidades.Servicio;
import es.manu.proyectofinaldespring.servicio.AreaService;
import es.manu.proyectofinaldespring.servicio.CategoriaService;
import es.manu.proyectofinaldespring.servicio.CompaniaService;
import es.manu.proyectofinaldespring.servicio.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/admin/tipo/servicio")
public class ServicioControlador {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private CompaniaService companiaService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
        public String index(Model model, @RequestParam(name = "q", required = false) String consulta) {
            List<Servicio> resultado = (consulta == null) ? servicioService.listar() : servicioService.buscador(consulta);
            model.addAttribute("servicio", resultado);
            return "editar/servicios";
    }

    @GetMapping("/crear")
    public String nuevaServicio(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("companias", companiaService.listar());
        model.addAttribute("areas", areaService.listar());
        model.addAttribute("categorias", categoriaService.listar());


        return "formularios/formularioServicio";
    }


    @PostMapping("/crear/enviar")
    public String enviarNuevoServicio(@Valid Servicio servicio, Model model) {


        servicioService.save(servicio);
        return "redirect:/admin/tipo/servicio/";

    }


    @GetMapping("/editar/{id}")
    public String editarServicio(@PathVariable("id") Long id, Model model) {

        Servicio servicio = servicioService.findById(id);
        model.addAttribute("servicio",servicio);
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("areas", areaService.listar());
        model.addAttribute("companias", companiaService.listar());



        return "formularios/formularioServicio";
    }


    @GetMapping("/borrar/{id}")
    public String borrarServicio(@PathVariable("id") Long id, Model model) {

        Servicio servicio = servicioService.findById(id);

        servicioService.delete(servicio);


        return "redirect:/admin/tipo/servicio/";

    }

}
