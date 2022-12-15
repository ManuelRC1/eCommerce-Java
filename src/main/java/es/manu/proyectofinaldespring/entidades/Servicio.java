package es.manu.proyectofinaldespring.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "imagen", nullable = false, length = 255)
    private String imagen;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "horario", nullable = false)
    private Integer horario;

    @Column(name = "duracion")
    private Integer duracion;

    @Column(name = "localizacion", nullable = false, length = 200)
    private String localizacion;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "area")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "compania")
    private Compania compania;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;


    public Servicio(Long id, String nombre, String imagen, Date fecha, Integer horario, Integer duracion, String localizacion, Double precio, Area area, Compania compania, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.localizacion = localizacion;
        this.precio = precio;
        this.area = area;
        this.compania = compania;
        this.categoria = categoria;
    }

}