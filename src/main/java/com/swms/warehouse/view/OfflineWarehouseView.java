package com.swms.warehouse.view;


import com.swms.common.AnsiColor;
import com.swms.run.page.AdminPage;
import com.swms.run.page.MyPage;
import com.swms.run.page.StoreManagerPage;
import com.swms.warehouse.controller.OfflineWarehouseController;
import com.swms.warehouse.model.dto.OfflineWarehouseDto;

import java.util.List;
import java.util.Scanner;

public class OfflineWarehouseView {

    private Scanner sc = new Scanner(System.in);
    private OfflineWarehouseController offlineWarehouseController = new OfflineWarehouseController();

    public void offlineWarehouse(int storeId){
        int page = 1;
        String message = null;

        while (true) {
            List<OfflineWarehouseDto> list = offlineWarehouseController.selectAllStoreWarehouse(page, storeId);

            if (list.isEmpty()) {
                if(page > 1){
                    --page;
                    message = "⚠\uFE0F 마지막 페이지 입니다.";
                }else {
                    message = "⚠\uFE0F 해당 매장의 창고 정보가 없습니다.";
                }
            } else {
                for (OfflineWarehouseDto dto : list) {
                    System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
                    System.out.println(AnsiColor.BRIGHT_WHITE + "  🆔 창고 ID : " + dto.getOfflineWarehouseId() + AnsiColor.RESET);
                    System.out.println(AnsiColor.BRIGHT_WHITE + "  👟 모델명 : " + dto.getShoesName() + AnsiColor.RESET);
                    System.out.println(AnsiColor.BRIGHT_WHITE + "  🏷️ 브랜드 : " + dto.getBrandName() + AnsiColor.RESET);
                    System.out.println(AnsiColor.BRIGHT_WHITE + "  🧩 종류 : " + dto.getShoesType() + AnsiColor.RESET);
                    System.out.println(AnsiColor.BRIGHT_WHITE + "  📏 사이즈 : " + dto.getSize() + AnsiColor.RESET);
                    System.out.println(AnsiColor.BRIGHT_WHITE + "  📦 수량 : " + dto.getQuantity() + AnsiColor.RESET);
                    System.out.println();
                }
            }
            System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
            if (message != null) {
                System.out.println(AnsiColor.BRIGHT_RED + "                " + message + AnsiColor.RESET);
                message = null;
            }
            System.out.println(AnsiColor.BRIGHT_YELLOW + "                현재 페이지 : " + page + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                1. 다음 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                2. 이전 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                3. 상품 발주" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                4. 판매 하기" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "                0. 뒤로 가기" + AnsiColor.RESET);

            System.out.print("""
                    > 입력:""");
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    page ++;
                    break;
                case "2":
                    if(page == 1){
                        message = "⚠\uFE0F 첫 페이지 입니다.";
                        break;
                    }
                    page --;
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }

        }
    }
}
