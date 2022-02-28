package es.manu.proyectofinaldespring.repositorios;

import es.manu.proyectofinaldespring.entidades.Compania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniaRepository extends JpaRepository<Compania, Long> {

}
