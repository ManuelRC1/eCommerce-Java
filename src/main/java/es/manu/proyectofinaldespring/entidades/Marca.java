package es.manu.proyectofinaldespring.entidades;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre",length = 40,  nullable = false)
    private String nombre;

    @Column(name = "ano_fundacion", nullable = false)
    private Integer ano_fundacion;


    @Column(name = "imagen", nullable = false)
    private String imagen;

    @OneToMany(mappedBy = "marca", orphanRemoval = true)
    private List<Digital> digitales = new ArrayList<>();

    @OneToMany(mappedBy = "marca", orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    public Marca(){}



    public Marca(String nombre, Integer ano_fundacion, String imagen) {
        this.nombre = nombre;
        this.ano_fundacion = ano_fundacion;
        this.imagen = imagen;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAno_fundacion() {
        return ano_fundacion;
    }

    public void setAno_fundacion(Integer ano_fundacion) {
        this.ano_fundacion = ano_fundacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Digital> getDigitales() {
        return digitales;
    }

    public void setDigitales(List<Digital> digitales) {
        this.digitales = digitales;
    }

}