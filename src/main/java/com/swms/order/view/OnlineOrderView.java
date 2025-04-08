package com.swms.order.view;

import com.swms.common.AnsiColor;
import com.swms.order.controller.OnlineOrderController;
import com.swms.order.model.dto.OnlineOrderStatsDto;
import com.swms.store.controller.OfflineSaleController;

import java.util.List;
import java.util.Scanner;

public class OnlineOrderView {
    OnlineOrderController onlineOrderController = new OnlineOrderController();
    private Scanner sc = new Scanner(System.in);
    private String message = null;


    public void onlineAllDailySales() {
        int page = 1;

        while (true) {
            List<OnlineOrderStatsDto> list = onlineOrderController.getOnlineDailyStats(page);

            if (list.isEmpty()) {
                if (page > 1) {
                    --page;
                    list = onlineOrderController.getOnlineDailyStats(page);
                    message = "⚠\uFE0F 마지막 페이지 입니다.";
                } else {
                    message = "⚠\uFE0F 판매 정보가 없습니다.";
                }
            }
            for (OnlineOrderStatsDto dto : list) {
                System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  📅 일별 : " + dto.getDate() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  🧾 총 판매 수량 : " + dto.getTotalQuantity() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  📦 총 매출액 : " + dto.getTotalRevenue() + AnsiColor.RESET);
                System.out.println();
            }
            System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "            🏪 온라인 일별 판매 내역입니다." + AnsiColor.RESET);
            System.out.println();
            if (message != null) {
                System.out.println(AnsiColor.BRIGHT_RED + "                " + message + AnsiColor.RESET);
                message = null;
            }
            System.out.println(AnsiColor.BRIGHT_YELLOW + "                현재 페이지 : " + page + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                1. 다음 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                2. 이전 페이지" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "                0. 뒤로 가기" + AnsiColor.RESET);

            System.out.print("""
                    > 입력:""");
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    page++;
                    break;
                case "2":
                    if (page == 1) {
                        message = "⚠\uFE0F 첫 페이지 입니다.";
                        break;
                    }
                    page--;
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }

        }

    }


    public void onlineAllMonthlySales() {
        int page = 1;

        while (true) {
            List<OnlineOrderStatsDto> list = onlineOrderController.getOnlineMonthlyStats(page);

            if (list.isEmpty()) {
                if (page > 1) {
                    --page;
                    list = onlineOrderController.getOnlineMonthlyStats(page);
                    message = "⚠\uFE0F 마지막 페이지 입니다.";
                } else {
                    message = "⚠\uFE0F 판매 정보가 없습니다.";
                }
            }
            for (OnlineOrderStatsDto dto : list) {
                System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  📅 월별 : " + dto.getDate() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  🧾 총 판매 수량 : " + dto.getTotalQuantity() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  📦 총 매출액 : " + dto.getTotalRevenue() + AnsiColor.RESET);
                System.out.println();
            }
            System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "            🏪 온라인 월별 판매 내역입니다." + AnsiColor.RESET);
            System.out.println();
            if (message != null) {
                System.out.println(AnsiColor.BRIGHT_RED + "                " + message + AnsiColor.RESET);
                message = null;
            }
            System.out.println(AnsiColor.BRIGHT_YELLOW + "                현재 페이지 : " + page + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                1. 다음 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                2. 이전 페이지" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "                0. 뒤로 가기" + AnsiColor.RESET);

            System.out.print("""
                    > 입력:""");
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    page++;
                    break;
                case "2":
                    if (page == 1) {
                        message = "⚠\uFE0F 첫 페이지 입니다.";
                        break;
                    }
                    page--;
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }

        }

    }


    public static void PurchaseFailedMoney(int available) {
        if (available == 1){
            // 구매불가
            // 마이페이지에서 금액을 충전해주세요
        }
    }

    public static void PurchaseFailedStock(int available) {
        if (available == 1){
            // 구매불가
            // 수량이 부족합니다.
        }
    }

    public static void displayShoesOrder(int result) {
        // 구매완료되었습니다.
        // 구매중 시스템 오류가 생겼습니다. 다시 진행해주세요
    }
}
