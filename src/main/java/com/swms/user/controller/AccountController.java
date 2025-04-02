package com.swms.user.controller;

import com.swms.user.model.dto.AccountDto;
import com.swms.user.model.dto.UserDto;
import com.swms.user.model.service.AccountService;
import com.swms.user.model.service.UserService;

public class AccountController {

    private AccountService accountService = new AccountService();

    public UserDto login(String id, String password) {
        AccountDto account = new AccountDto(id, password);


        return accountService.login(account);
    }

    public Boolean checkIdDuplication(String id) {
        Boolean result = accountService.checkIdDuplication(id);

        return result;
    }


    public void signup(String id, String password, String userName, int auth, String phone, String address) {
        AccountDto account = new AccountDto(id, password);


    }
}
