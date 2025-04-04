package com.swms.user.model.dao;

import com.swms.user.model.dto.ShoppingCartDto;

import java.util.List;

public interface ShoppingCartMapper {

    List<ShoppingCartDto> checkShoppingCart();
}
