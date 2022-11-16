package es.manu.proyectofinaldespring.Interfaces;

import es.manu.proyectofinaldespring.entidades.Categoria;
import es.manu.proyectofinaldespring.entidades.Compania;

import java.util.List;

public interface ICompaniaService {
    List<Compania> listar();
    Compania findById(Long id);
    Compania save(Compania compania);
    Compania delete(Compania compania);
    List<Compania> buscador(String nombre);
}
