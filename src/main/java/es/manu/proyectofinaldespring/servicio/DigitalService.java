package es.manu.proyectofinaldespring.servicio;

import es.manu.proyectofinaldespring.Interfaces.IDigitalService;
import es.manu.proyectofinaldespring.entidades.*;
import es.manu.proyectofinaldespring.repositorios.DigitalRepository;
import es.manu.proyectofinaldespring.upload.StorageService;
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

    @Override
    public List<Digital> digitalesId(List<Long> ids){
        return digitalRepository.findAllById(ids);
    }

    @Override
    public List<Digital> digitalesDeUnaCompra(Compra c){
        return digitalRepository.findByCompra(c);
    }

    @Override
    public List<Digital> findByMarca_IdEquals(Long id){
        return digitalRepository.findByMarca_IdEquals(id);
    }
}
