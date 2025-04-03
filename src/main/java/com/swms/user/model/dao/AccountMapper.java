package com.swms.user.model.dao;

import com.swms.user.model.dto.AccountDto;
import com.swms.user.model.dto.AccountUserDto;
import com.swms.user.model.dto.UserDto;

import java.util.List;

public interface AccountMapper {

    String selectByAccount(String account);
    int insertAccountUser(AccountUserDto accountUserDto);

}
