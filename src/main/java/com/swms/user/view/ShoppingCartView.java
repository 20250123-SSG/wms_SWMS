package com.swms.user.view;

import com.swms.common.AnsiColor;
import com.swms.order.controller.OnlineOrderController;
import com.swms.order.model.service.OnlineOrderService;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.controller.ShoppingCartController;
import com.swms.user.model.dto.UserDto;


import java.util.List;
import java.util.Scanner;

public class ShoppingCartView {

    //private OnlineOrderController onlineOrderController = new OnlineOrderController();
    private OnlineOrderService onlineOrderService = new OnlineOrderService();

    private Scanner sc = new Scanner(System.in);
    public String checkCartList(List<ShoesDto> list){
        if (list.isEmpty()){
            return "장바구니가 아직 등록되지 않았습니다";
        }else {
            System.out.println(AnsiColor.BRIGHT_BLUE + """
        \n
        ===========================================
                     🛒  장바구니 목록  🛒
        ===========================================
        신발명\t\t신발ID\t\t가격\t\t사이즈
        -------------------------------------------
        """ + AnsiColor.RESET);

            for (ShoesDto cart : list) {
                System.out.printf(AnsiColor.BRIGHT_WHITE + "%-15s\t%-8s\t%8s원\t%4s\n" + AnsiColor.RESET,
                        cart.getShoesName(),
                        cart.getShoesId(),
                        cart.getShoesPrice(),
                        cart.getSize());
            }
            ShoppingCartController shoppingCartController = new ShoppingCartController();

            while(true) {
                System.out.print(AnsiColor.BRIGHT_BLUE + """
        \n=========================================
                 🛒  장바구니 메뉴 선택  🛒
        
        """ + AnsiColor.BRIGHT_WHITE + """
        1. 장바구니 상품 구매
        2. 장바구니 상품 삭제
        0. 뒤로가기
        """ + AnsiColor.BRIGHT_BLUE + """
        
        """ + AnsiColor.RESET + "> 입력 : ");

                String menu = sc.nextLine();
                switch (menu) {
                    case "1":
                        shoppingCartController.buyCart((buyShoesId("구매할 신발ID")));

                    case "2":
                        shoppingCartController.removeCart(inputId("삭제할 상품 아이디"));
                        break;
                    case "0":
                        return null;
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
    public String buyShoesId(String type) {
        System.out.printf("> %s 입력: ", type);
        return sc.nextLine();

    }
//    public String insertOnlineOrder() {
//
//
//    }

}
