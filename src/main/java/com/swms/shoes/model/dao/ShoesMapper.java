package com.swms.shoes.model.dao;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesOptionDto;

import java.util.List;

public interface ShoesMapper {

    //신발 조회용 (10개씩)
    List<ShoesDto> selectMainShoes(ShoesDto option);

    // 조회정렬
    List<ShoesDto> sortingByLatest(ShoesOptionDto selectOption);
    List<ShoesDto> sortingByPriceASC(ShoesOptionDto selectOption);
    List<ShoesDto> sortingByPriceDESC(ShoesOptionDto selectOption);

    String searchBrandName(int brandId);
    String searchTypeName(int typeId);
}
