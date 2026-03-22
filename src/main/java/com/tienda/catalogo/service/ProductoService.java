package com.tienda.catalogo.service;

import com.tienda.catalogo.model.Producto;
import com.tienda.catalogo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    // 1. Declaramos el repositorio
    private final ProductoRepository productoRepository;

    // 2. Spring inyecta el repositorio a través del constructor
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // 3. Modificamos el método para buscarlos a todos (find all)
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    // Recibe el producto nuevo y lo guarda
    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }


}
