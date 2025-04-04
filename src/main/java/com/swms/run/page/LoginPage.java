package com.swms.run.page;

import com.swms.common.AnsiColor;
import com.swms.common.Logo;
import com.swms.user.model.dto.UserDto;
import com.swms.user.view.AccountView;

import java.util.Scanner;

public class LoginPage {
    private static AccountView accountView = new AccountView();
    private static Scanner sc = new Scanner(System.in);

    public static UserDto loginPage() {
        Logo.printLogo();
        System.out.println(AnsiColor.BLUE + "  ┌─────────────────────────────────────────────┐" + AnsiColor.RESET);
        System.out.println(AnsiColor.BLUE + "  │ " + AnsiColor.GREEN + "     Shoes Warehouse Management System " + AnsiColor.BLUE + "     │" + AnsiColor.RESET);
        System.out.println(AnsiColor.BLUE + "  └─────────────────────────────────────────────┘" + AnsiColor.RESET);
        System.out.println();
        System.out.println(AnsiColor.GREEN + "                1. 로그인" + AnsiColor.RESET);
        System.out.println(AnsiColor.GREEN + "                2. 회원가입" + AnsiColor.RESET);
        System.out.println();
        System.out.println(AnsiColor.GREEN + "                0. 프로그램 종료" + AnsiColor.RESET);
        System.out.println();
        System.out.println(AnsiColor.BLUE + " ─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─" + AnsiColor.RESET);

        UserDto userDto = null;

        while (userDto == null) {
            System.out.print("""
                    > 입력:""");

            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    userDto = accountView.login();
                    break;
                case "2":
                    accountView.signup();
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    return null;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }
        }

        return userDto;
    }
}
