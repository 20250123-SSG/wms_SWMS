package com.swms.shoes.controller;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesOptionDto;
import com.swms.shoes.model.service.ShoesService;
import com.swms.shoes.view.ShoesResultView;

import java.util.List;


// 입력 및 출력 view와 연결되는 곳
public class ShoesController {
    public static String brandName;
    public static String TypeName;

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



    // TODO : 페이지네이션 적용 (resultView 단에서 해야할수도?)
    // 상품조회관련 - (1~3)정렬 & 상품명 검색
    public void sortingByLatest(int brandId, int typeId) {
        ShoesOptionDto selectOption =  new ShoesOptionDto(brandId, typeId);
        List<ShoesDto> list = shoesService.sortingByLatest(selectOption);
        System.out.println("(for test) 최신순정렬완료");
        ShoesResultView.displayShoesList(list);
    }

    public void sortingByPriceASC(int brandId, int typeId) {
        ShoesOptionDto selectOption =  new ShoesOptionDto(brandId, typeId);
        List<ShoesDto> list = shoesService.sortingByPriceASC(selectOption);
        System.out.println("(for test) 낮은가격순정렬완료");
        ShoesResultView.displayShoesList(list);
    }

    public void sortingByPriceDESC(int brandId, int typeId) {
        ShoesOptionDto selectOption =  new ShoesOptionDto(brandId, typeId);
        List<ShoesDto> list = shoesService.sortingByPriceDESC(selectOption);
        System.out.println("(for test) 높은가격순정렬완료");
        ShoesResultView.displayShoesList(list);
    }

    /*
    INSERT, UPDATE, DELETE는 반환값이 1 이상이면 정상 동작했다는 것을 확인할 수 있었으나,
    ORDER BY는 정렬만 할 뿐, 반환값으로 정렬되었는지 확인할 수 없다.
    정렬확인을 위해 쓰레기 데이터를 추가해줘야하나..
    시간되면 생각해보기
     */



    public void searchShoesName() {
    }
}















