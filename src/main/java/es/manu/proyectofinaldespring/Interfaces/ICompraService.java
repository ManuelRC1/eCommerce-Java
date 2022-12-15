package es.manu.proyectofinaldespring.Interfaces;


import es.manu.proyectofinaldespring.entidades.*;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ICompraService {
    List<Compra> listar();
    Compra findById(Long id);
    Compra save(Compra compra);
    Compra delete(Compra compra);
    List<Compra> porCliente(Cliente cliente);
    Compra insertarProductos(Compra compra, HttpSession session);
    Compra insertarServicios(Compra compra, HttpSession session);
    Compra insertarDigitales(Compra compra, HttpSession session);
    Producto addProductoCompra(Producto p, Compra c);
    Servicio addServicioCompra(Servicio s, Compra c);
    Digital addDigitalCompra(Digital d, Compra c);
}
