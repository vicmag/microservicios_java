// src/main/java/com/retail/inventory/domain/service/InventoryAlertService.java
package com.retail.inventory.domain.service;

import com.retail.inventory.application.ports.output.AlertNotifierPort;
import com.retail.inventory.domain.model.Inventory;

public class InventoryAlertService {

    private final AlertNotifierPort alertNotifier;

    public InventoryAlertService(AlertNotifierPort alertNotifier) {
        this.alertNotifier = alertNotifier;
    }

    public void checkStockLevel(Inventory inventory) {
        if (inventory.isBelowMinStock()) {
            alertNotifier.notifyLowStock(inventory);
        }
    }
}