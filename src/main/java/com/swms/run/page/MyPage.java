package com.swms.run.page;

import com.swms.common.AnsiColor;
import com.swms.common.Logo;
import com.swms.user.model.dto.UserDto;
import com.swms.user.view.AccountView;
import com.swms.user.view.UserView;

import java.util.Scanner;

public class MyPage {
    private static UserView userView = new UserView();
    private static Scanner sc = new Scanner(System.in);

    public static void myPage(UserDto userDto) {
        while (true) {
            Logo.printLogo();
            System.out.println(AnsiColor.BLUE + "  ┌─────────────────────────────────────────────┐" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  │ " + AnsiColor.GREEN + "                 My page               " + AnsiColor.BLUE + "     │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  └─────────────────────────────────────────────┘" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_PURPLE + " ─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  🏷️ 이름 : " + userDto.getUserName() + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  🛡️ 권한 : " + userDto.getAuth() + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  🏠 주소 : " + userDto.getAddress() + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  📞 전화번호 : " + userDto.getPhone() + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  💰 금액 : " + userDto.getMoney() + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_PURPLE + " ─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "                1. 주소 수정" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                2. 전화번호 수정" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                3. 돈 충전하기" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                4. 장바구니 조회" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                5. 좋아요 조회" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "                0. 뒤로 가기" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.BLUE + " ─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─" + AnsiColor.RESET);
            System.out.print("""
                    > 입력:""");
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    userView.updateAddress(userDto);
                    break;
                case "2":
                    break;
                case "3":
                    userView.updateMoney(userDto);
                    break;
                case "4":
                    break;
                case "0":
                    System.out.println("뒤로 갑니다.");
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }
        }


    }
}
