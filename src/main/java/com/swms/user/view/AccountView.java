package com.swms.user.view;

import com.swms.user.controller.AccountController;

import java.util.Scanner;

public class AccountView {
    private Scanner sc = new Scanner(System.in);
    private AccountController userController = new AccountController();


    public void signup() {

        System.out.println("\n~~~ 등록할 회원 정보를 작성해주세요 ~~~");
        System.out.println("\n 아이디는 20자 이내여야 합니다.");
        System.out.println("> 아이디: ");
        String id = sc.nextLine();
        userController.checkIdDuplication(id);

        System.out.println("\n 비밀번호는 20자 이내여야 합니다.");
        System.out.println("> 비밀번호: ");
        String password = sc.nextLine();



    }

    public void login() {
        System.out.println("\n~~~ 로그인 정보를 작성해주세요 ~~~");
        System.out.println("> 아이디: ");
        String id = sc.nextLine();
        System.out.println("> 비밀번호: ");
        String password = sc.nextLine();

        userController.login(id, password);
    }


}

