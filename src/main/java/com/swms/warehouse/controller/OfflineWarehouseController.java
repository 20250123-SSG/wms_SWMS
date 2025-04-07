package com.swms.warehouse.controller;

import com.swms.warehouse.model.dto.OfflineWarehouseDto;
import com.swms.warehouse.model.service.OfflineWarehouseService;

import java.util.List;

public class OfflineWarehouseController {
    private OfflineWarehouseService offlineWarehouseService = new OfflineWarehouseService();



    public List<OfflineWarehouseDto> selectAllStoreWarehouse(int page, int storeId){

        return offlineWarehouseService.selectAllStoreWarehouse(page, storeId);

    }

    public boolean existsWarehouseById(int warehouseId){

        OfflineWarehouseDto dto = offlineWarehouseService.selectWarehouseById(warehouseId);

        if (dto == null) {
            System.out.println("데이터가 없습니다.");
            return false;
        }else {
            return true;
        }
    }

}
