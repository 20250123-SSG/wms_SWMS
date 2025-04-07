package com.swms.warehouse.model.dao;

import com.swms.warehouse.model.dto.PurchaseOrderDto;

public interface PurchaseOrderMapper {
    int createPurchaseOrder(PurchaseOrderDto purchaseOrderDto);
}