# Proyecto de Spring

Mi proyecto ha sido con el framework de Spring boot ya que he visto una mayor comodidad
a la hora de hacer el trabajo junto con Thymeleaf, y explicare como han sido
los procesos que he seguido de forma general para demostrar los conocimientos 
sobre la materia y el buen uso del patron MVC

###Dependencias usadas en el proyecto
    -JPA
    -Hibernate
    -Thymeleaf
    -mysql
    -Servicios REST

###Conexion a la base de datos

Lo primero, y esencial del proyecto ha sido la conexion a la base de datos, he usado
mysql y lo he desplegado en un contenedor Docker mediante un fichero.yml.

```yml
version: '3.9'

services:
  mysql-FNACuel:
    image: mysql
    container_name: mysql-FNACuel
    environment:
      MYSQL_ROOT_PASSWORD: quevedo
      MYSQL_DATABASE: FNACuel
    ports:
      - "3306:3306"
```
en el yml, como bien indica, se ve que cuando se levanta en el usuario root
se crea una base de datos llamada como la empresa *FNACuel* 

###Conexion a Intellij

Ahora ya que tenemos el contenedor lanzado, deberiamos de conectarlo al programa.
En el boton que hay en la barra lateral derecha que pone *database* deberiamos de abrirlo, 
elegir el data source de *MySql* 
Lo que tendriamos que cambiar unicamente de esa pantalla seria:
    
    -Username: root
    -password: quevedo
    -Database: FNACuel

###Creacion de las entidades

Gracias a JPA no es necesario insertar los nombres de cada tabla ni los atributos,
se ha simplificado mucho. Con el JPA palette asigné cada una de los atributos que queria
que estuviese en mi tabla, ademas de las relaciones que queria que tuviese cada tabla 
y con las caracteristicas que yo necesitaba para cada uno de ellos.

El total de entidades usadas han sido 8, la mayoria de relaciones que he creado han sido many to one, aunque tambien hay One to One.

Para las entidades es imprescindible que tenga *@Entity*, y el nombre de como quieres que
se llame la tabla, en este caso era digital con la anotacion *@Table*.

Ejemplo: 
```
@Entity
@Table(name = "digital")
public class Digital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "imagen", nullable = false, length = 255)
    private String imagen;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;


    @Column(name = "claveactivacion")
    private Integer claveactivacion;


    @ManyToOne
    @JoinColumn(name = "area")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "marca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;





    public Digital(){}

    public Digital(String imagen, String nombre, Integer duracion, Integer claveactivacion, Area area, Marca marca, Categoria categoria) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.duracion = duracion;
        this.claveactivacion = claveactivacion;
        this.area = area;
        this.marca = marca;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getClaveactivacion() {
        return claveactivacion;
    }

    public void setClaveactivacion(Integer claveActivacion) {
        this.claveactivacion = claveActivacion;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
```
Tambien es necesario crear los constructores para luego usar los atributos y los getters y setters.
(no use lombok porque me daban problemas y no consegui arreglarlo)

###Repositorios 

Se asignan mediante la anotacion *Repository*.
He usado, a parte de las que tenia la propia extension (JPARepository)
unas consultas que dependiendo en la entidad a la que se refiera, 
buscara por un input un valor asignado en la base de datos

ejemplo:

```
  List<Producto> findByTituloContainsOrMaterialContains(String titulo, String material);
  ```

###Interfaces

Aqui unicamente pondre el nombre del servicio, la naturaleza del mismo
y los parametros que pasaran por aqui

##Servicio

En este punto usare las clases de JPARepository.
Lo llamare con el *@Autowired* al Repositorio que quiera usar, y junto
a ello pondre los metodos CRUD junto con las consultas creadas.
Es necesario poner la etiqueta *@Service* para el repositorio

ejemplo:
```
@Service
public class DigitalService implements IDigitalService {

    @Autowired
    private DigitalRepository digitalRepository;

    @Override
    public List<Digital> listar() {
        return digitalRepository.findAll();
    }

    @Override
    public Digital findById(Long id) {
        return digitalRepository.findById(id).orElse(null);
    }

    @Override
    public Digital save(Digital digital) {
        return digitalRepository.save(digital);
    }

    @Override
    public Digital delete(Digital digital) {
        Digital resultado = findById(digital.getId());
        digitalRepository.delete(resultado);
        return resultado;
    }

    @Override
    public List<Digital> buscador(String cadena) {
        return digitalRepository.findByNombreContains(cadena);
    }
}
```

###Controlador

Para el controlador usaremos los metodos creados en el service con el 
*@Autowired*, usaremos cada uno de ellos siendo esencial para implementarlo
en la vista una creacion de un producto, si quieres buscar un producto que contenga
la "a" o querer eliminar un servicio

Igualmente, tendremos que etiquetarlo cada clase que haga de controlador llamado
*@Controller*

###Vista

La vista es necesario usar en la etiqueta de html esta siguiente etiqueta
```
xmlns:th="http://www.thymeleaf.org"
```

es esencial para que lo que llamamos del controller, añadido a su vez al model, salga
a la pantalla 



    
