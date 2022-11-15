package es.manu.proyectofinaldespring.Interfaces;

import es.manu.proyectofinaldespring.entidades.Cliente;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    List<Cliente> listar();
    Cliente findById(Long id);
    Cliente save(Cliente compania);
    Cliente delete(Cliente compania);
    Cliente findByCorreo_electronico(String correo_electronico);
    Cliente registro (Cliente cliente, BCryptPasswordEncoder bCryptPasswordEncoder);
}
