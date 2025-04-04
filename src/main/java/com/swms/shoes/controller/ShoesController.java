package com.swms.shoes.controller;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.service.ShoesService;
import com.swms.shoes.view.ShoesResultView;
import java.util.List;
import java.util.Map;

public class ShoesController {
    private ShoesService shoesService = new ShoesService();

    // TODO : 시간되면 브랜드, 타입 목록 조회
    // 브랜드 목록 조회
    public void /*List<String>*/ selectBrandList(){}
    // 타입 목록 조회
    public void /*List<String>*/ selectTypeList(){}

    // 사용자가 입력한 브랜드의 이름 조회
    public String searchBrandName(int brandId) {
        String brandName = shoesService.searchBrandName(brandId);
        return brandName;
    }
    // 사용자가 입력한 종류의 이름 조회
    public String searchTypeName(int typeId) {
        String typeName = shoesService.searchTypeName(typeId); // 서비스 반환 데이터
        return typeName;
    }

    public void selectShoesList(Map<String, Object> map) {
        List<ShoesDto> list = shoesService.selectShoesList(map);
        ShoesResultView.displayShoesList(list);
    }

    public void selectShoesDetail(String s) {
    }


}















