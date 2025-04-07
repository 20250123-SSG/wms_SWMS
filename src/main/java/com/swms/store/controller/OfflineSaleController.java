package com.swms.store.controller;

import com.swms.store.model.dto.OfflineSaleDto;
import com.swms.store.model.dto.StoreDto;
import com.swms.store.model.service.OfflineSaleService;
import com.swms.store.model.service.StoreService;
import com.swms.warehouse.model.dto.OfflineWarehouseDto;
import com.swms.warehouse.model.dto.PurchaseOrderDto;

public class OfflineSaleController {

    private OfflineSaleService offlineSaleService = new OfflineSaleService();

    public int processSale(OfflineWarehouseDto offlineWarehouseDto, int saleQuantity) {

        int warehouseQuantity = offlineWarehouseDto.getQuantity() - saleQuantity;

        // 창고 DTO 수량 업데이트
        offlineWarehouseDto.setQuantity(
                warehouseQuantity);

        // 판매 DTO
        OfflineSaleDto offlineSaleDto = OfflineSaleDto.builder()
                .storeId(offlineWarehouseDto.getStoreId())
                .shoesId(offlineWarehouseDto.getShoesId())
                .quantity(saleQuantity)
                .build();



        return offlineSaleService.processSale(offlineWarehouseDto, offlineSaleDto);

    }
}
