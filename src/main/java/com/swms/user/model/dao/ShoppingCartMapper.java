package com.swms.user.model.dao;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.model.dto.ShoppingCartDto;
import com.swms.user.model.dto.UserDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ShoppingCartMapper {


    List<ShoesDto> checkShoppingCart(UserDto userDto);


}
