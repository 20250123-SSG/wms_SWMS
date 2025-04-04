package com.swms.run.page;

import com.swms.common.AnsiColor;
import com.swms.common.Logo;
import com.swms.user.model.dto.UserDto;

import java.util.Scanner;

public class StoreManagerPage {
    private static Scanner sc = new Scanner(System.in);

    public static void storeMangerPage(UserDto userDto) {
        if(userDto.getUserId() == 1){
            System.out.println(AnsiColor.BRIGHT_RED + "   접속 권한이 없습니다.");
            return;
        }

        while (true) {
            Logo.printLogo();
            System.out.println(AnsiColor.BLUE + "  ┌─────────────────────────────────────────────┐" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  │ " + AnsiColor.GREEN + "     Shoes Warehouse Management System " + AnsiColor.BLUE + "     │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  └─────────────────────────────────────────────┘" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "               1. 상품 재고" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               2. 상품 입고" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               3. 판매 하기" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               4. 매출 확인" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "               0. 뒤로가기" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.BLUE + " ─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─" + AnsiColor.RESET);


            System.out.print("""
                    > 입력:""");

            String menu = sc.nextLine();
            switch (menu) {
                case "1":
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
