package com.swms.warehouse.controller;

import com.swms.warehouse.model.dto.OfflineWarehouseDto;
import com.swms.warehouse.model.service.OfflineWarehouseService;

import java.util.List;

public class OfflineWarehouseController {
    private OfflineWarehouseService offlineWarehouseService = new OfflineWarehouseService();



    public List<OfflineWarehouseDto> selectAllStoreWarehouse(int page, int storeId){

        return offlineWarehouseService.selectAllStoreWarehouse(page, storeId);

    }

    public OfflineWarehouseDto existsWarehouseById(int warehouseId){

        return offlineWarehouseService.selectWarehouseById(warehouseId);
    }

}
