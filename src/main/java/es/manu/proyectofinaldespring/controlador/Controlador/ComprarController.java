package es.manu.proyectofinaldespring.controlador.Controlador;

import es.manu.proyectofinaldespring.entidades.*;
import es.manu.proyectofinaldespring.repositorios.ClienteRepository;
import es.manu.proyectofinaldespring.repositorios.CompraRepository;
import es.manu.proyectofinaldespring.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    @ModelAttribute("carrito2")
    public List<Servicio> servicioCarrito(){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito2");
        return (contenido == null) ? null : servicioService.serviciosId(contenido);
    }

    @ModelAttribute("carrito3")
    public List<Digital> digitalCarrito(){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito3");
        return (contenido == null) ? null : digitalService.digitalesId(contenido);
    }

    @ModelAttribute("total_carrito")
    public Double totalCarrito(){
        List<Producto> productosCarrito = productosCarrito();
        List<Servicio> servicioCarrito = servicioCarrito();


        if (productosCarrito != null){
            return productosCarrito
                    .stream().mapToDouble(p -> p.getPrecio())
                    .sum();
        }
        return 0.0;
    }

    @ModelAttribute("mis_compras")
    public List<Compra> misCompras(){
        cliente = (Cliente) session.getAttribute("usuario");
        return compraService.porCliente(cliente);
    }

    @GetMapping("/carrito")
    public String verCarrito(){
        return "app/compra/carrito";
    }

    @GetMapping("/carrito/add/producto/{id}")
    public String addCarritoP(@PathVariable Long id){
        if (session.getAttribute("usuario") != null) {
                List<Long> contenido = (List<Long>) session.getAttribute("carrito");
                if (contenido == null)
                    contenido = new ArrayList<>();
                if (!contenido.contains(id))
                    contenido.add(id);
                session.setAttribute("carrito", contenido);
                return "redirect:/app/carrito";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/carrito/add/servicio/{id}")
    public String addCarritoS(@PathVariable Long id){
        if (session.getAttribute("usuario") != null) {
        List<Long> contenido = (List<Long>) session.getAttribute("carrito2");
        if (contenido == null)
            contenido = new ArrayList<>();
        if (!contenido.contains(id))
            contenido.add(id);
        session.setAttribute("carrito2", contenido);
        return "redirect:/app/carrito";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/carrito/add/digital/{id}")
    public String addCarritoD(@PathVariable Long id){
        if (session.getAttribute("usuario") != null) {
            List<Long> contenido = (List<Long>) session.getAttribute("carrito3");
            if (contenido == null)
                contenido = new ArrayList<>();
            if (!contenido.contains(id))
                contenido.add(id);
            session.setAttribute("carrito3", contenido);
            return "redirect:/app/carrito";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/carrito/eliminar/producto/{id}")
    public String borrarDelCarritoP(@PathVariable Long id){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        if (contenido == null)
            return "redirect:/tipo/producto";
        contenido.remove(id);
        if (contenido.isEmpty())
            session.removeAttribute("carrito");
        else
            session.setAttribute("carrito", contenido);
        return "redirect:/app/carrito";
    }

    @GetMapping("/carrito/eliminar/servicio/{id}")
    public String borrarDelCarritoS(@PathVariable Long id){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito2");
        if (contenido == null)
            return "redirect:/tipo/servicio";
        contenido.remove(id);
        if (contenido.isEmpty())
            session.removeAttribute("carrito2");
        else
            session.setAttribute("carrito2", contenido);
        return "redirect:/app/carrito";
    }

    @GetMapping("/carrito/eliminar/digital/{id}")
    public String borrarDelCarritoD(@PathVariable Long id){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito3");
        if (contenido == null)
            return "redirect:/tipo/digital";
        contenido.remove(id);
        if (contenido.isEmpty())
            session.removeAttribute("carrito3");
        else
            session.setAttribute("carrito3", contenido);
        return "redirect:/app/carrito";
    }



    @GetMapping("/carrito/producto/finalizar")
    public String checkoutProducto(){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        if (contenido == null)
            return "redirect:/tipo/producto";
        List<Producto> productos = productosCarrito();

        Compra c = compraService.insertarProductos(new Compra(), session);

        productos.forEach(p -> compraService.addProductoCompra(p, c));
        session.removeAttribute("carrito");

        return "redirect:/app/compra/factura/producto/"+ c.getId();
    }

    @GetMapping("/carrito/servicio/finalizar")
    public String checkoutServicio(){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito2");
        if (contenido == null)
            return "redirect:/tipo/servicio";
        List<Servicio> servicios = servicioCarrito();

        Compra c = compraService.insertarServicios(new Compra(), session);

        servicios.forEach(s -> compraService.addServicioCompra(s, c));
        session.removeAttribute("carrito2");

        return "redirect:/app/compra/factura/servicio/" + c.getId();
    }

    @GetMapping("/carrito/digital/finalizar")
    public String checkoutDigital(){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito3");
        if (contenido == null)
            return "redirect:/tipo/digital";
        List<Digital> digitales = digitalCarrito();

        Compra c = compraService.insertarDigitales(new Compra(), session);

        digitales.forEach(d -> compraService.addDigitalCompra(d, c));
        session.removeAttribute("carrito3");

        return "redirect:/app/compra/factura/digital/" + c.getId();
    }

    @GetMapping("/compra/factura/producto/{id}")
    public String facturaProducto(Model model, @PathVariable Long id){
        Compra c = compraService.findById(id);
        List<Producto> productos = productoService.productosDeUnaCompra(c);
        model.addAttribute("productos", productos);
        model.addAttribute("compra", c);
        model.addAttribute("total_compra", productos.stream().mapToDouble(p -> p.getPrecio()).sum());
        return "app/compra/factura";
    }

    @GetMapping("/compra/factura/servicio/{id}")
    public String facturaServicio(Model model, @PathVariable Long id){
        Compra c = compraService.findById(id);
        List<Servicio> servicios = servicioService.serviciosDeUnaCompra(c);
        model.addAttribute("servicios", servicios);
        model.addAttribute("compra", c);
        model.addAttribute("total_compra", servicios.stream().mapToDouble(s -> s.getPrecio()).sum());
        return "app/compra/factura";
    }

    @GetMapping("/compra/factura/digital/{id}")
    public String facturaDigital(Model model, @PathVariable Long id){
        Compra c = compraService.findById(id);
        List<Digital> digitales = digitalService.digitalesDeUnaCompra(c);
        model.addAttribute("digitales", digitales);
        model.addAttribute("compra", c);
        model.addAttribute("total_compra", digitales.stream().mapToDouble(d -> d.getPrecio()).sum());
        return "app/compra/factura";
    }


    @GetMapping("/miscompras")
    public String verMisCompras(Model model){
        return "app/compra/listado";
    }



}
