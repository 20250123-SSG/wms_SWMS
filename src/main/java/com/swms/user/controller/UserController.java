package com.swms.user.controller;

import com.swms.user.model.dto.AccountDto;
import com.swms.user.model.dto.UserDto;
import com.swms.user.model.service.AccountService;
import com.swms.user.model.service.UserService;
import com.swms.user.view.ResultView;

public class UserController {
    private UserService userService = new UserService();

    public void updateAddress(UserDto user, String address) {

        int result = userService.updateAddress(user, address);

        ResultView.updateResult("주소", result);
    }
}
