package es.manu.proyectofinaldespring.Interfaces;

import es.manu.proyectofinaldespring.entidades.Categoria;
import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.entidades.Servicio;

import java.util.List;

public interface IServicioService {
    List<Servicio> listar();
    Servicio findById(Long id);
    Servicio save(Servicio servicio);
    Servicio delete(Servicio servicio);
    List<Servicio> buscador(String cadena);
    List<Servicio> findByCompania_IdEquals(Long id);
}
