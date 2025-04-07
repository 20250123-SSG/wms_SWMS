package com.swms.store.model.dao;


import com.swms.store.model.dto.OfflineSaleDto;

public interface OfflineSaleMapper {
    int createOfflineSale(OfflineSaleDto offlineSaleDto);
}