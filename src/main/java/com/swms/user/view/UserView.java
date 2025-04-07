package com.swms.user.view;

import com.swms.user.controller.AccountController;
import com.swms.user.controller.UserController;
import com.swms.user.model.dto.ShoppingCartDto;
import com.swms.user.model.dto.UserDto;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private Scanner sc = new Scanner(System.in);
    private UserController userController = new UserController();

    public void updateAddress(UserDto user) {
        System.out.println("\n~~~ 수정할 주소를 입력해주세요~~~");
        System.out.println("> 주소: ");
        String address = sc.nextLine();

        userController.updateAddress(user, address);

    }

    public void updateMoney(UserDto userMoney) {
        System.out.println("\n~~~ 충전할 금액을 입력해주세요~~~");
        System.out.println("> 금액: ");
        int money = sc.nextInt();

        userController.updateMoney(userMoney, money);

    }

    public void updatePhone(UserDto user) {
        System.out.println("\n~~~ 수정할 전화번호를 입력해주세요~~~");
        System.out.println("> 전화번호: ");
        String phone = sc.nextLine();

        userController.updatePhone(user, phone);

    }



}
