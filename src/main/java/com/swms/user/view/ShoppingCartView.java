package com.swms.user.view;

import com.swms.order.controller.OnlineOrderController;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.controller.ShoppingCartController;
import com.swms.user.model.dto.UserDto;


import java.util.List;
import java.util.Scanner;

public class ShoppingCartView {
    Scanner sc = new Scanner(System.in);

    public static void checkCartList(List<ShoesDto> list){
        ShoppingCartController shoppingCartController = new ShoppingCartController();
        OnlineOrderController onlineOrderController = new OnlineOrderController();
        Scanner sc = new Scanner(System.in);
        if (list.isEmpty()){
            System.out.println("==장바구니가 아직 등록되지 않았습니다==");
        }else {
            for (ShoesDto cart : list){
                System.out.printf("장바구니 :신발명: %s\t가격: %s\t사이즈: %d \n",
                        cart.getShoesName(),
                        cart.getShoesPrice(),
                        cart.getSize());


            }


        }
        while(true){
            System.out.print("""
                    \n=============================
                    1. 장바구니 상품 구매
                    2. 장바구니 상품 삭제
                    0. 뒤로가기
                    =============================
                    > 입력:""");

            String menu = sc.nextLine();
            switch(menu){
                case "1":
                    UserDto user = new UserDto();
                    ShoesDto shoes = new ShoesDto();
                    onlineOrderController.onlineOrder(user, shoes); break;
                case "2": shoppingCartController.removeShoes(inputId("삭제할 상품 이름")); break;
                case "0": return;
                default : System.out.println("메뉴를 잘못 입력하셨습니다.");
            }

        }
    }
    public static String inputId(String type) {
        Scanner sc=new Scanner(System.in);
        System.out.printf("> %s 입력: ", type);
        return sc.nextLine();

    }

}
