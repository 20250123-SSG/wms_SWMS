package com.swms.shoes.controller;

import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.service.ShoesService;
import com.swms.shoes.view.ShoesResultView;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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

    // 다음페이지
    public List<ShoesDto> pageUp(Map<String, Object> map) {

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

        List<ShoesDto> list = shoesService.selectShoesList(map);
        ShoesResultView.displayShoesList(list);
        return list;
    }

    public List<ShoesDto> pageDown(Map<String, Object> map) {

        int offset = (int)map.get("offset") + DOWN;
        if (offset < 0) {
            offset = 0;
            ShoesResultView.displaySOP();
        }
        map.put("offset", offset);

        List<ShoesDto> list = shoesService.selectShoesList(map);
        ShoesResultView.displayShoesList(list);
        return list;
    }
}















