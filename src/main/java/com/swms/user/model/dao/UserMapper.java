package com.swms.user.model.dao;

import com.swms.user.model.dto.UserDto;

import java.util.List;

public interface UserMapper {

    // User
    List<UserDto> selectAllMenu();
    UserDto selectMenuByMenuCode(int code);
    List<UserDto> selectMenuByCategoryCode(int code);

    int insertUser(UserDto menu);
    int updateUser(UserDto menu);
    int deleteUser(int code);

}
