package es.manu.proyectofinaldespring.Interfaces;

import es.manu.proyectofinaldespring.entidades.Categoria;
import es.manu.proyectofinaldespring.entidades.Genero;

import java.util.List;

public interface IGeneroService {
    List<Genero> listar();
    Genero findById(Long id);
    Genero save(Genero genero);
    Genero delete(Genero genero);
}
