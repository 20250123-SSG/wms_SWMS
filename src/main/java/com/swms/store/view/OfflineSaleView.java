package com.swms.store.view;

import com.swms.common.AnsiColor;
import com.swms.store.controller.OfflineSaleController;
import com.swms.store.model.dto.OfflineSaleDto;
import com.swms.store.model.dto.OfflineSaleStatsDto;
import com.swms.store.model.dto.StoreDto;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static com.swms.common.util.ConsoleAlignUtil.padRight;

public class OfflineSaleView {
    private Scanner sc = new Scanner(System.in);
    private OfflineSaleController offlineSaleController = new OfflineSaleController();
    private String message = null;

    public void selectAllOfflineSale(StoreDto storeDto) {
        int page = 1;
        int storeId = storeDto.getStoreId();

        while (true) {
            List<OfflineSaleDto> list = offlineSaleController.selectOfflineSaleByStoreId(page, storeId);

            if (list.isEmpty()) {
                if (page > 1) {
                    --page;
                    list = offlineSaleController.selectOfflineSaleByStoreId(page, storeId);
                    message = "⚠\uFE0F 마지막 페이지 입니다.";
                } else {
                    message = "⚠\uFE0F 발주 정보가 없습니다.";
                }
            }
            String format = AnsiColor.BRIGHT_WHITE +
                    "🆔 %-5s 🧾 %-16s 📦 %-4s 👟 %-15s 🏷️ %-8s 🧩 %-10s 📏 %-4s" +
                    AnsiColor.RESET + "\n";

            System.out.printf(AnsiColor.BRIGHT_BLUE +
                    "\n🆔 판매ID  🧾 판매날짜         📦 수량 👟 모델명           🏷️ 브랜드   🧩 종류        📏 사이즈\n" +
                    "────────────────────────────────────────────────────────────────────────────────────────────\n" +
                    AnsiColor.RESET);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            for (OfflineSaleDto dto : list) {
                System.out.printf(format,
                        dto.getOfflineSaleId(),
                        dto.getSaleDate().format(formatter),
                        dto.getQuantity(),
                        padRight(dto.getShoesName(), 15),
                        padRight(dto.getBrandName(), 8),
                        padRight(dto.getShoesType(), 10),
                        dto.getSize()
                );
            }
            System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  🏪 매장 : " + storeDto.getStoreName() + " 의 판매 내역입니다." + AnsiColor.RESET);
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


    public void offlineDailySales(StoreDto storeDto) {
        int page = 1;
        int storeId = storeDto.getStoreId();

        while (true) {
            List<OfflineSaleStatsDto> list = offlineSaleController.offlineDailySales(storeId, page);

            if (list.isEmpty()) {
                if (page > 1) {
                    --page;
                    list = offlineSaleController.offlineDailySales(storeId, page);
                    message = "⚠\uFE0F 마지막 페이지 입니다.";
                } else {
                    message = "⚠\uFE0F 판매 정보가 없습니다.";
                }
            }
            for (OfflineSaleStatsDto dto : list) {
                System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  📅 일별 : " + dto.getDate() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  🧾 총 판매 수량 : " + dto.getTotalQuantity() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  📦 총 매출액 : " + dto.getTotalRevenue() + AnsiColor.RESET);
                System.out.println();
            }
            System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  🏪 매장 : " + storeDto.getStoreName() + " 일별 판매 내역입니다." + AnsiColor.RESET);
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


    public void offlineMonthlySales(StoreDto storeDto) {
        int page = 1;
        int storeId = storeDto.getStoreId();

        while (true) {
            List<OfflineSaleStatsDto> list = offlineSaleController.offlineMonthlySales(storeId, page);

            if (list.isEmpty()) {
                if (page > 1) {
                    --page;
                    list = offlineSaleController.offlineMonthlySales(storeId, page);
                    message = "⚠\uFE0F 마지막 페이지 입니다.";
                } else {
                    message = "⚠\uFE0F 판매 정보가 없습니다.";
                }
            }
            String format = AnsiColor.BRIGHT_WHITE +
                    "📅 %-10s 🧾 %-10s 📦 %s" +
                    AnsiColor.RESET + "\n";

            System.out.printf(AnsiColor.BRIGHT_BLUE +
                    "\n📅 월별       🧾 총 판매 수량     📦 총 매출액\n" +
                    "──────────────────────────────────────────────\n" +
                    AnsiColor.RESET);

            for (OfflineSaleStatsDto dto : list) {
                System.out.printf(format,
                        dto.getDate(), // 예: "2025-04"
                        dto.getTotalQuantity(),
                        dto.getTotalRevenue() + "원"
                );
            }

            System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  🏪 매장 : " + storeDto.getStoreName() + " 월별 판매 내역입니다." + AnsiColor.RESET);
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

public void offlineAllDailySales() {
    int page = 1;
    Integer storeId = null;

    while (true) {
        List<OfflineSaleStatsDto> list = offlineSaleController.offlineDailySales(storeId, page);

        if (list.isEmpty()) {
            if (page > 1) {
                --page;
                list = offlineSaleController.offlineDailySales(storeId, page);
                message = "⚠\uFE0F 마지막 페이지 입니다.";
            } else {
                message = "⚠\uFE0F 판매 정보가 없습니다.";
            }
        }
        String format = AnsiColor.BRIGHT_WHITE +
                "📅 %-10s 🧾 %-10s 📦 %s" +
                AnsiColor.RESET + "\n";

        System.out.printf(AnsiColor.BRIGHT_BLUE +
                "\n📅 일별       🧾 총 판매 수량     📦 총 매출액\n" +
                "──────────────────────────────────────────────\n" +
                AnsiColor.RESET);

        for (OfflineSaleStatsDto dto : list) {
            System.out.printf(format,
                    dto.getDate(), // 예: "2025-04"
                    dto.getTotalQuantity(),
                    dto.getTotalRevenue() + "원"
            );
        }

        System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "            🏪 일별 판매 내역입니다." + AnsiColor.RESET);
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


    public void offlineAllMonthlySales() {
        int page = 1;
        Integer storeId = null;

        while (true) {
            List<OfflineSaleStatsDto> list = offlineSaleController.offlineMonthlySales(storeId, page);

            if (list.isEmpty()) {
                if (page > 1) {
                    --page;
                    list = offlineSaleController.offlineMonthlySales(storeId, page);
                    message = "⚠\uFE0F 마지막 페이지 입니다.";
                } else {
                    message = "⚠\uFE0F 판매 정보가 없습니다.";
                }
            }
            String format = AnsiColor.BRIGHT_WHITE +
                    "📅 %-10s 🧾 %-10s 📦 %s" +
                    AnsiColor.RESET + "\n";

            System.out.printf(AnsiColor.BRIGHT_BLUE +
                    "\n📅 월별       🧾 총 판매 수량     📦 총 매출액\n" +
                    "──────────────────────────────────────────────\n" +
                    AnsiColor.RESET);

            for (OfflineSaleStatsDto dto : list) {
                System.out.printf(format,
                        dto.getDate(), // 예: "2025-04"
                        dto.getTotalQuantity(),
                        dto.getTotalRevenue() + "원"
                );
            }

            System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "            🏪 월별 판매 내역입니다." + AnsiColor.RESET);
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


}
