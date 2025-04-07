package com.swms.warehouse.model.dao;

import com.swms.warehouse.model.dto.PurchaseOrderDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseOrderMapper {
    int createPurchaseOrder(PurchaseOrderDto purchaseOrderDto);

    List<PurchaseOrderDto> selectAllPurchaseOrder(
            @Param("limit") int limit,
            @Param("offset") int offset);
}