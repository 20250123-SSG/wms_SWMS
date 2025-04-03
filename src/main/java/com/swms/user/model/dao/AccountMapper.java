package com.swms.user.model.dao;

import com.swms.user.model.dto.AccountDto;
import com.swms.user.model.dto.AccountUserDto;
import com.swms.user.model.dto.UserDto;

public interface AccountMapper {

    String selectByAccount(String account);
    AccountDto findByAccountIncludingPassword(String account);

    UserDto findUserByAccount(AccountDto accountDto);

    int insertAccountUser(AccountUserDto accountUserDto);

}
