package com.swms.user.controller;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.model.dto.UserDto;
import com.swms.user.model.service.ShoppingCartService;
import com.swms.user.view.ShoppingCartView;

import java.util.List;

public class ShoppingCartController {
    private ShoppingCartService shoppingCartService = new ShoppingCartService();



    public void selectCartList(UserDto userDto){
        List<ShoesDto> list = shoppingCartService.selectCartList(userDto);
        ShoppingCartView.checkCartList(list);


    }

}
