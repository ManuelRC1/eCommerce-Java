package es.manu.proyectofinaldespring.servicio;

import es.manu.proyectofinaldespring.Interfaces.ICompraService;
import es.manu.proyectofinaldespring.entidades.*;
import es.manu.proyectofinaldespring.repositorios.CompraRepository;
import es.manu.proyectofinaldespring.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CompraService implements ICompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private DigitalService digitalService;




    @Override
    public List<Compra> listar() {
        return compraRepository.findAll();
    }

    @Override
    public Compra findById(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    @Override
    public Compra save(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public Compra delete(Compra compra) {
        Compra resultado = findById(compra.getId());
        compraRepository.delete(resultado);
        return resultado;
    }
    @Override
    public List<Compra> porCliente(Cliente cliente){
        return compraRepository.findByCliente(cliente);
    }

    @Override
    public Compra insertarProductos(Compra compra, HttpSession session){
        Cliente cliente = (Cliente) session.getAttribute("usuario");
        compra.setCliente(cliente);
        return compraRepository.save(compra);
    }
    @Override
    public Compra insertarServicios(Compra compra, HttpSession session){
        Cliente cliente = (Cliente) session.getAttribute("usuario");
        compra.setCliente(cliente);
        return compraRepository.save(compra);
    }

    @Override
    public Compra insertarDigitales(Compra compra, HttpSession session){
        Cliente cliente = (Cliente) session.getAttribute("usuario");
        compra.setCliente(cliente);
        return compraRepository.save(compra);
    }

    @Override
    public Producto addProductoCompra(Producto p, Compra c){
        p.setCompra(c);
        return productoService.save(p);
    }

    @Override
    public Servicio addServicioCompra(Servicio s, Compra c){
        s.setCompra(c);
        return servicioService.save(s);
    }

    @Override
    public Digital addDigitalCompra(Digital d, Compra c){
        d.setCompra(c);
        return digitalService.save(d);
    }



}
