package com.tienda.catalogo.service;

import com.tienda.catalogo.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    public List<Producto> obtenerTodosLosProductos(){
        List<Producto> lista = new ArrayList<>();

        Producto p1 = new Producto();
        p1.setId(1L);
        p1.setNombre("Laptop");
        p1.setPrecio(1200.50);

        Producto p2 = new Producto();
        p2.setId(2L);
        p2.setNombre("Mouse");
        p2.setPrecio(25.00);

        lista.add(p1);
        lista.add(p2);

        return lista;
    }

}
