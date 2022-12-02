package es.manu.proyectofinaldespring.controlador.AControlador;

import es.manu.proyectofinaldespring.entidades.Marca;
import es.manu.proyectofinaldespring.servicio.DigitalService;
import es.manu.proyectofinaldespring.servicio.MarcasService;
import es.manu.proyectofinaldespring.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/tipo/marca")
public class MarcaControlador {
    @Autowired
    private MarcasService marcasService;

    @Autowired
    private DigitalService digitalService;

    @Autowired
    private ProductoService productoService;


    @GetMapping("/")
    public String index(Model model, @RequestParam(name = "q", required = false) String consulta) {
        List<Marca> resultado = (consulta == null) ? marcasService.listar() : marcasService.buscador(consulta);
        model.addAttribute("marca", resultado);
        return "editar/marcas";
    }

    @GetMapping("/crear")
    public String nuevaMarca(Model model) {
        model.addAttribute("marca", new Marca());
        model.addAttribute("digitales", digitalService.listar());
        model.addAttribute("productos", productoService.listar());


        return "formularios/formularioMarca";
    }


    @PostMapping("/crear/enviar")
    public String enviarNuevoMarca(@Valid Marca marca) {


        marcasService.save(marca);
        return "redirect:/admin/tipo/marca/";

    }


    @GetMapping("/editar/{id}")
    public String editarMarca(@PathVariable("id") Long id, Model model) {

        Marca marca = marcasService.findById(id);
        model.addAttribute("marca", marca);
        model.addAttribute("digitales", digitalService.listar());
        model.addAttribute("productos", productoService.listar());



        return "formularios/formularioMarca";
    }


    @GetMapping("/borrar/{id}")
    public String borrarMarca(@PathVariable("id") Long id) {

        Marca marca = marcasService.findById(id);

        marcasService.delete(marca);


        return "redirect:/admin/tipo/marca/";

    }
}
