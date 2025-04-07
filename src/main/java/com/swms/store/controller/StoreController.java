package com.swms.store.controller;

import com.swms.store.model.dto.StoreDto;
import com.swms.store.model.service.StoreService;
import com.swms.user.model.dto.AccountDto;

public class StoreController {

    private StoreService storeService = new StoreService();

    public StoreDto getStoreByUserId(int userId) {

        return storeService.getStoreByUserId(userId);
    }
}
