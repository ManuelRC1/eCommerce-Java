package es.manu.proyectofinaldespring.controlador.AControlador;

import es.manu.proyectofinaldespring.entidades.*;
import es.manu.proyectofinaldespring.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminControlador {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private DigitalService digitalService;

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private MarcasService marcasService;

    @Autowired
    private CompaniaService companiaService;

    @GetMapping("/admin")
    public String index(Model model, @RequestParam(name = "q", required = false) String consulta){
        List<Producto> resultado = (consulta == null) ? productoService.listar() : productoService.buscador(consulta);
        List<Digital> resultado1 = (consulta == null) ? digitalService.listar() : digitalService.buscador(consulta);
        List<Servicio> resultado2 = (consulta == null) ? servicioService.listar() : servicioService.buscador(consulta);
        List<Categoria> resultado3 = (consulta == null) ? categoriaService.listar() : categoriaService.buscador(consulta);
        List<Marca> resultado4 = (consulta == null) ? marcasService.listar() : marcasService.buscador(consulta);
        List<Compania> resultado5 = (consulta == null) ? companiaService.listar() : companiaService.buscador(consulta);

        model.addAttribute("producto", resultado);
        model.addAttribute("digital", resultado1);
        model.addAttribute("servicio", resultado2);
        model.addAttribute("categoria", resultado3);
        model.addAttribute("marca", resultado4);
        model.addAttribute("compania", resultado5);
        return "admin";
    }
}
