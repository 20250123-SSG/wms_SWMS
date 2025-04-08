package com.swms.shoes.controller;

import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesSelectDto;
import com.swms.shoes.model.dto.ShoesSelectOptionDto;
import com.swms.shoes.model.service.ShoesService;
import com.swms.shoes.view.ShoesResultView;
import com.swms.user.model.dto.CartDto;
import com.swms.user.model.dto.UserDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoesController {
    private int totalShoes = 0;

    public static final int OFFSET = 10;
    public static final int UP = +OFFSET;
    public static final int DOWN = -OFFSET;

    private ShoesService shoesService = new ShoesService();



    // TODO : 시간되면 브랜드, 타입 목록 조회
    // 브랜드 목록 조회
    public void /*List<String>*/ selectBrandList(){}
    // 타입 목록 조회
    public void /*List<String>*/ selectTypeList(){}


    public List<ShoesSelectDto> selectShoesList(ShoesSelectOptionDto shoesSelectOptionDto, int page) {
        List<ShoesSelectDto> list = shoesService.selectShoesList(shoesSelectOptionDto, page);
        ShoesResultView.displayShoesList(list);
        return list;
    }

    public ShoesDto selectShoesDetail(String shoesName) {
        ShoesDto shoes = shoesService.selectShoesDetail(shoesName);
        List<String> sizeList = shoesService.selectShoesSizeList(shoesName);
        ShoesResultView.displayShoes(shoes);
        ShoesResultView.displayShoesSizeList(sizeList);
        return shoes;
    }


    // 구매할 상품 하나에 대한 정보를 가져온다. (Shoes_id)
    public ShoesDto getShoes(ShoesDto shoes, String size,String quantity) {
        int shoesId = shoesService.getShoesId(shoes);
        shoes.setShoesId(shoesId);
        shoes.setSize(size);
        shoes.setQuantity(Integer.parseInt(quantity));

        return shoes;
    }

    public void insertToCart(UserDto user, ShoesDto shoes) {
        CartDto cart = new CartDto();

        cart.setUserId(user.getUserId());
        cart.setShoesId(shoes.getShoesId());
        System.out.println(cart);

        int result = shoesService.insertToCart(cart);
    }

    // 상품명 검색
    public void searchByShoesName(String shoesName) {
        List<ShoesDto> searchList = shoesService.searchByShoesName(shoesName);
        // 검색결과(List) 출력하는 뷰
        // ShoesResultView.display~~(searchList);
    }
}















