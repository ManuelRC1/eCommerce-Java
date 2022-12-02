package es.manu.proyectofinaldespring.controlador.Controlador;

import es.manu.proyectofinaldespring.entidades.Cliente;
import es.manu.proyectofinaldespring.entidades.Compra;
import es.manu.proyectofinaldespring.entidades.Producto;
import es.manu.proyectofinaldespring.repositorios.ClienteRepository;
import es.manu.proyectofinaldespring.repositorios.CompraRepository;
import es.manu.proyectofinaldespring.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class ComprarController {

    @Autowired
    HttpSession session;

    private Cliente cliente;

    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private DigitalService digitalService;

    @Autowired
    private ServicioService servicioService;

    @ModelAttribute("carrito")
    public List<Producto> productosCarrito(){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        return (contenido == null) ? null : productoService.productosId(contenido);
    }

    @ModelAttribute("total_carrito")
    public Double totalCarrtio(){
        List<Producto> productosCarrito = productosCarrito();
        if (productosCarrito != null){
            return productosCarrito.stream()
                    .mapToDouble(p -> p.getPrecio())
                    .sum();
        }
        return 0.0;
    }

    @ModelAttribute("mis_compras")
    public List<Compra> misCompras(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        cliente = clienteService.findByCorreo_electronico(email);
        return compraService.porCliente(cliente);
    }

    @GetMapping("/carrito")
    public String verCarrito(Model model){
        return "app/compra/carrito";
    }

    @GetMapping("/carrito/add/{id}")
    public String addCarrito(Model model, @PathVariable Long id){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        if (contenido == null)
            contenido = new ArrayList<>();
        if (!contenido.contains(id))
            contenido.add(id);
        session.setAttribute("carrito", contenido);
        return "redirect:/app/carrito";
    }

    @GetMapping("/carrito/eliminar/{id}")
    public String borrarDelCarrito(Model model, @PathVariable Long id){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        if (contenido == null)
            return "redirect:/public/tienda";
        contenido.remove(id);
        if (contenido.isEmpty())
            session.removeAttribute("carrito");
        else
            session.setAttribute("carrito", contenido);
        return "redirect:/app/carrito";
    }

    @GetMapping("/carrito/finalizar")
    public String checkout(){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        if (contenido == null)
            return "redirect:/public/tienda";
        List<Producto> productos = productosCarrito();

        Compra c = compraService.insertar(new Compra(), session);

        productos.forEach(p -> compraService.addProductoCompra(p, c));
        session.removeAttribute("carrito");

        return "redirect:/app/compra/factura/"+c.getId();
    }

    @GetMapping("/compra/factura/{id}")
    public String factura(Model model, @PathVariable Long id){
        Compra c = compraService.findById(id);
        List<Producto> productos = productoService.productosDeUnaCompra(c);
        model.addAttribute("productos", productos);
        model.addAttribute("compra", c);
        model.addAttribute("total_compra", productos.stream().mapToDouble(p -> p.getPrecio()).sum());
        return "app/compra/factura";
    }


    @GetMapping("/miscompras")
    public String verMisCompras(Model model){
        return "app/compra/listado";
    }



}
