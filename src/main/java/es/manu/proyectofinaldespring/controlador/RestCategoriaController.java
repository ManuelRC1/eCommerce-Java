package es.manu.proyectofinaldespring.controlador;

import es.manu.proyectofinaldespring.entidades.Categoria;
import es.manu.proyectofinaldespring.servicio.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class RestCategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public ResponseEntity<List<Categoria>> getCategoria(){
        List<Categoria> categoria = categoriaService.listar();
        return ResponseEntity.ok(categoria);
    }
    @RequestMapping(value = "{categoriaId}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable("categoriaId") Long categoriaId){
        Optional<Categoria> optionalCategoria = Optional.ofNullable(categoriaService.findById(categoriaId));
        if (optionalCategoria.isPresent()){
            return ResponseEntity.ok(optionalCategoria.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
        Categoria categorias = categoriaService.save(categoria);
        return ResponseEntity.ok(categorias);
    }

    @DeleteMapping(value = "{categoriaId}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable("categoriaId") Categoria categoria){
        categoriaService.delete(categoria);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<Categoria> actualizarCategoria(@RequestBody Categoria categoria){
        Optional<Categoria> optionalCategoria = Optional.ofNullable(categoriaService.findById(categoria.getId()));
        if (optionalCategoria.isPresent()){
            Categoria actualizarCategoria = optionalCategoria.get();
            actualizarCategoria.setNombre(categoria.getNombre());
            categoriaService.save(actualizarCategoria);
            return ResponseEntity.ok(actualizarCategoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

