package es.manu.proyectofinaldespring.servicio;

import es.manu.proyectofinaldespring.Interfaces.ICategoriaService;
import es.manu.proyectofinaldespring.entidades.Categoria;
import es.manu.proyectofinaldespring.entidades.Digital;
import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }


    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria delete(Categoria categoria) {
        Categoria resultado = findById(categoria.getId());
        categoriaRepository.delete(resultado);
        return resultado;
    }

    @Override
    public List<Categoria> buscador(String cadena) {
        return categoriaRepository.findByNombreContains(cadena);
    }
}
