package es.manu.proyectofinaldespring.servicio;

import es.manu.proyectofinaldespring.Interfaces.ICompaniaService;
import es.manu.proyectofinaldespring.entidades.Compania;
import es.manu.proyectofinaldespring.entidades.Digital;
import es.manu.proyectofinaldespring.entidades.Servicio;
import es.manu.proyectofinaldespring.repositorios.CompaniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompaniaService implements ICompaniaService {

    @Autowired
    private CompaniaRepository companiaRepository;

    @Override
    public List<Compania> listar() {
        return companiaRepository.findAll();
    }

    @Override
    public Compania findById(Long id) {
        return companiaRepository.findById(id).orElse(null);
    }

    @Override
    public Compania save(Compania compania) {
        return companiaRepository.save(compania);
    }

    @Override
    public Compania delete(Compania compania) {
        Compania resultado = findById(compania.getId());
        companiaRepository.delete(resultado);
        return resultado;
    }
    @Override
    public List<Compania> buscador(String cadena) {
        return companiaRepository.findByNombre(cadena);
    }
}
