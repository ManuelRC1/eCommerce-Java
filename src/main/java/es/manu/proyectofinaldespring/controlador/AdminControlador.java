package es.manu.proyectofinaldespring.controlador;

import es.manu.proyectofinaldespring.servicio.CategoriaService;
import es.manu.proyectofinaldespring.servicio.DigitalService;
import es.manu.proyectofinaldespring.servicio.ProductoService;
import es.manu.proyectofinaldespring.servicio.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminControlador {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private DigitalService digitalService;

    @Autowired
    private ServicioService servicioService;
}
