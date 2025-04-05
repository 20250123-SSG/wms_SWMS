package com.swms.shoes.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 옵션 선택 뷰
public class ShoesOptionView {
    private Scanner sc = new Scanner(System.in);
    public String inputType() {
        System.out.print("""
                ====================================
                XYZ-Mart에 방문해주셔서 감사합니다.
                ====================================
                찾으시는 상품의 종류를 선택해주세요.
               
                1. 스니커즈
                2. 런닝화
                3. 구두
                4. 샌들
                5. 부츠 
                
                0. 프로그램 종료
                ====================================
                >> 입력 :\t""");

        String input = sc.nextLine();

        if("0".equals(input)){
            System.exit(0);
        }

        return input;
    }

    public String inputBrand() {
        System.out.print("""
                ====================================
                찾으시는 브랜드를 선택해주세요.
                
                1. 나이키
                2. 아디다스
                3. 뉴발란스
                4. 크록스
                5. 반스
                
                0. 프로그램 종료
                ========================
                >> 입력 :\t""");

        String input = sc.nextLine();

        if("0".equals(input)){
            System.exit(0);
        }

        return input;
    }

    public List<String> inputSorting() {
        List<String> sortingOption = new ArrayList<>();
        System.out.print("""
                
                ---------------------------------------------------
                정렬 옵션을 선택해주세요.
                1. 최신순   2. 낮은가격순   3. 높은가격순  \s
                
                0. 프로그램 종료 \s
                ---------------------------------------------------
                >> 입력 :\t""");

        switch (sc.nextLine()) {
            case "1":
                sortingOption = List.of("shoes_id", "ASC");
                break;
            case "2":
                sortingOption = List.of("shoes_price", "ASC");
                break;
            case "3":
                sortingOption = List.of("shoes_price", "DESC");
                break;
            case "0":
                System.exit(0);
                break;

        }
        return sortingOption;
    }
}
