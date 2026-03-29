package com.tienda.catalogo.consumer;


import com.tienda.catalogo.model.Producto;
import com.tienda.catalogo.repository.ProductoRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class PedidoConsumer {

    private final ProductoRepository productoRepository;
    private final tools.jackson.databind.ObjectMapper objectMapper; // Herramienta para leer JSON

    public PedidoConsumer(ProductoRepository productoRepository, ObjectMapper objectMapper) {
        this.productoRepository = productoRepository;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "pedidos-topic", groupId = "catalogo-grupo")
    public void escucharPedido(String mensajeJson) {
        try {
            System.out.println("Evento recibido: " + mensajeJson);

            // 1. Traducir el JSON a variables
            tools.jackson.databind.JsonNode datos = objectMapper.readTree(mensajeJson);
            Long productoId = datos.get("productoId").asLong();
            Integer cantidadComprada = datos.get("cantidad").asInt();

            // 2. Buscar el producto en la base de datos H2
            Producto producto = productoRepository.findById(productoId).orElse(null);

            if (producto != null) {
                // 3. Restar el stock y guardar
                producto.setStock(producto.getStock() - cantidadComprada);
                productoRepository.save(producto);
                System.out.println("Stock actualizado. Nuevo stock de " + producto.getNombre() + ": " + producto.getStock());
            } else {
                System.out.println("Error: Producto no encontrado en el catálogo.");
            }

        } catch (Exception e) {
            System.out.println("Error procesando el mensaje: " + e.getMessage());
        }
    }
}