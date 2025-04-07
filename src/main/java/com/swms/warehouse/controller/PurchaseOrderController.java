package com.swms.warehouse.controller;

import com.swms.warehouse.model.dto.OfflineWarehouseDto;
import com.swms.warehouse.model.dto.PurchaseOrderDto;
import com.swms.warehouse.model.service.PurchaseOrderService;

import java.util.List;

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

    public List<PurchaseOrderDto> selectAllPurchaseOrder(int page) {

        return purchaseOrderService.selectAllPurchaseOrder(page);

    }

    public PurchaseOrderDto selectWarehouseById(int purchaseOrderId) {

        return purchaseOrderService.selectWarehouseById(purchaseOrderId);
    }

    public int approvePurchaseOrder(PurchaseOrderDto purchaseOrderDto) {

        OfflineWarehouseDto offlineWarehouseDto = OfflineWarehouseDto.builder()
                .storeId(purchaseOrderDto.getStoreId())
                .shoesId(purchaseOrderDto.getShoesId())
                .quantity(purchaseOrderDto.getQuantity()) // 주입한 수량만큼 기존 데이터에 더함
                .build();

        // 상태 완료 처리
        purchaseOrderDto.setStatus("발주완료");

        return purchaseOrderService.approvePurchaseOrder(purchaseOrderDto, offlineWarehouseDto);
    }

    public int rejectPurchaseOrder(PurchaseOrderDto purchaseOrderDto) {
        // 상태 완료 처리
        purchaseOrderDto.setStatus("발주취소");

        return purchaseOrderService.updatePurchaseOrder(purchaseOrderDto);
    }
}

