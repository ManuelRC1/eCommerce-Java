package es.manu.proyectofinaldespring.Interfaces;

import es.manu.proyectofinaldespring.entidades.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> listar();
    Cliente findById(Long id);
    Cliente save(Cliente compania);
    Cliente delete(Cliente compania);
}
