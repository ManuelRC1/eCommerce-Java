package es.manu.proyectofinaldespring.entidades;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "compania")
public class Compania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "ano_fundacion", nullable = false)
    private Integer ano_fundacion;

    @Column(name = "calidad", length = 100)
    private String calidad;

    @Column(name = "imagen")
    private String imagen;


    @OneToMany(mappedBy = "compania", orphanRemoval = true)
    private List<Servicio> servicios = new ArrayList<>();

    public Compania(Long id, String nombre, Integer ano_fundacion, String calidad, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.ano_fundacion = ano_fundacion;
        this.calidad = calidad;
        this.imagen = imagen;
    }

    public Compania() {

    }


    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}