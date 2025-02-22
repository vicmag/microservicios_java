// src/main/java/com/retail/inventory/application/ports/output/AlertNotifierPort.java
package com.retail.inventory.application.ports.output;

import com.retail.inventory.domain.model.Inventory;

public interface AlertNotifierPort {
    void notifyLowStock(Inventory inventory);
}