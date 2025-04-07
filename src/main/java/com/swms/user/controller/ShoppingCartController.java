package com.swms.user.controller;

import com.swms.order.model.service.OnlineOrderService;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.view.ShoesResultView;
import com.swms.user.model.dto.UserDto;
import com.swms.user.model.service.ShoppingCartService;
import com.swms.user.view.ResultView;
import com.swms.user.view.ShoppingCartView;


import java.util.List;

public class ShoppingCartController {
    OnlineOrderService onlineOrderService =new OnlineOrderService();
    private ShoppingCartService shoppingCartService = new ShoppingCartService();



    public void selectCartList(UserDto userDto){
        List<ShoesDto> list = shoppingCartService.selectCartList(userDto);
        ShoppingCartView.checkCartList(list);

    }
    public void removeShoes(String id) {

        int result = shoppingCartService.removeShoes(Integer.parseInt(id));
        ResultView.displayResult("신발 삭제", result);

    }
}
