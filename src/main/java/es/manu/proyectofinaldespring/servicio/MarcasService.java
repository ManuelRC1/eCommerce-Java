package es.manu.proyectofinaldespring.servicio;

import es.manu.proyectofinaldespring.Interfaces.IMarcasService;
import es.manu.proyectofinaldespring.entidades.Marca;
import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.repositorios.MarcasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcasService implements IMarcasService {

    @Autowired
    private MarcasRepository marcasRepository;


    @Override
    public List<Marca> listar() {
        return marcasRepository.findAll();
    }

    @Override
    public Marca findById(Long id) {
        return marcasRepository.findById(id).orElse(null);
    }

    @Override
    public Marca save(Marca marca) {
        return marcasRepository.save(marca);
    }

    @Override
    public Marca delete(Marca marca) {
        Marca resultado = findById(marca.getId());
        marcasRepository.delete(resultado);
        return resultado;
    }
}
