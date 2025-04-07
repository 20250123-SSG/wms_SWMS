package com.swms.shoes.controller;

import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesSelectDto;
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


    public List<ShoesSelectDto> selectShoesList(Map<String, Object> map) {
        List<ShoesSelectDto> list = shoesService.selectShoesList(map);
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

    // 다음페이지
    public List<ShoesSelectDto> pageUp(Map<String, Object> map) {

        // 페이지네이션 데이터처리
        if (totalShoes == 0) {
            totalShoes = shoesService.getDisplayShoesCount(map);// 출력해야하는 상품목록줄 수
        }
        int offset = (int)map.get("offset") + UP;
        if (offset >= totalShoes) {
            offset = totalShoes - OFFSET;
            ShoesResultView.displayEOP();
        }
        map.put("offset", offset);

        List<ShoesSelectDto> list = shoesService.selectShoesList(map);
        ShoesResultView.displayShoesList(list);
        return list;
    }

    public List<ShoesSelectDto> pageDown(Map<String, Object> map) {

        int offset = (int)map.get("offset") + DOWN;
        if (offset < 0) {
            offset = 0;
            ShoesResultView.displaySOP();
        }
        map.put("offset", offset);

        List<ShoesSelectDto> list = shoesService.selectShoesList(map);
        ShoesResultView.displayShoesList(list);
        return list;
    }


    // 구매할 상품 하나에 대한 정보를 가져온다. (Shoes_id)
    public int getShoes(ShoesDto shoes, String size) {
        shoes.setSize(size);
        int shoesId = shoesService.getShoesId(shoes);
        shoes.setShoesId(shoesId);
        return shoesId;
    }

    public void insertToCart(UserDto user, ShoesDto shoes) {
        CartDto cart = new CartDto();

        cart.setUserId(user.getUserId());
        cart.setShoesId(shoes.getShoesId());

        int result = shoesService.insertToCart(cart);
    }
}















