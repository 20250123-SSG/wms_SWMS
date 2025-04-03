package com.swms.user.controller;

import com.swms.user.model.dto.AccountDto;
import com.swms.user.model.dto.AccountUserDto;
import com.swms.user.model.dto.UserDto;
import com.swms.user.model.service.AccountService;

public class AccountController {

    private AccountService accountService = new AccountService();

    public UserDto login(String account, String password) {
        AccountDto accountDto = new AccountDto(account, password);

        accountService.checkPassword(accountDto);

        return accountService.login(accountDto);
    }


    public int signup(String account, String password, String userName, int auth, String phone, String address) {
        AccountUserDto accountUser = AccountUserDto.builder().
                account(account).
                password(password).
                userName(userName).
                auth(auth).
                phone(phone).
                address(address).
                build();

        return accountService.registAccountUser(accountUser);
    }

    public boolean checkAccountDuplication(String account) {

        return accountService.checkAccountDuplication(account);
    }
}
