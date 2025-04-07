package com.swms.warehouse.controller;

import com.swms.warehouse.model.service.OnlineWarehouseService;

public class OnlineWarehouseController {
    private OnlineWarehouseService onlineWarehouseService;

    public void selectOnlineWarehouse(int page){

        onlineWarehouseService.selectAllOnlineWarehouse(page);

    }
}
