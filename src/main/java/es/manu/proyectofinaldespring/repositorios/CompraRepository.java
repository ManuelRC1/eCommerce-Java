package es.manu.proyectofinaldespring.repositorios;

import es.manu.proyectofinaldespring.entidades.Cliente;
import es.manu.proyectofinaldespring.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findByCliente(Cliente cliente);


}
