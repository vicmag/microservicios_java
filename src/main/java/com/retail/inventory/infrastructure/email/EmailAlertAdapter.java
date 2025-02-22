// src/main/java/com/retail/inventory/infrastructure/email/EmailAlertAdapter.java
package com.retail.inventory.infrastructure.email;

import com.retail.inventory.application.ports.output.AlertNotifierPort;
import com.retail.inventory.domain.model.Inventory;
import org.springframework.stereotype.Component;

@Component
public class EmailAlertAdapter implements AlertNotifierPort {

    @Override
    public void notifyLowStock(Inventory inventory) {
        String message = String.format(
                "Alerta de stock bajo: %s - Stock actual: %d - Mínimo requerido: %d",
                inventory.getProductName(),
                inventory.getCurrentStock(),
                inventory.getMinStockLevel()
        );

        // Lógica real de envío de email
        System.out.println("Enviando alerta por email: " + message);
    }
}