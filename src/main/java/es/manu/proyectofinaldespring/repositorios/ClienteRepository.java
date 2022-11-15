package es.manu.proyectofinaldespring.repositorios;

import es.manu.proyectofinaldespring.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("select c from Cliente c where c.correo_electronico = ?1")
    Cliente findByCorreo_electronico(String correo_electronico);






}
