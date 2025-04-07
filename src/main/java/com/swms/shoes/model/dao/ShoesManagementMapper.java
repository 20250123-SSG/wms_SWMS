package com.swms.shoes.model.dao;

import com.swms.shoes.model.dto.ShoesDto;

public interface ShoesManagementMapper {
    int insertShoes(ShoesDto menu);
    int updateShoes(ShoesDto menu);
    int deleteShoes(int id);

}
