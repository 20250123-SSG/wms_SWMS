package com.swms.run.page;

import com.swms.common.AnsiColor;
import com.swms.common.Logo;
import com.swms.user.model.dto.UserDto;
import com.swms.shoes.view.ShoesManagementView;
import com.swms.warehouse.view.PurchaseOrderView;

import java.util.Scanner;

public class AdminPage {
    private static Scanner sc = new Scanner(System.in);
    private static ShoesManagementView shoesManagementView = new ShoesManagementView();
    private static PurchaseOrderView purchaseOrderView = new PurchaseOrderView();

    public static String adminPage(UserDto userDto) {
        if(userDto.getAuth() != 0){
            return "접속 권한이 없습니다.";
        }
        while (true) {
            Logo.printLogo();
            System.out.println(AnsiColor.BLUE + "  ┌─────────────────────────────────────────────┐" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  │ " + AnsiColor.GREEN + "     Shoes Warehouse Management System " + AnsiColor.BLUE + "     │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  └─────────────────────────────────────────────┘" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "               1. 상품 등록 / 수정" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               2. 발주 요청 확인" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               3. 전체 매출 확인" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               4. 온라인 매출 확인" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               5. 지점별 매출 확인" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "               0. 뒤로가기" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.BLUE + " ─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─" + AnsiColor.RESET);
            System.out.print("""
                    > 입력:""");

            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    shoesManagementView.ShoesManagementView();
                    break;
                case "2":
                    purchaseOrderView.selectAllPurchaseOrder();
                    break;
                case "0":
                    return null;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }
        }

    }
}
