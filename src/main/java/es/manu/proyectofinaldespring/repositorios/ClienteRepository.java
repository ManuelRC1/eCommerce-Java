package es.manu.proyectofinaldespring.repositorios;

import es.manu.proyectofinaldespring.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
