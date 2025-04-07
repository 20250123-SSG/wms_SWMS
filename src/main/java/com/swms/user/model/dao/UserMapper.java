package com.swms.user.model.dao;

import com.swms.user.model.dto.ShoppingCartDto;
import com.swms.user.model.dto.UserDto;

import java.util.List;

public interface UserMapper {

    int updateAddress(UserDto userDto);
    //돈 충전 시스템입니다.
    int updateMoney(UserDto userDto);
    // 전화번호 수정 시스템입니다.
    int updatePhone(UserDto userDto);


}
