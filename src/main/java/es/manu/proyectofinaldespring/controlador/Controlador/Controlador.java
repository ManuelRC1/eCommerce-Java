package es.manu.proyectofinaldespring.controlador.Controlador;

import es.manu.proyectofinaldespring.entidades.*;
import es.manu.proyectofinaldespring.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Controlador {

    @Autowired
    private CompaniaService companiaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private DigitalService digitalService;

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private MarcasService marcasService;

    @GetMapping("/")
    public String index(Model model) {
        List<Producto> resultado = productoService.listar();
        List<Digital> resultado1 = digitalService.listar();
        List<Servicio> resultado2 = servicioService.listar();
        List<Marca> resultado3 = marcasService.listar();
        List<Compania> resultado4 = companiaService.listar();


        model.addAttribute("producto", resultado);
        model.addAttribute("digital", resultado1);
        model.addAttribute("servicio", resultado2);
        model.addAttribute("marca", resultado3);
        model.addAttribute("compania", resultado4);
        return "principal";
    }

    @GetMapping("/tipo/servicio")
    public String indexS(Model model, @RequestParam(name = "q", required = false) String consulta) {
        List<Servicio> resultado = (consulta == null) ? servicioService.listar() : servicioService.buscador(consulta);
        model.addAttribute("servicio", resultado);
        return "todo/servicios";
    }
    @GetMapping("/tipo/producto")
    public String indexP(Model model, @RequestParam(name = "q", required = false) String consulta) {
        List<Producto> resultado = (consulta == null) ? productoService.listar() : productoService.buscador(consulta);
        model.addAttribute("producto", resultado);
        return "todo/productos";
    }
    @GetMapping("/tipo/digital")
    public String indexD(Model model, @RequestParam(name = "q", required = false) String consulta) {
        List<Digital> resultado = (consulta == null) ? digitalService.listar() : digitalService.buscador(consulta);
        model.addAttribute("digital", resultado);
        return "todo/digitales";
    }
    @GetMapping("/tipo/marca")
    public String indexM(Model model, @RequestParam(name = "q", required = false) String consulta) {
        List<Producto> resultado1 = (consulta == null) ? productoService.findByMarca_IdIsNotNull() : productoService.buscador(consulta);
        List<Digital> resultado2 = (consulta == null) ? digitalService.findByMarca_IdIsNotNull() : digitalService.buscador(consulta);
        model.addAttribute("productoP", resultado1);
        model.addAttribute("productoD", resultado2);
        return "todo/marcas";
    }

    @GetMapping("/tipo/marca/{id}")
    public String indexMMarca(@PathVariable("id") Long id, Model model, @RequestParam(name = "q", required = false) String consulta) {
        List<Producto> resultado1 = (consulta == null) ? productoService.findByMarca_IdEquals(id) : productoService.buscador(consulta);
        List<Digital> resultado2 = (consulta == null) ? digitalService.findByMarca_IdEquals(id) : digitalService.buscador(consulta);

        model.addAttribute("productoP", resultado1);
        model.addAttribute("productoD", resultado2);
        return "todo/marcas";
    }

    @GetMapping("/tipo/compania")
    public String indexC(Model model, @RequestParam(name = "q", required = false) String consulta) {
        List<Servicio> resultado = (consulta == null) ? servicioService.listar() : servicioService.buscador(consulta);
        model.addAttribute("compania", resultado);
        return "todo/companias";
    }

    @GetMapping("/tipo/compania/{id}")
    public String indexCCompania(@PathVariable("id") Long id, Model model, @RequestParam(name = "q", required = false) String consulta) {
        List<Servicio> resultado = (consulta == null) ? servicioService.findByCompania_IdEquals(id) : servicioService.buscador(consulta);
        model.addAttribute("compania", resultado);
        return "todo/companias";
    }



    @GetMapping("/digital/{id}")
    public String detallesDigital(@PathVariable("id") Long id, Model model) {
        Digital p = digitalService.findById(id);
        if (p != null) {
            model.addAttribute("digitales", digitalService.listar());
            model.addAttribute("digital", p);
            return "detalles/digital";
        }

        return "redirect:/";

    }

    @GetMapping("/servicio/{id}")
    public String detallesServicio(@PathVariable("id") Long id, Model model) {
        Servicio p = servicioService.findById(id);
        if (p != null) {
            model.addAttribute("servicio", p);
            return "detalles/servicio";
        }

        return "redirect:/";

    }
    @GetMapping("/producto/{id}")
    public String detallesProducto(@PathVariable("id") Long id, Model model) {
        Producto p = productoService.findById(id);
        if (p != null) {
            model.addAttribute("producto", p);
            return "detalles/producto";
        }

        return "redirect:/";

    }
}
