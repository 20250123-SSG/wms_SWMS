package com.swms.run.page;

import com.swms.common.AnsiColor;
import com.swms.common.Logo;
import com.swms.store.controller.StoreController;
import com.swms.store.model.dto.StoreDto;
import com.swms.store.model.service.StoreService;
import com.swms.user.model.dto.UserDto;
import com.swms.warehouse.view.OfflineWarehouseView;

import java.util.Scanner;

public class StoreManagerPage {
    private static Scanner sc = new Scanner(System.in);
    private static OfflineWarehouseView offlineWarehouseView = new OfflineWarehouseView();

    public static void storeMangerPage(UserDto userDto) {
        if(userDto.getAuth() != 2){
            System.out.println(AnsiColor.BRIGHT_RED + "  점장만 접속 가능합니다.");
            return;
        }

        StoreController storeController = new StoreController();
        StoreDto storeDto = storeController.getStoreByUserId(userDto.getUserId());

        while (true) {
            Logo.printLogo();
            System.out.println(AnsiColor.BLUE + "  ┌─────────────────────────────────────────────┐" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  │ " + AnsiColor.GREEN + "     Shoes Warehouse Management System " + AnsiColor.BLUE + "     │" + AnsiColor.RESET);
            System.out.println(AnsiColor.BLUE + "  └─────────────────────────────────────────────┘" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_CYAN + " ─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  🏪 매장 이름 : " + storeDto.getStoreName() + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  🆔 매장 ID : " + storeDto.getStoreId() + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  📞 매장 전화 : " + storeDto.getStorePhone() + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  📍 매장 주소 : " + storeDto.getStoreAddress() + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_CYAN + " ─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "               1. 상품 재고" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               2. 매출 확인" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "               3. 판매 내역" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "               0. 뒤로가기" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.BLUE + " ─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─=─" + AnsiColor.RESET);


            System.out.print("""
                    > 입력:""");

            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    offlineWarehouseView.offlineWarehouse(storeDto.getStoreId());
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }
        }

    }
}
