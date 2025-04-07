package com.swms.shoes.model.dao;

import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesSelectDto;
import com.swms.user.model.dto.CartDto;

import java.util.List;
import java.util.Map;

public interface ShoesMapper {
    //String searchBrandName(int brandId);
    //String searchTypeName(int typeId);
    List<ShoesSelectDto> selectShoesList(Map<String, Object> map);

    ShoesDto selectShoesDetail(String shoesName);

    int getDisplayShoesCount(Map<String, Object> map);

    List<String> selectShoesSizeList(String shoesName);

    int getShoesId(ShoesDto shoes);

    int insertToCart(CartDto cart);
}
