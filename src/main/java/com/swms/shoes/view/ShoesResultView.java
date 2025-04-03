package com.swms.shoes.view;

import com.swms.shoes.model.dto.ShoesDto;

import java.util.List;

public class ShoesResultView {

    // 조회된 신발 10개씩 보여주는 view
    public static void displayShoesList(List<ShoesDto> list){
        for (ShoesDto shoes : list) {
            System.out.println(shoes);
        }
    }
}
