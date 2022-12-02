package es.manu.proyectofinaldespring.Interfaces;

import es.manu.proyectofinaldespring.entidades.Digital;
import es.manu.proyectofinaldespring.entidades.Producto;

import java.util.List;

public interface IDigitalService {
    List<Digital> listar();
    Digital findById(Long id);
    Digital save(Digital digital);
    Digital delete(Digital digital);
    List<Digital> buscador(String cadena);
    List<Digital> findByMarca_IdIsNotNull();
}
