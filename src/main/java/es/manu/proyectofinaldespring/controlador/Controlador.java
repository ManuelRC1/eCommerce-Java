package es.manu.proyectofinaldespring.controlador;

import es.manu.proyectofinaldespring.entidades.Digital;
import es.manu.proyectofinaldespring.entidades.Marca;
import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.entidades.Servicio;
import es.manu.proyectofinaldespring.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Controlador {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private DigitalService digitalService;
    @Autowired
    private ServicioService servicioService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("digitales", digitalService.listar());
        model.addAttribute("servicios", servicioService.listar());
        return "main";
    }
    @GetMapping("/digital/{id}")
    public String detallesDigital(@PathVariable("id") Long id, Model model) {
        Digital p = digitalService.findById(id);
        if (p != null) {
            model.addAttribute("digital", p);
            return "Detalles/digital";
        }

        return "redirect:/";

    }
    @GetMapping("/servicio/{id}")
    public String detallesServicio(@PathVariable("id") Long id, Model model) {
        Servicio p = servicioService.findById(id);
        if (p != null) {
            model.addAttribute("servicio", p);
            return "Detalles/servicio";
        }

        return "redirect:/";

    }
    @GetMapping("/producto/{id}")
    public String detallesProducto(@PathVariable("id") Long id, Model model) {
        Producto p = productoService.findById(id);
        if (p != null) {
            model.addAttribute("producto", p);
            return "Detalles/producto";
        }

        return "redirect:/";

    }
}
