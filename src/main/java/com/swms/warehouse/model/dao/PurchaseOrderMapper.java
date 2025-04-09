package com.swms.warehouse.model.dao;

import com.swms.warehouse.model.dto.PurchaseOrderDto;

import java.util.List;

public interface PurchaseOrderMapper {
    int createPurchaseOrder(PurchaseOrderDto purchaseOrderDto);

    List<PurchaseOrderDto> selectAllPurchaseOrder(
            @Param("limit") int limit,
            @Param("offset") int offset);

    PurchaseOrderDto selectPurchaseOrderById(
            @Param("purchaseOrderId") int purchaseOrderId
    );

    int updateStatusAndCompletionDate(PurchaseOrderDto purchaseOrderDto);

    int deletePurchaseOrderById(PurchaseOrderDto purchaseOrderDto);


}