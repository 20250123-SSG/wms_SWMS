package com.swms.warehouse.controller;

import com.swms.warehouse.model.dto.PurchaseOrderDto;
import com.swms.warehouse.model.service.PurchaseOrderService;

public class PurchaseOrderController {
    private PurchaseOrderService purchaseOrderService = new PurchaseOrderService();


    public int createPurchaseOrder(int storeId, int shoesId, int quantity) {

        PurchaseOrderDto purchaseOrderDto = PurchaseOrderDto.builder()
                .storeId(storeId)
                .shoesId(shoesId)
                .quantity(quantity)
                .build();

        return purchaseOrderService.createPurchaseOrder(purchaseOrderDto);


    }

}

