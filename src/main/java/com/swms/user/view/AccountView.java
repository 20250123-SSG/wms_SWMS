package com.swms.user.view;

import com.swms.user.controller.AccountController;

import java.util.Scanner;

public class AccountView {
    private Scanner sc = new Scanner(System.in);
    private AccountController userController = new AccountController();


    public void signup() {
        // 아이디
        String id;
        while (true) {
            System.out.println("\n~~~ 등록할 회원 정보를 작성해주세요 ~~~");
            System.out.println("\n 아이디는 20자 이내여야 합니다.");
            System.out.println("> 아이디: ");
            id = sc.nextLine();

            boolean result = userController.checkIdDuplication(id);

            if (!result) break;

            handleDuplicateId();

        }

        // 비밀번호
        System.out.println("\n 비밀번호는 20자 이내여야 합니다.");
        System.out.println("> 비밀번호: ");
        String password = sc.nextLine();

        // 이름
        System.out.println("\n 이름을 입력하세요");
        System.out.println("> 이름: ");
        String userName = sc.nextLine();

        // 권한
        System.out.print("""
                \n=============================
                     <권한을 선택하세요>
                1. 일반 사용자
                2. 점장
                0. 관리자
                =============================
                > 권한:""");

        String auth;
        while (true) {
            auth = sc.nextLine();

            if(auth.equals("1") || auth.equals("2") || auth.equals("0")) break;
            handleAuth(auth);
        }

        // 휴대폰 번호
        System.out.println("\n 휴대폰 번호를 입력하세요");
        System.out.println("> 휴대폰: ");
        String phone = sc.nextLine();

        // 주소
        System.out.println("\n 주소를 입력하세요");
        System.out.println("> 주소: ");
        String address = sc.nextLine();

        userController.signup(id, password, userName, Integer.parseInt(auth), phone, address);
    }

    public void login() {
        System.out.println("\n~~~ 로그인 정보를 작성해주세요 ~~~");
        System.out.println("> 아이디: ");
        String id = sc.nextLine();
        System.out.println("> 비밀번호: ");
        String password = sc.nextLine();

        userController.login(id, password);
    }


    public void handleDuplicateId() {
        System.out.println("~~~ 중복된 아이디 입니다. 다시 입력해주세요 ~~~");
    }

    public void handleAuth(String auth) {
        System.out.printf("~~~ %s는 없는 권한 입니다. 다시 입력해주세요 ~~~", auth);
        System.out.println();
    }
}

