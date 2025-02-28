package com.retail.inventory.domain.service;

import com.retail.inventory.domain.model.Product;
import com.retail.inventory.domain.model.StockAlert;
import com.retail.inventory.domain.ports.output.AlertNotifier;
import com.retail.inventory.domain.ports.output.AlertRepository;

public class InventoryService {
    private final AlertNotifier notifier;
    private final AlertRepository repository;

    public InventoryService(AlertNotifier notifier, AlertRepository repository) {
        this.notifier = notifier;
        this.repository = repository;
    }

    public void checkStockLevel(Product product) {
        if (product.isStockBelowMinimum()) {
            StockAlert alert = new StockAlert(
                    product.getId(),
                    product.getName(),
                    product.getStock(),
                    product.getMinStock()
            );
            repository.save(alert);
            notifier.notify(alert);
        }
    }
}