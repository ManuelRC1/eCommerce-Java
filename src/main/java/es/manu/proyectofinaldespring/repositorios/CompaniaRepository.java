package es.manu.proyectofinaldespring.repositorios;

import es.manu.proyectofinaldespring.entidades.Compania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompaniaRepository extends JpaRepository<Compania, Long> {

    List<Compania> findByNombre(String nombre);

}
