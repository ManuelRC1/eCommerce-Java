package es.manu.proyectofinaldespring.Interfaces;

import es.manu.proyectofinaldespring.entidades.Categoria;
import es.manu.proyectofinaldespring.entidades.Digital;
import es.manu.proyectofinaldespring.entidades.Marca;
import es.manu.proyectofinaldespring.entidades.Producto;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    List<Categoria> listar();
    Categoria findById(Long id);
    Categoria save(Categoria categoria);
    Categoria delete(Categoria categoria);
    List<Categoria> buscador(String cadena);

}
