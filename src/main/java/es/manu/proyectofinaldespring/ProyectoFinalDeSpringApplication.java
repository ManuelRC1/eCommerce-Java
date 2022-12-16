package es.manu.proyectofinaldespring;

import es.manu.proyectofinaldespring.entidades.*;
import es.manu.proyectofinaldespring.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class ProyectoFinalDeSpringApplication
        implements CommandLineRunner {
    @Autowired
    AreaRepository areaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    CompaniaRepository companiaRepository;

    @Autowired
    MarcasRepository marcasRepository;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    ServicioRepository servicioRepository;

    @Autowired
    DigitalRepository digitalRepository;


    public static void main(String[] args)
    {
        SpringApplication.run(ProyectoFinalDeSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Date dateP1 = new Date(1327252800000L);
        Date dateP2 = new Date(1499188800000L);
        Date dateP3 = new Date(1480872000000L);
        Date dateP4 = new Date(1233163200000L);
        Date dateP5 = new Date(1551374400000L);
        Date dateP6 = new Date(1642094400000L);
        Date dateP7 = new Date(1412529600000L);
        Date dateP8 = new Date(1627406400000L);
        Date dateP9 = new Date(1280942400000L);
        Date dateP10 = new Date(1438708800000L);
        Date dateP11 = new Date(1345137600000L);
        Date dateP12 = new Date(1417713600000L);
        Date dateP13 = new Date(1521566400000L);
        Date dateP14 = new Date(1526836800000L);
        Date dateP15 = new Date(1515172800000L);
        Date dateP16 = new Date(1178731200000L);


        Area area1 = new Area(1L, "Zona 1");
        Area area2  = new Area( 2L, "Zona 2");
        Area area3 = new Area( 3L, "Zona 3");

        areaRepository.save(area1);
        areaRepository.save(area2);
        areaRepository.save(area3);

        Categoria categoria1 = new Categoria(1L,"Productos", "/img/categorias/productos.jpg");
        Categoria categoria2 = new Categoria(2L, "Servicios","/img/categorias/servicios.jpg");
        Categoria categoria3 = new Categoria(3L, "Digital", "/img/categorias/digitales.jpg");

        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);
        categoriaRepository.save(categoria3);



        Marca marca = new Marca(1L, "Hasbro", 1945, "/img/marcas/hasbro.jpg");
        Marca marca1 = new Marca(2L, "Devir", 1934, "/img/marcas/devir.jpg");
        Marca marca2 = new Marca(3L, "Edge", 1956, "/img/marcas/edge.jpg");
        Marca marca3 = new Marca(4L,"McAfee", 1954, "/img/marcas/mcafee.jpg");
        Marca marca4 = new Marca(5L, "Destino", 1960, "/img/marcas/destino.jpg");
        Marca marca5 = new Marca(6L, "Planeta", 1910, "/img/marcas/planeta.jpg");
        Marca marca6 = new Marca(7L,"Microsoft", 1989, "/img/marcas/office.jpg");
        Marca marca7 = new Marca(8L,"Karpesky", 1921, "/img/marcas/karpesky.jpg");
        Marca marca8 = new Marca(9L, "Asmodee", 2013, "/img/marcas/asmodee.jpg");

        marcasRepository.save(marca);
        marcasRepository.save(marca1);
        marcasRepository.save(marca2);
        marcasRepository.save(marca3);
        marcasRepository.save(marca4);
        marcasRepository.save(marca5);
        marcasRepository.save(marca6);
        marcasRepository.save(marca7);
        marcasRepository.save(marca8);

        Producto producto = new Producto(1L, "La Vall de la Llum", dateP1, "papel y carton", "/img/productos/laVallDeLaLlum.jpg", 15.0,  area1, categoria1, marca2);
        Producto producto1 = new Producto(2L, "Violeta", dateP2, "papel", "/img/productos/violeta.jpg", 10.0, area1, categoria1, marca5);
        Producto producto2 = new Producto(3L, "La Bestia", dateP3, "papel y carton", "/img/productos/bestia.jpg", 11.0, area1, categoria1, marca4);
        Producto producto15 = new Producto(15L, "Réplica Star Wars - Casco de piloto de Luke Skywalker", dateP4, "carton y plastico", "/img/productos/casco.jpg", 99.0, area1, categoria1, marca);
        Producto producto3 = new Producto(4L, "El Juicio del Agua", dateP5, "papel y carton", "/img/productos/juicioDelAgua.jpg", 16.0, area1, categoria1, marca2);
        Producto producto4 = new Producto(5L, "La Primera Detective", dateP6, "papel y carton", "/img/productos/primeraDetective.jpg", 11.0, area1, categoria1, marca4);
        Producto producto16 = new Producto(16L, "Mi Pequeña Biblioteca (Peppa Pig)", dateP7, "plastico", "/img/productos/peppaPig.jpg",20.0, area1, categoria1, marca1);
        Producto producto5 = new Producto(5L, "Bajo la Misma Estrella", dateP8, "papel y carton", "/img/productos/mismaEstrella.jpg", 25.0, area1, categoria1, marca5);
        Producto producto6 = new Producto(6L, "Todo arde", dateP9, "papel y carton", "/img/productos/todoArde.jpg", 9.0, area1, categoria1, marca4);
        Producto producto7 = new Producto(7L, "Todo va a mejorar", dateP10, "papel", "/img/productos/todoMejorar.jpg", 8.0, area1, categoria1, marca5);
        Producto producto13 = new Producto(13L, "Bop it! Star Wars", dateP11, "carton y plastico", "/img/productos/Bop_itStarWars.jpg", 30.0, area1, categoria1, marca);
        Producto producto14 = new Producto(14L, "Tragabolas", dateP12, "plastico", "/img/productos/tragabolas.jpg",20.0, area1, categoria1, marca1);
        Producto producto8 = new Producto(8L, "Lejos de Luisiana", dateP13, "papel y carton", "/img/productos/lejosLuisiana.jpg", 21.0, area1, categoria1, marca4);
        Producto producto9 = new Producto(9L, "Se tiene que morir mucha gente", dateP14, "papel y carton", "/img/productos/morirGente.jpg", 12.0, area1, categoria1, marca5);
        Producto producto10 = new Producto(10L, "Historias de mujeres casadas", dateP15, "papel y carton", "/img/productos/historiaMujeres.jpg",13.0, area1, categoria1, marca4);
        Producto producto11 = new Producto(11L, "Juego de cartas Introducción Yo-Kai 2", dateP16, "carton y plastico", "/img/productos/yoKai.jpg", 40.0, area1, categoria1, marca);
        Producto producto12 = new Producto(12L, "Exit: el juego: El cementerio de las tinieblas", dateP14, "plastico", "/img/productos/exitCementerio.jpg",39.0, area1, categoria1, marca1);

        productoRepository.save(producto);
        productoRepository.save(producto1);
        productoRepository.save(producto2);
        productoRepository.save(producto3);
        productoRepository.save(producto4);
        productoRepository.save(producto5);
        productoRepository.save(producto6);
        productoRepository.save(producto7);
        productoRepository.save(producto8);
        productoRepository.save(producto9);
        productoRepository.save(producto10);
        productoRepository.save(producto11);
        productoRepository.save(producto12);
        productoRepository.save(producto13);
        productoRepository.save(producto14);
        productoRepository.save(producto15);
        productoRepository.save(producto16);

        Compania compania = new Compania(1L, "Iberia", 1923, "media", "/img/companias/iberia.png");
        Compania compania1 = new Compania(2L, "Air Europa", 1923, "media-alta", "/img/companias/airEuropa.png");
        Compania compania2 = new Compania(3L, "Turkish Airlines", 1975, "alta", "/img/companias/turkishAirlines.png");
        Compania compania3 = new Compania(4L, "Emirates", 2001, "muy alta", "/img/companias/emirates.png");


        companiaRepository.save(compania);
        companiaRepository.save(compania1);
        companiaRepository.save(compania2);
        companiaRepository.save(compania3);


        Servicio servicio1 = new Servicio(1L, "Caja Regalo Iberia - Dos días de evasión", "/img/servicios/2Evasion.jpg", dateP5, 7, 2, "MADRID - PARIS - LONDRES - BARCELONA - SEVILLA", 159.0, area2, compania, categoria2);
        Servicio servicio2 = new Servicio(2L, "Caja Regalo Air Europa - Sueños únicos para dos", "/img/servicios/sueñosUnicos.jpg", dateP1, 8, 3, "BARCELONA - MADRID - ROMA - PARIS - COPENHAGEN", 199.0, area2, compania1, categoria2);
        Servicio servicio3 = new Servicio(3L, "Caja Regalo Emirates - Ilusiones para dos", "/img/servicios/2Ilusion.jpg", dateP2, 7, 7, "ZARAGOZA -TOLEDO - JAEN - VALENCIA - LUGO", 299.0, area2, compania3, categoria2);
        Servicio servicio4 = new Servicio(4L, "Caja Regalo Turkish Airlines - Selección mágica", "/img/servicios/seleccionMagica.jpg", dateP3, 7, 3, "MADRID - PARIS - BERNA - ATENAS - BAKU", 259.0, area2, compania2, categoria3);
        Servicio servicio5 = new Servicio(5L, "Caja Regalo Emirates - Dos días con encanto", "/img/servicios/2Encanto.jpg", dateP4, 8, 2, "BILBAO - SAN SEBASTIAN - HUESCA - PAMPLONA - ALAVA", 99.0, area2, compania3, categoria1);
        Servicio servicio6 = new Servicio(6L, "Caja Regalo Iberia - Viaje de desconexión", "/img/servicios/desconexion.jpg", dateP6, 8, 4, "ALMERIA - GRANADA - CORDOBA - CADIZ - HUELVA", 129.0, area2, compania, categoria1);
        Servicio servicio7 = new Servicio(7L, "Caja regalo Air Europa - Tres días juntos por Europa", "/img/servicios/3europa.jpg", dateP7, 7, 3, "LIUBLIANA - ZAGREB - BUCAREST - SARAJEVO - NICOSIA", 359.0, area2, compania1, categoria1);
        Servicio servicio8 = new Servicio(8L, "Caja regalo Emirates - Tres días mágicos por Europa", "/img/servicios/3magicos.jpg", dateP8, 8, 3, "PARIS - BERLIN - OSLO - REYKYAVIK - ESTOCOLMO", 309.0, area2, compania3, categoria1);
        Servicio servicio9 = new Servicio(9L, "Caja regalo Iberia - Escapada cinco días", "/img/servicios/5escapada.jpg", dateP9, 8, 5, "LEON - BURGOS - VALLADOLID - AVILA - SEGOVIA", 209.0, area2, compania, categoria1);
        Servicio servicio10 = new Servicio(10L, "Caja regalo Turkish Airlines - Mil y una noches de ensueño", "/img/servicios/milNoches.jpg", dateP10, 8, 7, "CUENCA - TOLEDO - GUADALAJARA - CIUDAD REAL - ALBACETE", 199.0, area2, compania2, categoria1);
        Servicio servicio11 = new Servicio(11L, "Caja regalo Air Europa - Noche y cena para dos", "/img/servicios/nocheCena.jpg", dateP11, 7, 1, "NANTES - BRUJAS - PARIS - MANCHESTER - DUBLIN", 99.0, area2, compania1, categoria1);
        Servicio servicio12 = new Servicio(12L, "Caja regalo Turkish Airlines - Felicidad para dos", "/img/servicios/felicidad.jpg", dateP12, 7, 4, "MARRUECOS - LA VALLETA - MENORCA - MALLORCA", 299.0, area2, compania2, categoria1);



        servicioRepository.save(servicio1);
        servicioRepository.save(servicio2);
        servicioRepository.save(servicio3);
        servicioRepository.save(servicio4);
        servicioRepository.save(servicio5);
        servicioRepository.save(servicio6);
        servicioRepository.save(servicio7);
        servicioRepository.save(servicio8);
        servicioRepository.save(servicio9);
        servicioRepository.save(servicio10);
        servicioRepository.save(servicio11);
        servicioRepository.save(servicio12);

        Digital digital1 = new Digital(1L, "/img/digitales/office1.jpg", "Microsoft Office pro plus 2021", 12, 65261655, 130.0, area3, marca6, categoria3);
        Digital digital2 = new Digital(2L, "/img/digitales/karpesky1.jpg", "Kaspersky Total Security", 24, 65261656, 140.0, area3, marca7, categoria3);
        Digital digital3 = new Digital(3L, "/img/digitales/mcafee1.jpg", "McAfee LiveSafe", 24, 65261657, 160.0,  area3, marca3, categoria3);
        Digital digital4 = new Digital(4L, "/img/digitales/office2.jpg", "Office 365 personal", 12, 65261658, 169.0, area3, marca6, categoria3);
        Digital digital5 = new Digital(5L, "/img/digitales/karpesky2.jpg", "Kaspersky Internet Security", 24, 65261659, 50.0, area3, marca7, categoria3);
        Digital digital6 = new Digital(6L, "/img/digitales/karpesky3.jpg", "Antivirus Kaspersky 2019", 12, 65261659, 90.0, area3, marca7, categoria3);
        Digital digital7 = new Digital(7L, "/img/digitales/office3.jpg", "Office 2021 Hogar y Empresa Mac", 12, 65261658, 50.0, area3, marca6, categoria3);
        Digital digital8 = new Digital(8L, "/img/digitales/mcafee2.jpg", "McAfee Total Protection 2017", 24, 65261657, 90.0,  area3, marca3, categoria3);
        Digital digital9 = new Digital(8L, "/img/digitales/mcafee3.jpg", "McAfee Total Protection", 12, 65261657, 160.0,  area3, marca3, categoria3);


        digitalRepository.save(digital1);
        digitalRepository.save(digital2);
        digitalRepository.save(digital3);
        digitalRepository.save(digital4);
        digitalRepository.save(digital5);
        digitalRepository.save(digital6);
        digitalRepository.save(digital7);
        digitalRepository.save(digital8);
        digitalRepository.save(digital9);

    }
}
