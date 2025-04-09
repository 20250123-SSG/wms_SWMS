package com.swms.run.page;

import com.swms.common.AnsiColor;
import com.swms.common.Logo;
import com.swms.user.model.dto.UserDto;
import com.swms.user.view.AccountView;

import java.util.Scanner;

public class LoginPage {
    private static AccountView accountView = new AccountView();
    private static Scanner sc = new Scanner(System.in);
    private static String message = null;

    public static UserDto loginPage() {
        UserDto userDto = null;
        while (userDto == null) {
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
            if (message != null) {
                System.out.println(AnsiColor.BRIGHT_YELLOW + "  " + message + AnsiColor.RESET);
                message = null;
            }

            System.out.print("""
                    > 입력:""");

            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    userDto = accountView.login();
                    break;
                case "2":
                    accountView.signup();
                    message = "📢 회원가입 이 완료되었습니다. 로그인을 시도해주세요";
                    break;
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
