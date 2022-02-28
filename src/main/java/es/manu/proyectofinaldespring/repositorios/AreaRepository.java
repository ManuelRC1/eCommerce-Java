package es.manu.proyectofinaldespring.repositorios;

import es.manu.proyectofinaldespring.entidades.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
}
