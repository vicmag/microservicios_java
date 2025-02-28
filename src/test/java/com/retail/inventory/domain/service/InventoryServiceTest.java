package com.retail.inventory.domain.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import com.retail.inventory.domain.model.Product;
import com.retail.inventory.domain.ports.output.AlertRepository;
import com.retail.inventory.domain.ports.output.AlertNotifier;

class InventoryServiceTest {

    @Test
    void stockAlert_ShouldContainCorrectData() {
        // Arrange
        AlertNotifier notifier = mock(AlertNotifier.class);
        AlertRepository repository = mock(AlertRepository.class);
        InventoryService service = new InventoryService(notifier, repository);

        Product product = new Product("P1", "Camiseta Azul", 10);
        product.updateStock(5); // Stock por debajo del mínimo

        // Act
        service.checkStockLevel(product);

        // Assert
        verify(repository).save(argThat(alert ->
                alert.getProductId().equals("P1") &&
                        alert.getCurrentStock() == 5 &&
                        alert.getMinStockLevel() == 10
        ));
    }
}
                