package es.manu.proyectofinaldespring.repositorios;

import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    List<Servicio> findByNombreContainsOrLocalizacionContains(String Nombre, String localizacion);

    @Query("select s from Servicio s where s.compania.id = ?1")
    List<Servicio> findByCompania_IdEquals(Long id);




}
