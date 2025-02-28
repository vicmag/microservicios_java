package com.retail.inventory.domain.ports.output;

import com.retail.inventory.domain.model.StockAlert;

public interface AlertRepository {
    void save(StockAlert alert);
}