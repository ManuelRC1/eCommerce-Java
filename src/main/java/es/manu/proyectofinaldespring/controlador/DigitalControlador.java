package es.manu.proyectofinaldespring.controlador;


import es.manu.proyectofinaldespring.entidades.Digital;
import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tipo/digital")
public class DigitalControlador {


    @Autowired
    private DigitalService digitalService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private MarcasService marcasService;

    @Autowired
    private AreaService areaService;



    @GetMapping("/")
        public String index(Model model, @RequestParam(name = "q", required = false) String consulta) {
            List<Digital> resultado = (consulta == null) ? digitalService.listar() : digitalService.buscador(consulta);
            model.addAttribute("digital", resultado);
            return "todo/digitales";
    }

    @GetMapping("/crear")
    public String nuevaProducto(Model model) {
        model.addAttribute("digital", new Digital());
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("marcas", marcasService.listar());
        model.addAttribute("areas", areaService.listar());

        return "formularios/formularioDigital";
    }


    @PostMapping("crear/enviar")
    public String enviarNuevoProducto(Digital digital) {

        digitalService.save(digital);
        return "redirect:/tipo/digital/";

    }


    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable("id") Long id, Model model) {

        Digital digital = digitalService.findById(id);

        model.addAttribute("digital", digital);
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("areas", areaService.listar());
        model.addAttribute("marcas", marcasService.listar());

        return "formularios/formularioDigital";
    }


    @GetMapping("/borrar/{id}")
    public String borrarProducto(@PathVariable("id") Long id, Model model) {
        Digital digital = digitalService.findById(id);
        digitalService.delete(digital);
        return "redirect:/tipo/digital/";

    }


}
