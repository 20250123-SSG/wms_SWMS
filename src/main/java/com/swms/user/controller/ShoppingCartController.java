package com.swms.user.controller;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.model.dto.UserDto;
import com.swms.user.model.service.ShoppingCartService;
import com.swms.user.view.ResultView;
import com.swms.user.view.ShoppingCartView;


import java.util.List;

public class ShoppingCartController {
    private ShoppingCartService shoppingCartService = new ShoppingCartService();
    private ShoppingCartView shoppingCartView = new ShoppingCartView();


    // 장바구니 목록 불러오는 메소드
    public String selectCartList(UserDto userDto){
        List<ShoesDto> list = shoppingCartService.selectCartList(userDto);
        return shoppingCartView.checkCartList(list);
    }
    public void removeCart(String shoesid) {

        int result = shoppingCartService.removeCart(Integer.parseInt(shoesid));
        ResultView.displayResult("신발 삭제", result);

    }
    public void createOrder(UserDto user, int price){
        int result = shoppingCartService.createOrder(user,price);
        ResultView.displayResult("주문 등록", result);
    }



//    public void buyCart(String buyName) {
//
//        String result = String.valueOf(shoppingCartService.buyCart(buyName));
//        ResultView.displayResult("신발 구매", Integer.parseInt(result));
//
//    }




}
