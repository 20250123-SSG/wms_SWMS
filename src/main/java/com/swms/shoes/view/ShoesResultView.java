package com.swms.shoes.view;

import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesSelectDto;

import java.util.List;

public class ShoesResultView {

    // 조회된 신발 10개씩 보여주는 view
    public static void displayShoesList(List<ShoesSelectDto> list){
        System.out.println("""
                \n====================================
                 
               
                             🏀 신발 목록 🏀    
                =========================================
                [번호]            [이름]           [가격] 
                -----------------------------------------
                """);

        int index = 1;
        for (ShoesSelectDto shoes : list){
            // TODO : 1~10보다 11~19, 21~30이 더 예쁠거 같음
            System.out.printf("%d%s\t\t%s\n", index++, String.format("%20s", shoes.getShoesName()), String.format("%8s", shoes.getShoesPrice()));
        }
    }


    public static void displayShoes(ShoesDto shoes) {
        System.out.printf("""
                ============================================
                           🏀 신발 상세 조회 🏀
                ============================================
                
                브랜드      : %s
                타입        : %s
                제품 이름   : %s
                가격        : %d원
                
                """, shoes.getBrandName(), shoes.getShoesType(), shoes.getShoesName(), shoes.getShoesPrice());
    }
    public static void displayShoesSizeList(List<String> sizeList) {
            System.out.printf("""
                            --------------------------------------------
                            현재 구매가능한 사이즈
                            --------------------------------------------
                            """);
        sizeList.forEach(size -> System.out.printf("%smm \t", size));
        System.out.println();
    }

    public static void displaySOP() {
        System.out.println("첫 페이지입니다.");
    }

    public static void displayEOP() {
        System.out.println("마지막 페이지입니다.");
    }

//    public static void displayOnlineOrder(ShoesDetailDto shoes, String size, UserDto user) {
//        System.out.println("\n🛒 구매 정보 확인");
//        System.out.println("구매자: " + user.getName()); // 예시
//        System.out.println("상품명: " + shoes.getShoesName());
//        System.out.println("사이즈: " + size);
//        System.out.println("가격: " + shoes.getShoesPrice() + "원");
//
//    }
}
