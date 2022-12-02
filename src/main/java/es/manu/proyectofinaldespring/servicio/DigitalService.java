package es.manu.proyectofinaldespring.servicio;

import es.manu.proyectofinaldespring.Interfaces.IDigitalService;
import es.manu.proyectofinaldespring.entidades.Categoria;
import es.manu.proyectofinaldespring.entidades.Digital;
import es.manu.proyectofinaldespring.repositorios.DigitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DigitalService implements IDigitalService {

    @Autowired
    private DigitalRepository digitalRepository;

    @Override
    public List<Digital> listar() {
        return digitalRepository.findAll();
    }

    @Override
    public Digital findById(Long id) {
        return digitalRepository.findById(id).orElse(null);
    }

    @Override
    public Digital save(Digital digital) {
        return digitalRepository.save(digital);
    }

    @Override
    public Digital delete(Digital digital) {
        Digital resultado = findById(digital.getId());
        digitalRepository.delete(resultado);
        return resultado;
    }

    @Override
    public List<Digital> buscador(String cadena) {
        return digitalRepository.findByNombreContains(cadena);
    }

    @Override
    public List<Digital> findByMarca_IdIsNotNull() {
        return digitalRepository.findByMarca_IdIsNotNull();
    }
}
