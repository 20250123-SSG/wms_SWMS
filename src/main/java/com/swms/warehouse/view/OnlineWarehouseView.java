package com.swms.warehouse.view;

import com.swms.common.AnsiColor;
import com.swms.warehouse.controller.OnlineWarehouseController;
import com.swms.warehouse.model.dto.OnlineWarehouseDto;

import java.util.List;
import java.util.Scanner;

import static com.swms.common.util.ConsoleAlignUtil.*;

public class OnlineWarehouseView {
    private Scanner sc = new Scanner(System.in);
    private OnlineWarehouseController onlineWarehouseController = new OnlineWarehouseController();

    private String message = null;

    public void selectAllPurchaseOrder() {
        int page = 1;

        while (true) {
            List<OnlineWarehouseDto> list = onlineWarehouseController.selectOnlineWarehouse(page);

            if (list.isEmpty()) {
                if (page > 1) {
                    --page;
                    list = onlineWarehouseController.selectOnlineWarehouse(page);
                    message = "⚠\uFE0F 마지막 페이지 입니다.";
                } else {
                    message = "⚠\uFE0F 온라인 창고 정보가 없습니다.";
                }
            }
            String format = AnsiColor.BRIGHT_WHITE + "🆔 %-5s 🏷️ %-8s 🧩 %-8s   📏 %-6s 📦 %-6s 👟 %s" + AnsiColor.RESET + "\n";

            System.out.printf(AnsiColor.BRIGHT_BLUE +
                    "🆔 ID     🏷️ 브랜드      🧩 종류         📏 사이즈  📦 수량   👟 모델명\n" +
                    "────────────────────────────────────────────────────────────────────────────\n" +
                    AnsiColor.RESET);

            for (OnlineWarehouseDto dto : list) {
                System.out.printf(format,
                        dto.getOnlineWarehouseId(),
                        padRight(dto.getBrandName(), 12),
                        padRight(dto.getShoesType(), 10),
                        dto.getSize(),
                        dto.getQuantity(),
                        dto.getShoesName());
            }
            System.out.println(AnsiColor.BRIGHT_BLUE + " ────────────────────────────────────────────────────────────────────────────\n" + AnsiColor.RESET);
            if (message != null) {
                System.out.println(AnsiColor.BRIGHT_RED + "                " + message + AnsiColor.RESET);
                message = null;
            }
            System.out.println(AnsiColor.BRIGHT_YELLOW + "                현재 페이지 : " + page + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                1. 다음 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                2. 이전 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                3. 재고 추가" + AnsiColor.RESET);
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
                case "3":
                    updateQuantity();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }

        }
    }

    public void updateQuantity() {
        int warehouseId;
        OnlineWarehouseDto onlineWarehouseDto;

        while (true) {
            System.out.println(AnsiColor.GREEN + "재고 추가할 창고 ID를 입력하세요" + AnsiColor.RESET);
            System.out.print("""
                    > 입력:""");
            warehouseId = sc.nextInt();
            sc.nextLine(); // 줄바꿈 제거용

            onlineWarehouseDto = onlineWarehouseController.existsWarehouseById(warehouseId);

            if (onlineWarehouseDto == null) {
                System.out.println(AnsiColor.RED + "존재하지 않는 창고 ID 입니다. 다시 입력해주세요." + AnsiColor.RESET);
                continue;
            }

            System.out.println(AnsiColor.GREEN + "현재 수량 : " + onlineWarehouseDto.getQuantity() + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "재고 추가할 수량을 입력하세요" + AnsiColor.RESET);

            System.out.print("""
                    > 입력:""");
            int quantity = sc.nextInt();
            sc.nextLine(); // 줄바꿈 제거용
            onlineWarehouseDto.setQuantity(quantity);

            // 발주 등록
            int result = onlineWarehouseController.updateAddQuantity(onlineWarehouseDto);

            if (result == 1) {
                message = "재고 추가 등록을 완료 되었습니다.";
                break;
            } else {
                message = "재고 추가 등록이 실패 되었습니다.";
            }
        }
    }
}
