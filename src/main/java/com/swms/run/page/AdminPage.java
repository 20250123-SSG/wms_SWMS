package com.swms.run.page;

import com.swms.common.AnsiColor;
import com.swms.common.Logo;
import com.swms.order.view.OnlineOrderView;
import com.swms.store.view.OfflineSaleView;
import com.swms.user.model.dto.UserDto;
import com.swms.shoes.view.ShoesManagementView;
import com.swms.warehouse.view.OnlineWarehouseView;
import com.swms.warehouse.view.PurchaseOrderView;

import java.util.Scanner;

public class AdminPage {
    private static Scanner sc = new Scanner(System.in);
    private static ShoesManagementView shoesManagementView = new ShoesManagementView();
    private static PurchaseOrderView purchaseOrderView = new PurchaseOrderView();
    private static OnlineWarehouseView onlineWarehouseView = new OnlineWarehouseView();
    private static OfflineSaleView offlineSaleView = new OfflineSaleView();
    private static OnlineOrderView onlineOrderView = new OnlineOrderView();


    public static String adminPage(UserDto userDto) {
        if(userDto.getAuth() != 0){
            return "관리자 권한이 없어 접속 권한이 없습니다.";
        }
        while (true) {
            Logo.printLogo();
            System.out.println(AnsiColor.BLUE + "  ┌─────────────────────────────────────────────┐" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  │ " + AnsiColor.GREEN + "     Shoes Warehouse Management System " + AnsiColor.BLUE + "     │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  └─────────────────────────────────────────────┘" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "               1. 상품 등록 / 수정" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               2. 온라인 창고 확인" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               3. 발주 요청 확인" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               4. 온라인 일별 매출 확인" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               5. 온라인 월별 매출 확인" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               6. 오프라인 일별 매출 확인" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               7. 오프라인 월별 매출 확인" + AnsiColor.RESET);
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
                    onlineWarehouseView.selectAllPurchaseOrder();
                    break;
                case "3":
                    purchaseOrderView.selectAllPurchaseOrder();
                    break;
                case "4":
                    onlineOrderView.onlineAllDailySales();
                    break;
                case "5":
                    onlineOrderView.onlineAllMonthlySales();
                    break;
                case "6":
                    offlineSaleView.offlineAllDailySales();
                    break;
                case "7":
                    offlineSaleView.offlineAllMonthlySales();
                    break;
                case "0":
                    return null;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }
        }

    }
}
