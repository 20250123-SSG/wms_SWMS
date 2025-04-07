package com.swms.warehouse.view;


import com.swms.warehouse.controller.OfflineWarehouseController;

import java.util.Scanner;

public class OfflineWarehouseView {

    private Scanner sc = new Scanner(System.in);
    private OfflineWarehouseController offlineWarehouseController = new OfflineWarehouseController();

    public void onlineWarehouse(int page){

        offlineWarehouseController.selectOfflineWarehouse(page);

    }
}
