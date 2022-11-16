package es.manu.proyectofinaldespring.repositorios;

import es.manu.proyectofinaldespring.entidades.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Repository
public interface MarcasRepository extends JpaRepository<Marca, Long> {

    List<Marca> findByNombre(String nombre);




}
