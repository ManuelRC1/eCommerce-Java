package es.manu.proyectofinaldespring.Interfaces;

import es.manu.proyectofinaldespring.entidades.Compra;
import es.manu.proyectofinaldespring.entidades.Digital;
import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.entidades.Servicio;

import java.util.List;

public interface IDigitalService {
    List<Digital> listar();
    Digital findById(Long id);
    Digital save(Digital digital);
    Digital delete(Digital digital);
    List<Digital> buscador(String cadena);
    List<Digital> findByMarca_IdIsNotNull();
    List<Digital> digitalesId(List<Long> ids);
    List<Digital> digitalesDeUnaCompra(Compra c);
    List<Digital> findByMarca_IdEquals(Long id);
}
