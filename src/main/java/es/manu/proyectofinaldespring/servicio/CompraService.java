package es.manu.proyectofinaldespring.servicio;

import es.manu.proyectofinaldespring.Interfaces.ICompraService;
import es.manu.proyectofinaldespring.entidades.Cliente;
import es.manu.proyectofinaldespring.entidades.Compra;
import es.manu.proyectofinaldespring.entidades.Producto;
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

    public List<Compra> porCliente(Cliente cliente){
        return compraRepository.findByCliente(cliente);
    }

    public Compra insertar(Compra compra, HttpSession session){
        Cliente cliente = (Cliente) session.getAttribute("usuario");
        compra.setCliente(cliente);
        return compraRepository.save(compra);
    }

    public Producto addProductoCompra(Producto p, Compra c){
        p.setCompra(c);
        return productoService.save(p);
    }


}
