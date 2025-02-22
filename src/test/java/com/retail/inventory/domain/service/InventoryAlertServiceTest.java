// src/test/java/com/retail/inventory/domain/service/InventoryAlertServiceTest.java
package com.retail.inventory.domain.service;

import com.retail.inventory.domain.model.Inventory;
import com.retail.inventory.application.ports.output.AlertNotifierPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class InventoryAlertServiceTest {

    @Mock
    private AlertNotifierPort alertNotifier;

    @InjectMocks
    private InventoryAlertService inventoryAlertService;

    @Test
    void whenStockBelowMinimum_shouldTriggerAlert() {
        // Arrange
        Inventory inventory = new Inventory("Camiseta Azul", 5, 10);

        // Act
        inventoryAlertService.checkStockLevel(inventory);

        // Assert
        verify(alertNotifier).notifyLowStock(inventory);
    }
}