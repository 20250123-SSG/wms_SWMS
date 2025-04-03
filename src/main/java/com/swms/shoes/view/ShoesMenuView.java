package com.swms.shoes.view;

import com.swms.shoes.controller.ShoesController;

import java.util.Scanner;

public class ShoesMenuView {
    private ShoesController shoesController = new ShoesController();
    private Scanner sc = new Scanner(System.in);

    public void NavigationView() {
        while (true) {
            System.out.println("====================================");
            System.out.println("XYZ-Mart에 방문해주셔서 감사합니다.");

            String type = inputType();
            String brand = inputBrand();

            shoesController.shoesMainVeiw(type, brand);
        }
    }

    public String inputType() {
        System.out.println("""
                ====================================
                찾으시는 상품의 종류를 선택해주세요.
                
                1. 전체
                2. 스니커즈
                3. 런닝화
                4. 구두
                5. 샌들
                6. 부츠
                
                0. 프로그램 종료
                ====================================
                >> 입력 : """);

        return sc.nextLine();
    }

    public String inputBrand() {
        System.out.println("""
                ====================================
                찾으시는 브랜드를 선택해주세요.
                
                1. 전체
                2. 나이키
                3. 아디다스
                4. 뉴발란스
                5. 크록스
                6. 반스
                
                0. 프로그램 종료
                ========================
                >> 입력 : """);

        return sc.nextLine();
    }

    public void selectShoesView() {

    }

}
