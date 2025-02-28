package com.retail.inventory.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StockAlert {
    private final String productId;
    private final String productName;
    private final int currentStock;
    private final int minStockLevel;
    private final LocalDateTime timestamp;

    public StockAlert(String productId,
                      String productName,
                      int currentStock,
                      int minStockLevel) {
        this.productId = productId;
        this.productName = productName;
        this.currentStock = currentStock;
        this.minStockLevel = minStockLevel;
        this.timestamp = LocalDateTime.now();
    }

}