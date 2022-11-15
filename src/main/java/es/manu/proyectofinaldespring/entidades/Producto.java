package es.manu.proyectofinaldespring.entidades;



import javax.persistence.*;
import java.sql.Date;
import java.util.List;



@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "fechalanzamiento")
    private Date fechalanzamiento;

    @Column(name = "material", length = 100)
    private String material;

    @Column(name = "imagen", length = 255)
    private String imagen;



    @ManyToOne
    @JoinColumn(name = "area")
    private Area area;


    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;


    @ManyToOne
    @JoinColumn(name = "marca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;


    public Producto(){}


    public Producto(Long id, String titulo, Date fechalanzamiento, String material, String imagen, Area area, Categoria categoria, Marca marca) {
        this.id = id;
        this.titulo = titulo;
        this.fechalanzamiento = fechalanzamiento;
        this.material = material;
        this.imagen = imagen;
        this.area = area;
        this.categoria = categoria;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechalanzamiento() {
        return fechalanzamiento;
    }

    public void setFechalanzamiento(Date fecha_lanzamiento) {
        this.fechalanzamiento = fecha_lanzamiento;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}