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

        Date date1 = new Date(1346524199000L);

        Area area1 = new Area(1L, "Zona 1");
        Area area2  = new Area( 2L, "Zona 2");
        Area area3 = new Area( 3L, "Zona 3");

        areaRepository.save(area1);
        areaRepository.save(area2);
        areaRepository.save(area3);

        Categoria categoria1 = new Categoria(1L,"libros", "https://blog.orange.es/wp-content/uploads/sites/4/2021/09/todointernet.jpg");
        Categoria categoria2 = new Categoria(2L, "servicios","https://blog.orange.es/wp-content/uploads/sites/4/2021/09/todointernet.jpg");
        Categoria categoria3 = new Categoria(3L, "digital", "https://es-commerce.com/imagenes/como-crear-una-tienda-online-de-productos-de-segunda-mano.jpg");

        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);
        categoriaRepository.save(categoria3);

        Compania compania = new Compania(1L, "iberia", 1923, "media", "https://www.aeropuertoinfo.com/wp-content/uploads/Logo-Iberia.png");
        Compania compania1 = new Compania(2L, "Air Europa", 1923, "media-alta", "https://1000marcas.net/wp-content/uploads/2020/11/Air-Europa-logo.png");
        Compania compania2 = new Compania(3L, "Turkish Airlines", 1975, "alta", "https://1000marcas.net/wp-content/uploads/2020/03/logo-Turkish-Airlines.png");
        Compania compania3 = new Compania(4L, "Emirates", 2001, "muy alta", "https://logos-marcas.com/wp-content/uploads/2020/12/Emirates-Simbolo.png");


        companiaRepository.save(compania);
        companiaRepository.save(compania1);
        companiaRepository.save(compania2);
        companiaRepository.save(compania3);

        Marca marca = new Marca(1L, "Hasbro", 1945, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Hasbro_4c_no_R.png/1024px-Hasbro_4c_no_R.png");
        Marca marca1 = new Marca(2L, "Devir", 1934, "https://yt3.ggpht.com/ytc/AKedOLQNlslsaaTg6EpR5HNWBoDFw2BdoY91ZXsCI9312g=s900-c-k-c0x00FFF-no-rj");
        Marca marca2 = new Marca(3L, "Edge", 1956, "http://www.edgeent.com/static/img/LOGO_EDGE_WHITE.jpg");
        Marca marca3 = new Marca(4L, "Asmodee", 2013, "https://wargarage.org/wp-content/uploads/2018/05/asmodee-logo.jp");
        Marca marca4 = new Marca(5L, "Destino", 1960, "https://www.planetadelibros.com/img/sellos_og/logo_DESTINO.jpg");
        Marca marca5 = new Marca(6L, "Planeta", 1910, "https://pbs.twimg.com/profile_images/1274933503864590341/20Imga6R_400x400.png");
        Marca marca6 = new Marca(7L,"Microsoft", 1989, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Microsoft_Office_logo_%282019%E2%80%93present%29.svg/640px-Microsoft_Office_logo_%282019%E2%80%93present%29.svg.png");
        Marca marca7 = new Marca(8L,"Karpesky", 1921, "https://latam.kaspersky.com/content/es-mx/images/repository/pr/the-company-unveils-new-branding-and-visual-identity-1.jpg");
        Marca marca8 = new Marca(9L,"McAfee", 1954, "https://i.blogs.es/a4eda0/mcafee/1366_2000.jpeg");

        marcasRepository.save(marca);
        marcasRepository.save(marca1);
        marcasRepository.save(marca2);
        marcasRepository.save(marca3);
        marcasRepository.save(marca4);
        marcasRepository.save(marca5);
        marcasRepository.save(marca6);
        marcasRepository.save(marca7);
        marcasRepository.save(marca8);

        Producto producto = new Producto(1L, "La Vall de la Llum", date1, "papel y carton", "https://static.fnac-static.com/multimedia/Images/ES/NR/a0/b9/6f/7322016/1540-1.jpg", area1, categoria1, marca4);
        Producto producto1 = new Producto(2L, "Violeta", date1, "papel", "https://static.fnac-static.com/multimedia/Images/ES/NR/da/2b/6a/6958042/1540-1.jpg", area1, categoria1, marca5);
        Producto producto2 = new Producto(3L, "La bestia", date1, "papel y carton", "https://static.fnac-static.com/multimedia/Images/ES/NR/bb/6d/6d/7171515/1540-1.jpg", area1, categoria1, marca4);
        Producto producto3 = new Producto(4L, "El juicio del agua", date1, "papel y carton", "https://static.fnac-static.com/multimedia/Images/ES/NR/30/8b/61/6392624/1540-1.jpg", area1, categoria1, marca5);
        Producto producto4 = new Producto(5L, "La bestia", date1, "papel y carton", "https://static.fnac-static.com/multimedia/Images/ES/NR/e8/c1/74/7651816/1540-1.jpg", area1, categoria1, marca4);
        Producto producto5 = new Producto(5L, "Bajo la misma estrella", date1, "papel y carton", "https://static.fnac-static.com/multimedia/Images/ES/NR/8a/f8/0a/718986/1540-1.jpg", area1, categoria1, marca4);
        Producto producto6 = new Producto(6L, "La Vall de la Llum", date1, "papel y carton", "https://static.fnac-static.com/multimedia/Images/ES/NR/a0/b9/6f/7322016/1540-1.jpg", area1, categoria1, marca4);
        Producto producto7 = new Producto(7L, "Violeta", date1, "papel", "https://static.fnac-static.com/multimedia/Images/ES/NR/da/2b/6a/6958042/1540-1.jpg", area1, categoria1, marca5);
        Producto producto8 = new Producto(8L, "La bestia", date1, "papel y carton", "https://static.fnac-static.com/multimedia/Images/ES/NR/bb/6d/6d/7171515/1540-1.jpg", area1, categoria1, marca4);
        Producto producto9 = new Producto(9L, "El juicio del agua", date1, "papel y carton", "https://static.fnac-static.com/multimedia/Images/ES/NR/30/8b/61/6392624/1540-1.jpg", area1, categoria1, marca5);
        Producto producto10 = new Producto(10L, "La bestia", date1, "papel y carton", "https://static.fnac-static.com/multimedia/Images/ES/NR/e8/c1/74/7651816/1540-1.jpg", area1, categoria1, marca4);

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

        Servicio servicio1 = new Servicio(1L, "Aeropuerto Adolfo Suarez", "https://graffica.info/wp-content/uploads/2014/05/01-aeropuerto-barajas-Adolfo-Suarez.jpg", date1, 14, 3, "vuelo a Milan", area2, compania, categoria2);
        Servicio servicio2 = new Servicio(2L, "Aeropuerto de El Prat", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Barcelona%E2%80%93El_Prat_Airport_logo.jpg/800px-Barcelona%E2%80%93El_Prat_Airport_logo.jpg?20130412135447", date1, 18, 5, "vuelo a Kiev", area2, compania1, categoria2);
        Servicio servicio3 = new Servicio(3L, "Aeropuerto internacional Jorge Chavez", "https://www.tec.com.pe/wp-content/uploads/2016/07/lima-airport-e1469213052886.png", date1, 7, 12, "vuelo a Madrid", area2, compania3, categoria2);
        Servicio servicio4 = new Servicio(4L, "Aeropuerto de Paris", "https://i0.wp.com/www.elpoderdelasideas.com/wp-content/uploads/paris_aeroport_logo_detalles-600x398.png?resize=600%2C398", date1, 7, 11, "vuelo a Tokio", area2, compania2, categoria3);
        Servicio servicio5 = new Servicio(5L, "Aeropuerto de Roma", "https://thumbs.dreamstime.com/z/sello-de-roma-del-aeropuerto-fiumicino-logotipo-la-circunvalación-con-ubicación-en-el-mapa-italia-marcado-por-avión-ejemplo-204305151.jpg", date1, 7, 2, "vuelo a Barcelona", area2, compania3, categoria1);



        servicioRepository.save(servicio1);
        servicioRepository.save(servicio2);
        servicioRepository.save(servicio3);
        servicioRepository.save(servicio4);
        servicioRepository.save(servicio5);


        Digital digital1 = new Digital(1L, "https://static.fnac-static.com/multimedia/Images/ES/MC/78/2d/8c/9186680/1540-1/tsp20220317130801/Microsoft-Office-pro-plus-2021-programas-para-descargar.jpg#a1782c09-c671-44a4-bd93-5cf038b94c2f", "Microsoft Office pro plus 2021", 12, 65261655, area3, marca6, categoria3);
        Digital digital2 = new Digital(2L, "https://static.fnac-static.com/multimedia/Images/ES/MC/9f/4f/8c/9195423/1540-1/tsp20220324130548/Software-antivirus-para-descargar-Kaspersky-Total-Security-ultima-version-3-dispositivos-1-ano.jpg#d4523bc6-783d-45c5-8b67-b5025fb0cdb5", "Kaspersky Total Security", 24, 65261656, area3, marca7, categoria3);
        Digital digital3 = new Digital(3L, "https://static.fnac-static.com/multimedia/Images/ES/MC/b3/4f/8c/9195443/1540-1/tsp20220324130548/Software-antivirus-para-descargar-McAfee-LiveSafe-Unlimited-ultima-version-10-dispositivos-1-ano.jpg#88c3c202-3504-40af-8b33-2a53cb391f30", "McAfee LiveSafe", 24, 65261657, area3, marca8, categoria3);
        Digital digital4 = new Digital(4L, "https://static.fnac-static.com/multimedia/Images/ES/NR/35/14/59/5837877/1540-1.jpg", "Office 365 personal", 12, 65261658, area3, marca6, categoria3);
        Digital digital5 = new Digital(5L, "https://static.fnac-static.com/multimedia/Images/ES/NR/14/68/13/1271828/1540-1/tsp20160831114213/Kaspersky-Kis-2017-Internet-Security-Multi-Device.jpg", "Kaspersky Internet Security", 24, 65261659, area3, marca7, categoria3);


        digitalRepository.save(digital1);
        digitalRepository.save(digital2);
        digitalRepository.save(digital3);
        digitalRepository.save(digital4);
        digitalRepository.save(digital5);

    }
}
