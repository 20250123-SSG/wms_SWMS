package com.swms.user.model.dao;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.model.dto.UserDto;

import java.util.List;

public interface ShoppingCartMapper {


    List<ShoesDto> checkShoppingCart(UserDto userDto);


    int deleteCart(int shoesid);

    int buyCart(int buyName);
}
