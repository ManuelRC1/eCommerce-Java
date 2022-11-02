package es.manu.proyectofinaldespring.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;


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