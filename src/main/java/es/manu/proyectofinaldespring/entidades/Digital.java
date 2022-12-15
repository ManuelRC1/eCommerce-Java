package es.manu.proyectofinaldespring.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "precio", nullable = false)
    private Double precio;

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


    public Digital(Long id, String imagen, String nombre, Integer duracion, Integer claveactivacion, Double precio, Area area, Marca marca, Categoria categoria) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.duracion = duracion;
        this.claveactivacion = claveactivacion;
        this.precio = precio;
        this.area = area;
        this.marca = marca;
        this.categoria = categoria;

    }



}