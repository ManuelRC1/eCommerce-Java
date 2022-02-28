package es.manu.proyectofinaldespring.repositorios;

import es.manu.proyectofinaldespring.entidades.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
