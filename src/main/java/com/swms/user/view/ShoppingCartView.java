package com.swms.user.view;

import com.swms.order.controller.OnlineOrderController;
import com.swms.order.model.service.OnlineOrderService;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.controller.ShoppingCartController;
import com.swms.user.model.dto.AccountUserDto;
import com.swms.user.model.dto.CartDto;
import com.swms.user.model.dto.UserDto;


import java.util.List;
import java.util.Scanner;


public class ShoppingCartView {

    //private OnlineOrderController onlineOrderController = new OnlineOrderController();
    private OnlineOrderService onlineOrderService = new OnlineOrderService();

    private Scanner sc = new Scanner(System.in);
    public void checkCartList(List<ShoesDto> list){
        if (list.isEmpty()){
            System.out.println("==장바구니가 아직 등록되지 않았습니다==");
        }else {
            for (ShoesDto cart : list){
                System.out.printf("장바구니 :신발명: %s\t신발ID: %s\t가격: %s\t사이즈: %s \n",
                        cart.getShoesName(),
                        cart.getShoesId(),
                        cart.getShoesPrice(),
                        cart.getSize());


            }
            ShoppingCartController shoppingCartController = new ShoppingCartController();
            while(true) {
                System.out.print("""
                    \n=============================
                    1. 장바구니 상품 구매
                    2. 장바구니 상품 삭제
                    0. 뒤로가기
                    =============================
                    > 입력:""");

                String menu = sc.nextLine();
                switch (menu) {
                    case "1":
                        //shoppingCartController.buyCart((buyShoesId("구매할 신발ID")));
                        UserDto user = new UserDto();
                        user.setUserId(user.getUserId()); // 예시 값 설정
                        int price = user.getMoney();

                        shoppingCartController.createOrder(user ,price);
//                        UserDto userDto = new UserDto(4, "qwer", 1, "010-9378-8677", "rewq", 215000);
//                        ShoesDto shoesDto = new ShoesDto(1, "나이키", "스니커즈", "에어 포스 1", 129000, "270");
//
//                        onlineOrderService.onlineOrder(userDto , shoesDto); break;
                    case "2":

                        shoppingCartController.removeCart(inputId("삭제할 상품 아이디"));
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("메뉴를 잘못 입력하셨습니다.");
                }
            }

        }

    }
    public String inputId(String type) {
        System.out.printf("> %s 입력: ", type);
        return sc.nextLine();

    }
//    public String buyShoesId(String type) {
//        System.out.printf("> %s 입력: ", type);
//        return sc.nextLine();
//
//    }
//    public String insertOnlineOrder() {
//
//
//    }

}
