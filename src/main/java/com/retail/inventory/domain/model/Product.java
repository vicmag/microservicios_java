// Capa de Dominio - Módulo de Inventario
package com.retail.inventory.domain.model;

import lombok.Data;

// Entidad de Dominio - Producto
@Data
public class Product {
    private final String id;
    private final String name;
    private int stock;
    private final int minStock;

    public Product(String id, String name, int minStock) {
        if (minStock <= 0) throw new IllegalArgumentException("Stock mínimo debe ser positivo");
        this.id = id;
        this.name = name;
        this.minStock = minStock;
    }

    public boolean isStockBelowMinimum() {
        return stock <= minStock;
    }

    public void updateStock(int newStock) {
        if (newStock < 0) throw new IllegalArgumentException("Stock no puede ser negativo");
        this.stock = newStock;
    }

    // Getters omitidos por brevedad
}



