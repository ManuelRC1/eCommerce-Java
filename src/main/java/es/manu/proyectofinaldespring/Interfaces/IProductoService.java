package es.manu.proyectofinaldespring.Interfaces;

import es.manu.proyectofinaldespring.entidades.Compra;
import es.manu.proyectofinaldespring.entidades.Producto;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> listar();
    Producto findById(Long id);
    Producto save(Producto producto);
    Producto delete(Producto producto);
    List<Producto> productosId(List<Long> ids);
    List<Producto> buscador(String cadena);
    List<Producto> findByMarca_IdIsNotNull();
    List<Producto> productosDeUnaCompra(Compra c);
    List<Producto> findByMarca_IdEquals(Long id);
}
