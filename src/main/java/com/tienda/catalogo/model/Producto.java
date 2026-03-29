package com.tienda.catalogo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // JPA: Crea una BBDD para esta clase
public class Producto {

    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;

    @Id // JPA: Este es el identificador único (Primary Key) de cada producto
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3. Hace que el ID se genere automáticamente (1, 2, 3...)
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
