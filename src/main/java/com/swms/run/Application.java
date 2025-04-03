package com.swms.run;

import com.swms.user.model.dto.UserDto;
import com.swms.user.view.AccountView;

import java.util.Scanner;

public class Application {
    private static final String BLUE = "\033[34m";
    private static final String GREEN = "\033[32m";
    private static final String RESET = "\033[0m";
    private static AccountView userView = new AccountView();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(BLUE + " ┌=========================================┐");
        System.out.println(BLUE + " │  ███████╗██╗    ██╗███╗   ███╗███████╗  │" + RESET);
        System.out.println(BLUE + " │  ██╔════╝██║    ██║████╗ ████║██╔════╝  │" + RESET);
        System.out.println(BLUE + " │  ███████╗██║ █╗ ██║██╔████╔██║█████╗    │" + RESET);
        System.out.println(BLUE + " │  ╚════██║██║███╗██║██║╚██╔╝██║██╔══╝    │" + RESET);
        System.out.println(BLUE + " │  ███████║╚███╔███╔╝██║ ╚═╝ ██║███████╗  │" + RESET);
        System.out.println(BLUE + " │  ╚══════╝ ╚══╝╚══╝ ╚═╝     ╚═╝╚══════╝  │" + RESET);
        System.out.println(BLUE + " └=========================================┘");
        System.out.println(BLUE + "               \uD83D\uDC5F\uD83E\uDD7E\uD83D\uDC5E\uD83D\uDC60\uD83D\uDC62\uD83E\uDD7F" + RESET);
        System.out.println(BLUE + "┌─────────────────────────────────────────────┐" + RESET);
        System.out.println(BLUE + "│ " + GREEN + "     Shoes Warehouse Management System " + BLUE + "     │" + RESET);
        System.out.println(BLUE + "└─────────────────────────────────────────────┘" + RESET);
        System.out.println();
        System.out.println(GREEN + "                1. 로그인" + RESET);
        System.out.println(GREEN + "                2. 회원가입" + RESET);
        System.out.println(GREEN + "                0. 프로그램 종료" + RESET);
        System.out.println();
        System.out.println(BLUE + " ─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─" + RESET);

        UserDto userDto = null;

        while (userDto == null) {
            System.out.print("""
                    > 입력:""");

            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    userDto = userView.login();
                    break;
                case "2":
                    userView.signup();
                case "0":
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }
        }

        System.out.print(userDto);
    }
}
