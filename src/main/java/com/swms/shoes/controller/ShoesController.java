package com.swms.shoes.controller;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.service.ShoesService;
import com.swms.shoes.view.ShoesResultView;

import java.util.List;


// 입력 및 출력 view와 연결되는 곳
public class ShoesController {

    private ShoesService shoesService = new ShoesService();


    // 브랜드, 타입선택 후 맨 처음 조회되는 default 서비스
    public void selectMainShoes(String type, String brand) {
        ShoesDto option =  new ShoesDto(Integer.parseInt(brand) - 1, Integer.parseInt(type) - 1);

        System.out.println(option);

        List<ShoesDto> list = shoesService.selectMainShoes(option); // 서비스 반환 데이터
        ShoesResultView.displayShoesList(list); // out : 10개씩 조회신발 출력
    }
}
