package es.manu.proyectofinaldespring.controlador;

import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tipo/producto")
public class ProductoControlador {


    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private MarcasService marcasService;

    @Autowired
    private AreaService areaService;


    @GetMapping("/")
    public String index(Model model, @RequestParam(name = "q", required = false) String consulta) {
        List<Producto> resultado = (consulta == null) ? productoService.listar() : productoService.buscador(consulta);
        model.addAttribute("producto", resultado);
        return "todo/productos";
    }

    @GetMapping("/crear")
    public String nuevaProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("marcas", marcasService.listar());
        model.addAttribute("areas", areaService.listar());

        return "formularios/formularioProductos";
    }


    @PostMapping("crear/enviar")
    public String enviarNuevoProducto(Producto producto) {

        productoService.save(producto);
            return "redirect:/tipo/producto/";

    }


    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable("id") Long id, Model model) {

        Producto producto = productoService.findById(id);

        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("areas", areaService.listar());
        model.addAttribute("marcas", marcasService.listar());

        return "formularios/formularioProductos";
    }


    @GetMapping("/borrar/{id}")
    public String borrarProducto(@PathVariable("id") Long id, Model model) {
        Producto producto = productoService.findById(id);
        productoService.delete(producto);
        return "redirect:/tipo/producto/";

    }

}
