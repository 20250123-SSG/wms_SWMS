package com.swms.warehouse.model.dao;

public interface OnlineWarehouseMapper {
    int checkWarehouseStock(int shoesId);
    int updateShoesQuantity(int shoesId);
}