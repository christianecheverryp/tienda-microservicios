package com.tienda.catalogo.controller;

import com.tienda.catalogo.model.Producto;
import com.tienda.catalogo.repository.ProductoRepository;
import com.tienda.catalogo.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoService productoService, ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @GetMapping("/api/productos")
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    @PostMapping("/api/productos")
    public Producto crearProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

}