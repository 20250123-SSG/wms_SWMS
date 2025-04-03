package com.swms.shoes.model.dao;

import com.swms.shoes.model.dto.ShoesDto;

import java.util.List;

public interface ShoesMapper {

    //신발 조회용 (10개씩)
    List<ShoesDto> selectMainShoes(ShoesDto option);

}
