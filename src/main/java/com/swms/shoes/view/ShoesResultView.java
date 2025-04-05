package com.swms.shoes.view;

import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;

import java.util.List;

public class ShoesResultView {

    // 조회된 신발 10개씩 보여주는 view
    public static void displayShoesList(List<ShoesDto> list){
        System.out.println("""
                \n====================================
                 
               
                             🏀 신발 목록 🏀    
                =========================================
                [번호]            [이름]           [가격] 
                -----------------------------------------
                """);

        int index = 1;
        for (ShoesDto shoes : list){

            System.out.printf("%d%s\t\t%s\n", index++, String.format("%20s", shoes.getShoesName()), String.format("%8s", shoes.getShoesPrice()));
        }
    }


    public static void displayShoes(ShoesDetailDto shoes) {
        System.out.printf("""
                            ============================================
                                       🏀 신발 상세 조회 🏀
                            ============================================
                    
                            브랜드      : %s
                            타입        : %s
                            제품 이름   : %s
                            가격        : %d원
                            
                            """, shoes.getBrandName(),shoes.getShoesType(),shoes.getShoesName(),shoes.getShoesPrice());

        System.out.println("""
                            --------------------------------------------
                            현재 구매가능한 사이즈
                            --------------------------------------------""");
        shoes.getSizeList().forEach(size -> System.out.printf("%dmm \t", size));
        System.out.println();
    }
}
