package com.swms.shoes.controller;

import com.swms.shoes.model.dto.ShoesDetailDto;
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

    //TODO: 페이지네이션 offset범위 제한
    public List<ShoesDto> selectShoesList(Map<String, Object> map) {
        List<ShoesDto> list = shoesService.selectShoesList(map);
        ShoesResultView.displayShoesList(list);
        return list;
    }

    public ShoesDetailDto selectShoesDetail(String shoesName) {
        ShoesDetailDto shoes = shoesService.selectShoesDetail(shoesName);
        ShoesResultView.displayShoes(shoes);
        return shoes;
    }


}















