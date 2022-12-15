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

    @Column(name = "precio", nullable = false)
    private Double precio;

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


    public Producto(Long id, String titulo, Date fechalanzamiento, String material, String imagen, Double precio, Area area, Categoria categoria, Marca marca) {
        this.id = id;
        this.titulo = titulo;
        this.fechalanzamiento = fechalanzamiento;
        this.material = material;
        this.imagen = imagen;
        this.precio = precio;
        this.area = area;
        this.categoria = categoria;
        this.marca = marca;
    }
}