package com.tienda.catalogo.controller;

import com.tienda.catalogo.model.Producto;
import com.tienda.catalogo.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping("/api/productos")
    public List<Producto> obtenerProductos() {
        return productoService.obtenerTodosLosProductos();
    }
}