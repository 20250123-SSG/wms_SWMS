package com.swms.shoes.model.dao;

import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesSelectDto;
import com.swms.shoes.model.dto.ShoesSelectOptionDto;
import com.swms.user.model.dto.CartDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShoesMapper {
    //String searchBrandName(int brandId);
    //String searchTypeName(int typeId);
    List<ShoesSelectDto> selectShoesList(
            ShoesSelectOptionDto shoesSelectOptionDto);

    ShoesDto selectShoesDetail(String shoesName);

    int getDisplayShoesCount(Map<String, Object> map);

    List<String> selectShoesSizeList(String shoesName);

    // 신발 사이즈, 신발 이름으로 찾음
    ShoesDto getShoesId(ShoesDto shoes);

    int insertToCart(CartDto cart);

    List<ShoesDto> searchByShoesName(String shoesName);
}
