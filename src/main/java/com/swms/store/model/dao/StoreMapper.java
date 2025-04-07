package com.swms.store.model.dao;

import com.swms.store.model.dto.StoreDto;

public interface StoreMapper {
    StoreDto findByUserId(int userId);
}