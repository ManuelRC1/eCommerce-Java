package es.manu.proyectofinaldespring.servicio;

import es.manu.proyectofinaldespring.Interfaces.IServicioService;
import es.manu.proyectofinaldespring.entidades.Cliente;
import es.manu.proyectofinaldespring.entidades.Compra;
import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.entidades.Servicio;
import es.manu.proyectofinaldespring.repositorios.ServicioRepository;
import es.manu.proyectofinaldespring.upload.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ServicioService implements IServicioService {

    @Autowired
    private ServicioRepository servicioRepository;


    @Override
    public List<Servicio> listar() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio findById(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    @Override
    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio delete(Servicio servicio) {
        Servicio resultado = findById(servicio.getId());
        servicioRepository.delete(resultado);
        return resultado;
    }

    @Override
    public List<Servicio> buscador(String cadena) {
        return servicioRepository.findByNombreContainsOrLocalizacionContains(cadena, cadena);
    }

    @Override
    public List<Servicio> findByCompania_IdEquals(Long id) {
        return servicioRepository.findByCompania_IdEquals(id);
    }

    @Override
    public List<Servicio> serviciosId(List<Long> ids){
        return servicioRepository.findAllById(ids);
    }

    @Override
    public List<Servicio> serviciosDeUnaCompra(Compra c){
        return servicioRepository.findByCompra(c);
    }
}
