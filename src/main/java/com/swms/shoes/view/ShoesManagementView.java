package com.swms.shoes.view;

import com.swms.shoes.controller.ShoesManagementController;

import java.util.Map;
import java.util.Scanner;

public class ShoesManagementView {

    private ShoesManagementController shoesManagementController = new ShoesManagementController();
    private Scanner sc = new Scanner(System.in);

    public void ShoesManagementView(){
        while(true){
            System.out.print("""
                    \n=============================
                    1. 상품 등록
                    2. 상품 수정
                    3. 상품 삭제
                    0. 뒤로가기
                    =============================
                    > 입력:""");

            String menu = sc.nextLine();
            switch(menu){
                case "1": registShoesForm(); break;
                case "2": modifyShoesForm(); break;
                case "3": shoesManagementController.removeShoes(inputId("삭제할 신발 아이디")); break;
                case "0": return;
                default : System.out.println("메뉴를 잘못 입력하셨습니다.");
            }

        }
    }
    public String inputId(String type) {
        System.out.printf("> %s 입력: ", type);
        return sc.nextLine();

    }
    // 신규 신발 등록용 폼 제공 화면
    public void registShoesForm(){
        System.out.println("\n~~~ 등록할 신발 정보를 작성해주세요 ~~~");
        System.out.println("> 신발ID: ");
        String shoesId = sc.nextLine();
        System.out.println("> 신발타입ID: ");
        String shoesTypeId = sc.nextLine();
        System.out.println("> 브랜드ID: ");
        String brandId = sc.nextLine();
        System.out.println("> 신발명: ");
        String shoesName = sc.nextLine();
        System.out.println("> 신발 가격: ");
        String shoesPrice = sc.nextLine();
        System.out.println("> 사이즈: ");
        String size = sc.nextLine();

        Map<String, String> requestParam = Map.of(
                "id", shoesId,
                "typeid", shoesTypeId,
                "brand", brandId,
                "name", shoesName,
                "price", shoesPrice,
                "size", size
        );

        shoesManagementController.registShoes(requestParam);
    }

    // 기존 신발 수정용 폼 제공 화면
    private void modifyShoesForm() {
        System.out.println("\n~~~~ 수정할 신발 정보를 입력해주세요 ~~~");
        System.out.println("> 수정할 신발ID: ");
        String shoesId = sc.nextLine();
        System.out.println("> 신발명: ");
        String shoesName = sc.nextLine();
        System.out.println("> 신발 가격: ");
        String shoesPrice = sc.nextLine();
        System.out.println("> 사이즈: ");
        String size = sc.nextLine();

        Map<String, String> requestParam = Map.of(
                "id", shoesId,
                "name", shoesName,
                "price", shoesPrice,
                "size", size
        );

        shoesManagementController.modifyShoes(requestParam);
    }

}
