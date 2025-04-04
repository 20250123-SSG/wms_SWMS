package com.swms.user.model.dao;

import com.swms.user.model.dto.ShoppingCartDto;
import com.swms.user.model.dto.UserDto;

import java.util.List;

public interface UserMapper {

    int updateAddress(UserDto userDto);
    //돈 돈 돈 돈
    int updateMoney(UserDto userDto);
    // 전화번호
    int updatePhone(UserDto userDto);


}
