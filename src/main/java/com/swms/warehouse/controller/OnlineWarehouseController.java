package com.swms.warehouse.controller;

import com.swms.warehouse.model.dto.OfflineWarehouseDto;
import com.swms.warehouse.model.dto.OnlineWarehouseDto;
import com.swms.warehouse.model.service.OnlineWarehouseService;

import java.util.List;

public class OnlineWarehouseController {
    private OnlineWarehouseService onlineWarehouseService = new OnlineWarehouseService();

    public List<OnlineWarehouseDto> selectOnlineWarehouse(int page){
        return onlineWarehouseService.selectAllOnlineWarehouse(page);
    }

    public OnlineWarehouseDto existsWarehouseById(int warehouseId){
        return onlineWarehouseService.selectWarehouseById(warehouseId);
    }

    public int updateAddQuantity(OnlineWarehouseDto onlineWarehouseDto) {
        return onlineWarehouseService.updateAddQuantity(onlineWarehouseDto);
    }
}
