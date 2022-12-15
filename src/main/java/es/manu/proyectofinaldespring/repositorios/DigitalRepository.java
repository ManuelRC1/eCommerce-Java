package es.manu.proyectofinaldespring.repositorios;

import es.manu.proyectofinaldespring.entidades.Compra;
import es.manu.proyectofinaldespring.entidades.Digital;
import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public interface DigitalRepository extends JpaRepository<Digital, Long> {

    List<Digital> findByNombreContains(String nombre);

    @Query("select d from Digital d where d.marca.id is not null")
    List<Digital> findByMarca_IdIsNotNull();

    List<Digital> findByCompra(Compra compra);

    List<Digital> findByMarca_IdEquals(Long id);






}
