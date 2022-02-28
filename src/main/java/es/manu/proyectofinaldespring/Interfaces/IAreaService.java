package es.manu.proyectofinaldespring.Interfaces;

import es.manu.proyectofinaldespring.entidades.Area;

import java.util.List;

public interface IAreaService {
    List<Area> listar();
    Area findById(Long id);
    Area save(Area area);
    Area delete(Area area);
}
