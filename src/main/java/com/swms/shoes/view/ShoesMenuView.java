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

            // 1. 신발종류 선택
            int typeId = Integer.parseInt(inputType());
            // 2. 브랜드 선택
            int brandId = Integer.parseInt(inputBrand());
            // 3. 정렬 선택
            String sortingOption = selectSortingOption();


            switch (sortingOption) {
                case "1":
                    shoesController.sortingByLatest(brandId, typeId);
                    break;
                case "2":
                    shoesController.sortingByPriceASC(brandId, typeId);
                    break;
                case "3":
                    shoesController.sortingByPriceDESC(brandId, typeId);
                    break;
                case "0":
                    System.exit(0);

                // 4. 선택에 따른 결과 뿌려주기

                // 5. 1) 페이지 앞으로가기 (1페이지에선 동작 x) 2) 뒤로가기 3) 상세조회(선택)

                // 받은 아이디에 선택에 맞게 조회 뿌리기


                //shoesController.searchTypeName(typeId); // 선택한 type 조회
                //shoesController.searchBrandName(brandId); // 선택한 brand 조회


            }
        }
    }

    // TODO : 전체 옵션은 시간되면
    public String inputType() {
        System.out.print("""
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

    public String selectSortingOption() {
        System.out.print("""
               
                ---------------------------------------------------
                정렬 옵션을 선택해주세요.
                1. 최신순   2. 낮은가격순   3. 높은가격순  \s
                
                0. 프로그램 종료 \s
                ---------------------------------------------------
                >> 입력 :\t""");
        return sc.nextLine();

    }

}
