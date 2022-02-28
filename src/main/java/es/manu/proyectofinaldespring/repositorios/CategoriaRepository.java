package es.manu.proyectofinaldespring.repositorios;

import es.manu.proyectofinaldespring.entidades.Categoria;
import es.manu.proyectofinaldespring.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByNombreContains(String nombre);

}
