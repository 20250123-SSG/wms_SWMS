package com.swms.warehouse.model.dao;

import com.swms.warehouse.model.dto.PurchaseOrderDto;
import org.apache.ibatis.annotations.Param;

public interface PurchaseOrderMapper {
    int createPurchaseOrder(PurchaseOrderDto purchaseOrderDto);
}