package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cataegoria")
    private Integer idCategoria;

    private String descripcion;

    private Boolean estado;

    /*
     * Relacion Categoria con producto
     * One to Many con mapped by
     * mapper by mapea por la columna categoria (El nombre del atributo categoria en la clase Producto. )
     * El atributo se crea del tipo Lista<Producto> productos Lista de tipo Producto El entitique se relaciona
     * y se nombra en plurar, por ser lista de productos
     *
     *
     * */

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
