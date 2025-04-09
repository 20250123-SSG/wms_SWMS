package com.swms.user.view;

import com.swms.common.AnsiColor;
import com.swms.user.controller.AccountController;
import com.swms.user.model.dto.UserDto;

import java.util.Scanner;

public class AccountView {
    private Scanner sc = new Scanner(System.in);
    private AccountController accountController = new AccountController();


    public void signup() {
        // 아이디
        String account;
        while (true) {
            System.out.println(AnsiColor.BRIGHT_BLUE + "\n        등록할 회원 정보를 작성해주세요.");
            System.out.println(AnsiColor.BRIGHT_YELLOW + "\n 아이디는 20자 이내여야 합니다.");
            System.out.println("> 아이디: ");
            account = sc.nextLine();

            boolean result = accountController.checkAccountDuplication(account);

            if (!result) break;

            ResultView.handleDuplicateId();

        }

        // 비밀번호
        System.out.println(AnsiColor.BRIGHT_YELLOW + "\n 비밀번호는 20자 이내여야 합니다.");
        System.out.println("> 비밀번호: ");
        String password = sc.nextLine();

        // 이름
        System.out.println(AnsiColor.BRIGHT_YELLOW + "\n 이름을 입력하세요");
        System.out.println("> 이름: ");
        String userName = sc.nextLine();

        // 권한
        System.out.print("""
    \n╔════════════════════════════╗
      🔐 권한을 선택하세요
    ╟────────────────────────────╢
      1. 👤 일반 사용자
      2. 🧑‍💼 점장
      0. 🛠️ 관리자
    ╚════════════════════════════╝
    > 권한: """);

        String auth;
        while (true) {
            auth = sc.nextLine();

            if(auth.equals("1") || auth.equals("2") || auth.equals("0")) break;
            ResultView.handleAuth(auth);
        }

        // 휴대폰 번호
        System.out.println("\n 휴대폰 번호를 입력하세요");
        System.out.println("> 휴대폰: ");
        String phone = sc.nextLine();

        // 주소
        System.out.println("\n 주소를 입력하세요");
        System.out.println("> 주소: " + AnsiColor.RESET);
        String address = sc.nextLine();

        int result = accountController.signup(account, password, userName, Integer.parseInt(auth), phone, address);
        ResultView.signupResult("회원가입", result);
    }

    public UserDto login() {
        System.out.println("\n~~~ 로그인 정보를 작성해주세요 ~~~");
        System.out.println("> 아이디: ");
        String id = sc.nextLine();
        System.out.println("> 비밀번호: ");
        String password = sc.nextLine();

        return accountController.login(id, password);
    }

}

