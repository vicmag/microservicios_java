// src/main/java/com/retail/inventory/domain/model/Inventory.java
package com.retail.inventory.domain.model;

public class Inventory {
    private final String productName;
    private final int currentStock;
    private final int minStockLevel;

    public Inventory(String productName, int currentStock, int minStockLevel) {
        if (minStockLevel <= 0) {
            throw new IllegalArgumentException("El nivel mínimo debe ser mayor a cero");
        }
        this.productName = productName;
        this.currentStock = currentStock;
        this.minStockLevel = minStockLevel;
    }

    public boolean isBelowMinStock() {
        return currentStock <= minStockLevel;
    }

    // Getters manteniendo inmutabilidad
    public String getProductName() { return productName; }
    public int getCurrentStock() { return currentStock; }
    public int getMinStockLevel() { return minStockLevel; }
}