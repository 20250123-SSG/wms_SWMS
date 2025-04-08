package com.swms.run.page;

import com.swms.common.AnsiColor;
import com.swms.common.Logo;
import com.swms.shoes.view.ShoesMenuView;
import com.swms.user.model.dto.UserDto;

import java.util.Scanner;

public class MainPage {
    private static Scanner sc = new Scanner(System.in);
    private static String message = null;

    public static void mianPage(UserDto userDto) {
        while (true) {
            Logo.printLogo();
            System.out.println(AnsiColor.BLUE + "  ┌─────────────────────────────────────────────┐" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  │ " + AnsiColor.GREEN + "     Shoes Warehouse Management System " + AnsiColor.BLUE + "     │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  └─────────────────────────────────────────────┘" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "               1. 마이 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               2. 신발 조회 및 구매" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "               8. 점장 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               9. 관리자 페이지" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "               0. 프로그램 종료" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.BLUE + " ─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─" + AnsiColor.RESET);
            if (message != null) {
                System.out.println(AnsiColor.BRIGHT_RED + "                " + message + AnsiColor.RESET);
                message = null;
            }

            System.out.print("""
                    > 입력:""");

            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    MyPage.myPage(userDto);
                    break;
                case "2":
                    new ShoesMenuView().MainView(userDto);
                    break;
                case "8":
                    message = StoreManagerPage.storeMangerPage(userDto);
                    break;
                case "9":
                    message = AdminPage.adminPage(userDto);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }
        }

    }
}
