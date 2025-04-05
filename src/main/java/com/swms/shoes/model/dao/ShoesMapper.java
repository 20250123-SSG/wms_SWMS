package com.swms.shoes.model.dao;

import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;

import java.util.List;
import java.util.Map;

public interface ShoesMapper {
    //String searchBrandName(int brandId);
    //String searchTypeName(int typeId);
    List<ShoesDto> selectShoesList(Map<String, Object> map);

    ShoesDetailDto selectShoesDetail(String shoesName);

    int getDisplayShoesCount(Map<String, Object> map);
}
