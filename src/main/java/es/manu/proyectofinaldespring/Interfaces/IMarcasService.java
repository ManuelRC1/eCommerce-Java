package es.manu.proyectofinaldespring.Interfaces;

import es.manu.proyectofinaldespring.entidades.Marca;
import es.manu.proyectofinaldespring.entidades.Producto;

import java.util.List;
import java.util.Optional;

public interface IMarcasService {
    List<Marca> listar();
    Marca findById(Long id);
    Marca save(Marca marca);
    Marca delete(Marca marca);
    List<Marca> buscador(String nombre);

}
