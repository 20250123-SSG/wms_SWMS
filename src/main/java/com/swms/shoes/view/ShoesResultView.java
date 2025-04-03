package com.swms.shoes.view;

import com.swms.shoes.model.dto.ShoesDto;

import java.util.List;

import static com.swms.shoes.controller.ShoesController.brandName;

public class ShoesResultView {

    // 조회된 신발 10개씩 보여주는 view
    public static void displayShoesList(List<ShoesDto> list){
        System.out.println("""
                ====================================
                신발조회페이지입니다. 원하시는 상품의 번호를 입력하시면 상세내용을 확인하실 수 있습니다.
                
               
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



}
