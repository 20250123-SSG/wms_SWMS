package com.swms.warehouse.view;

import com.swms.warehouse.controller.OnlineWarehouseController;

import java.util.Scanner;

public class OnlineWarehouseView {
    private Scanner sc = new Scanner(System.in);
    private OnlineWarehouseController onlineWarehouseController = new OnlineWarehouseController();

    public void onlineWarehouse(int page){

        onlineWarehouseController.selectOnlineWarehouse(page);

    }

}
