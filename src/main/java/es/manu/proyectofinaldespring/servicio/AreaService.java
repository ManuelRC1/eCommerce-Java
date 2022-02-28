package es.manu.proyectofinaldespring.servicio;

import es.manu.proyectofinaldespring.Interfaces.IAreaService;
import es.manu.proyectofinaldespring.entidades.Area;
import es.manu.proyectofinaldespring.entidades.Marca;
import es.manu.proyectofinaldespring.repositorios.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService implements IAreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> listar() {
        return areaRepository.findAll();
    }

    @Override
    public Area findById(Long id) {
        return areaRepository.findById(id).orElse(null);
    }

    @Override
    public Area save(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public Area delete(Area area) {
        Area resultado = findById(area.getId());
        areaRepository.delete(resultado);
        return resultado;
    }
}
