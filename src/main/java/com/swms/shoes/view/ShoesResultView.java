package com.swms.shoes.view;

import com.swms.common.AnsiColor;
import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesSelectDto;

import java.util.List;

public class ShoesResultView {

    // 조회된 신발 10개씩 보여주는 view
    public static void displayShoesList(List<ShoesSelectDto> list) {
        System.out.println(AnsiColor.BRIGHT_BLUE + """
            \n
            ==============================================
                         👟  신발 목록 보기  👟
            ==============================================
            [번호]           [이름]                 [가격]
            ----------------------------------------------
            """ + AnsiColor.RESET);

        int index = 1;
        for (ShoesSelectDto shoes : list) {
            System.out.printf(
                    AnsiColor.BRIGHT_WHITE + "  %-6d %-20s %10s\n" + AnsiColor.RESET,
                    index++,
                    shoes.getShoesName(),
                    shoes.getShoesPrice() + "원"
            );
        }
    }


    public static void displayShoes(ShoesDto shoes) {
        System.out.println(AnsiColor.BRIGHT_BLUE + "============================================" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "          🔍👟 신발 상세 정보 조회 📋" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_BLUE + "============================================" + AnsiColor.RESET);

        System.out.printf(AnsiColor.BRIGHT_WHITE + """
        🏷️ 브랜드      : %s
        🧩 종류        : %s
        📛 제품 이름   : %s
        💰 가격        : %,d원
""" + AnsiColor.RESET,
                shoes.getBrandName(),
                shoes.getShoesType(),
                shoes.getShoesName(),
                shoes.getShoesPrice()
        );
    }

    public static void displayShoesSizeList(List<String> sizeList) {
        System.out.println(AnsiColor.BRIGHT_BLUE + "============================================" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "         📏 현재 구매 가능한 사이즈 👟" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_BLUE + "============================================" + AnsiColor.RESET);
        sizeList.forEach(size -> System.out.printf(AnsiColor.BRIGHT_WHITE + "%smm \t", size));
        System.out.println();
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
