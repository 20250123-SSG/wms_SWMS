package com.swms.user.model.dao;

import com.swms.shoes.model.dto.ShoesDto;

public interface AdminMapper {
    int insertShoes(ShoesDto menu);
    int updateShoes(ShoesDto menu);
    int deleteShoes(int id);

}
