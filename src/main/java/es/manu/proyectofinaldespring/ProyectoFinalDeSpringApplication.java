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
    public void run(String... args) throws Exception
    {
//
//        Area area1 = new Area("zona1");
//        Area area2  = new Area("zona2");
//        Area area3 = new Area("zona3");
//
//        areaRepository.save(area1);
//        areaRepository.save(area2);
//        areaRepository.save(area3);
//
//        Categoria categoria1 = new Categoria("https://www.eluniverso.com/resizer/zTz3yKqRzQ6iwofrGIjh0zI24tg=/1200x669/smart/filters:quality(70)/cloudfront-us-east-1.images.arcpublishing.com/eluniverso/IJLSKMNQANH2NEGXXKWZXRT37Y.png", "libros");
//        Categoria categoria2 = new Categoria("https://blog.orange.es/wp-content/uploads/sites/4/2021/09/todointernet.jpg", "servicios");
//        Categoria categoria3 = new Categoria("https://es-commerce.com/imagenes/como-crear-una-tienda-online-de-productos-de-segunda-mano.jpg", "digital");
//
//        categoriaRepository.save(categoria1);
//        categoriaRepository.save(categoria2);
//        categoriaRepository.save(categoria3);
//
//        Compania compania = new Compania("iberia", 1923, "media", "https://www.aeropuertoinfo.com/wp-content/uploads/Logo-Iberia.png");
//
//        Compania compania1 = new Compania("Air Europa", 1923, "media-alta", "https://1000marcas.net/wp-content/uploads/2020/11/Air-Europa-logo.png");
//        Compania compania2 = new Compania("Turkish Airlines", 1975, "alta", "https://1000marcas.net/wp-content/uploads/2020/03/logo-Turkish-Airlines.png");
//        Compania compania3 = new Compania("Emirates", 2001, "muy alta", "https://logos-marcas.com/wp-content/uploads/2020/12/Emirates-Simbolo.png");
//
//
//        companiaRepository.save(compania);
//        companiaRepository.save(compania1);
//        companiaRepository.save(compania2);
//        companiaRepository.save(compania3);
//
//        Marca marca = new Marca("Hasbro", 1945, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Hasbro_4c_no_R.png/1024px-Hasbro_4c_no_R.png");
//        Marca marca1 = new Marca("Devir", 1934, "https://yt3.ggpht.com/ytc/AKedOLQNlslsaaTg6EpR5HNWBoDFw2BdoY91ZXsCI9312g=s900-c-k-c0x00FFF-no-rj");
//        Marca marca2 = new Marca("Edge", 1956, "http://www.edgeent.com/static/img/LOGO_EDGE_WHITE.jpg");
//        Marca marca3 = new Marca("Asmodee", 2013, "https://wargarage.org/wp-content/uploads/2018/05/asmodee-logo.jp");
//        Marca marca4 = new Marca("Destino", 1960, "https://www.planetadelibros.com/img/sellos_og/logo_DESTINO.jpg");
//        Marca marca5 = new Marca("Planeta", 1910, "https://pbs.twimg.com/profile_images/1274933503864590341/20Imga6R_400x400.png");
//        Marca marca6 = new Marca("Microsoft", 1989, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Microsoft_Office_logo_%282019%E2%80%93present%29.svg/640px-Microsoft_Office_logo_%282019%E2%80%93present%29.svg.png");
//        Marca marca7 = new Marca("Karpesky", 1921, "https://latam.kaspersky.com/content/es-mx/images/repository/pr/the-company-unveils-new-branding-and-visual-identity-1.jpg");
//        Marca marca8 = new Marca("McAfee", 1954, "https://i.blogs.es/a4eda0/mcafee/1366_2000.jpeg");
//
//        marcasRepository.save(marca);
//        marcasRepository.save(marca1);
//        marcasRepository.save(marca2);
//        marcasRepository.save(marca3);
//        marcasRepository.save(marca4);
//        marcasRepository.save(marca5);
//        marcasRepository.save(marca6);
//        marcasRepository.save(marca7);
//        marcasRepository.save(marca8);
//
//        Date date1 = new Date(2021-10-22);
//        Date date2 = new Date(2020-04-04);
//        Date date3 = new Date(2021-10-31);
//
//        Producto producto = new Producto("La Vall de la Llum", date1, "papel y carton", "https://imagessl4.casadellibro.com/a/l/t5/24/8432715140924.jpg", area1, categoria1, marca4);
//        Producto producto1 = new Producto("Violeta", date2, "papel", "https://imagessl4.casadellibro.com/a/l/t5/24/8432715140924.jpg", area1, categoria1, marca5);
//        Producto producto2 = new Producto("La bestia", date3, "papel y carton", "https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcSxvDTAnwQ5ODp5MZNN2piKUIdY20H1kgHiyd4OY5raiYabH3HbjYvwsAePMfOY9VSjFAxCr0dUjzAXbcrJiHqpTDyUPiGjP7FkzOm9h6xu-qMURz3YSqFE&usqp=CAY", area1, categoria1, marca4);
//
//        productoRepository.save(producto);
//        productoRepository.save(producto1);
//        productoRepository.save(producto2);
//
    }
}
