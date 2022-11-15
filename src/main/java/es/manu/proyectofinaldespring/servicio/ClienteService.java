package es.manu.proyectofinaldespring.servicio;

import es.manu.proyectofinaldespring.Interfaces.IClienteService;
import es.manu.proyectofinaldespring.entidades.Cliente;
import es.manu.proyectofinaldespring.repositorios.CategoriaRepository;
import es.manu.proyectofinaldespring.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente delete(Cliente cliente) {
        Cliente resultado = findById(cliente.getId());
        clienteRepository.delete(resultado);
        return resultado;
    }

    @Override
    public Cliente findByCorreo_electronico(String correo_electronico) {
        return clienteRepository.findByCorreo_electronico(correo_electronico);
    }

    @Override
    public Cliente registro(Cliente cliente, BCryptPasswordEncoder bCryptPasswordEncoder) {
        cliente.setContrasena(bCryptPasswordEncoder.encode(cliente.getContrasena()));
        return  clienteRepository.save(cliente);
    }
}


