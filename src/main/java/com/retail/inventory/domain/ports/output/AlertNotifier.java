package com.retail.inventory.domain.ports.output;

import com.retail.inventory.domain.model.StockAlert;

public interface AlertNotifier {
    void notify(StockAlert alert);
}
