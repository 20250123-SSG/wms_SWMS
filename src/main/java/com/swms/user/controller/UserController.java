package com.swms.user.controller;

import com.swms.user.model.dto.AccountDto;
import com.swms.user.model.dto.ShoppingCartDto;
import com.swms.user.model.dto.UserDto;
import com.swms.user.model.service.AccountService;
import com.swms.user.model.service.UserService;
import com.swms.user.view.ResultView;
import com.swms.user.view.ShoppingCartView;

import java.util.List;

public class UserController {
    private UserService userService = new UserService();

    public void updateAddress(UserDto user, String address) {

        int result = userService.updateAddress(user, address);

        ResultView.updateResult("주소", result);
    }

    public void updateMoney(UserDto userMoney, int money) {

        int result = userService.updateMoney(userMoney, money);

        ResultView.updateResult("금액", result);
    }

    public void updatePhone(UserDto userPhone, String phone) {

        int result = userService.updatePhone(userPhone, phone);

        ResultView.updateResult("전화번호", result);
    }


}


