package com.swms.user.controller;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.model.dto.ShoppingCartDto;
import com.swms.user.model.service.ShoppingCartService;
import com.swms.user.view.ShoppingCartView;

import java.util.List;

public class ShoppingCartController {
    private ShoppingCartService shoppingCartService = new ShoppingCartService();



    public void selectCartList(){
        List<ShoesDto> list = shoppingCartService.selectCartList();
        ShoppingCartView.checkCartList(list);


    }

}
