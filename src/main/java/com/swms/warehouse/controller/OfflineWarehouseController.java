package com.swms.warehouse.controller;

import com.swms.warehouse.model.service.OfflineWarehouseService;
import com.swms.warehouse.model.service.OnlineWarehouseService;

public class OfflineWarehouseController {
    private OfflineWarehouseService offlineWarehouseService;


    public void selectOfflineWarehouse(int page){

        offlineWarehouseService.selectAllOnlineWarehouse(page);

    }

}
