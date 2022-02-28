package es.manu.proyectofinaldespring.controlador;


import es.manu.proyectofinaldespring.entidades.Categoria;
import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.repositorios.CategoriaRepository;
import es.manu.proyectofinaldespring.servicio.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tipo/categoria")
public class CategoriaControlador {

     @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
        public String index(Model model, @RequestParam(name = "q", required = false) String consulta) {
            List<Categoria> resultado = (consulta == null) ? categoriaService.listar() : categoriaService.buscador(consulta);
            model.addAttribute("categoria", resultado);
            return "todo/categorias";
     }
    @GetMapping("/crear")
    public String nuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "formularios/formularioCategoria";
    }

    @PostMapping("/crear/enviar")
    public String enviarNuevaCategoria(Categoria categoria, Model model) {

        categoriaService.save(categoria);
        return "redirect:/tipo/categoria/";
    }


    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable("id") Long id, Model model) {

        Categoria categoria = categoriaService.findById(id);

            model.addAttribute("categoria", categoria);
            return "formularios/formularioCategoria";


    }
    @GetMapping("/borrar/{id}")
    public String borrarCategoria(@PathVariable("id") Long id, Model model) {
        Categoria categoria = categoriaService.findById(id);
        categoriaService.delete(categoria);

        return "redirect:/tipo/categoria/";


    }

}
