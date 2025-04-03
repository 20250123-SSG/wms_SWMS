package com.swms.run.page;

import com.swms.common.AnsiColor;
import com.swms.user.model.dto.UserDto;

import java.util.Scanner;

public class MainPage {
    private static Scanner sc = new Scanner(System.in);

    public static void mianPage(UserDto userDto) {
        while (true) {
            System.out.println(AnsiColor.BLUE + "   ┌=========================================┐");
            System.out.println(AnsiColor.BLUE + "   │  ███████╗██╗    ██╗███╗   ███╗███████╗  │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "   │  ██╔════╝██║    ██║████╗ ████║██╔════╝  │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "   │  ███████╗██║ █╗ ██║██╔████╔██║█████╗    │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "   │  ╚════██║██║███╗██║██║╚██╔╝██║██╔══╝    │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "   │  ███████║╚███╔███╔╝██║ ╚═╝ ██║███████╗  │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "   │  ╚══════╝ ╚══╝╚══╝ ╚═╝     ╚═╝╚══════╝  │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "   └=========================================┘");
            System.out.println(AnsiColor.BLUE + "                  \uD83D\uDC5F\uD83E\uDD7E\uD83D\uDC5E\uD83D\uDC60\uD83D\uDC62\uD83E\uDD7F" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  ┌─────────────────────────────────────────────┐" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  │ " + AnsiColor.GREEN + "     Shoes Warehouse Management System " + AnsiColor.BLUE + "     │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  └─────────────────────────────────────────────┘" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "               1. 마이페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               2. 신발 조회 및 구매" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               3. 점장 메뉴" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               4. 관리자 메뉴" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "               0. 프로그램 종료" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.BLUE + " ─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─" + AnsiColor.RESET);


            System.out.print("""
                    > 입력:""");

            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    MyPage.myPage(userDto);
                    break;
                case "2":

                case "0":
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }
        }

    }
}
