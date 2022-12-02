package es.manu.proyectofinaldespring.Interfaces;


import es.manu.proyectofinaldespring.entidades.Cliente;
import es.manu.proyectofinaldespring.entidades.Compra;

import java.util.List;

public interface ICompraService {
    List<Compra> listar();
    Compra findById(Long id);
    Compra save(Compra compra);
    Compra delete(Compra compra);
    List<Compra> porCliente(Cliente cliente);
}
