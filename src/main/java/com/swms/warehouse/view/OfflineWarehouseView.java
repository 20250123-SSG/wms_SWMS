package com.swms.warehouse.view;


import com.swms.common.AnsiColor;
import com.swms.store.controller.OfflineSaleController;
import com.swms.warehouse.controller.OfflineWarehouseController;
import com.swms.warehouse.controller.PurchaseOrderController;
import com.swms.warehouse.model.dto.OfflineWarehouseDto;

import java.util.List;
import java.util.Scanner;

import static com.swms.common.util.ConsoleAlignUtil.padRight;

public class OfflineWarehouseView {

    private Scanner sc = new Scanner(System.in);
    private OfflineWarehouseController offlineWarehouseController = new OfflineWarehouseController();
    private PurchaseOrderController purchaseOrderController = new PurchaseOrderController();
    private OfflineSaleController offlineSaleController = new OfflineSaleController();
    private String message = null;

    public void offlineWarehouse(int storeId) {
        int page = 1;

        while (true) {
            List<OfflineWarehouseDto> list = offlineWarehouseController.selectAllStoreWarehouse(page, storeId);

            if (list.isEmpty()) {
                if (page > 1) {
                    --page;
                    list = offlineWarehouseController.selectAllStoreWarehouse(page, storeId);
                    message = "⚠\uFE0F 마지막 페이지 입니다.";
                } else {
                    message = "⚠\uFE0F 해당 매장의 창고 정보가 없습니다.";
                }
            }
            String format = AnsiColor.BRIGHT_WHITE + "🆔 %-5s 🏷️ %-8s 🧩 %-10s 📏 %-6s 📦 %-6s 👟 %s" + AnsiColor.RESET + "\n";

            System.out.printf(AnsiColor.BRIGHT_BLUE +
                    "\n🆔 ID     🏷️ 브랜드      🧩 종류         📏 사이즈  📦 수량   👟 모델명\n" +
                    "────────────────────────────────────────────────────────────────────────────\n" +
                    AnsiColor.RESET);

            for (OfflineWarehouseDto dto : list) {
                System.out.printf(format,
                        dto.getOfflineWarehouseId(),
                        padRight(dto.getBrandName(), 12),
                        padRight(dto.getShoesType(), 12),
                        dto.getSize(),
                        dto.getQuantity(),
                        dto.getShoesName());
            }

            System.out.println(AnsiColor.BRIGHT_BLUE +
                    "────────────────────────────────────────────────────────────────────────────\n" +
                    AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
            if (message != null) {
                System.out.println(AnsiColor.BRIGHT_RED + "                " + message + AnsiColor.RESET);
                message = null;
            }
            System.out.println(AnsiColor.BRIGHT_YELLOW + "                현재 페이지 : " + page + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                1. 다음 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                2. 이전 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                3. 상품 발주" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                4. 판매 등록" + AnsiColor.RESET);
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
                    createPurchaseOrder();
                    break;
                case "4":
                    createSale();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }

        }

    }

    public void createPurchaseOrder() {
        int warehouseId;
        OfflineWarehouseDto offlineWarehouseDto;

        while (true) {
            System.out.println(AnsiColor.GREEN + "발주 등록할 창고 ID를 입력하세요" + AnsiColor.RESET);
            System.out.print("""
                    > 입력:""");
            warehouseId = sc.nextInt();
            sc.nextLine(); // 줄바꿈 제거용

            offlineWarehouseDto = offlineWarehouseController.existsWarehouseById(warehouseId);

            if (offlineWarehouseDto == null) {
                System.out.println(AnsiColor.RED + "존재하지 않는 창고 ID 입니다. 다시 입력해주세요." + AnsiColor.RESET);
                continue;
            }


            System.out.println(AnsiColor.GREEN + "현재 수량 : " + offlineWarehouseDto.getQuantity() + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "발주할 수량을 입력하세요" + AnsiColor.RESET);

            System.out.print("""
                    > 입력:""");
            int quantity = sc.nextInt();
            sc.nextLine(); // 줄바꿈 제거용

            // 발주 등록
            int result = purchaseOrderController.createPurchaseOrder(
                    offlineWarehouseDto.getStoreId(), offlineWarehouseDto.getShoesId(), quantity);

            if (result == 1) {
                message = "발주 등록이 완료 되었습니다.";
                break;
            } else {
                message = "발주 등록이 실패 되었습니다.";
            }
        }
    }

    public void createSale() {
        int warehouseId;
        int saleQuantity;
        OfflineWarehouseDto offlineWarehouseDto;

        while (true) {
            System.out.println(AnsiColor.GREEN + "판매 처리할 창고 ID를 입력하세요" + AnsiColor.RESET);
            System.out.print("""
                    > 입력:""");
            warehouseId = sc.nextInt();
            sc.nextLine(); // 줄바꿈 제거용

            offlineWarehouseDto = offlineWarehouseController.existsWarehouseById(warehouseId);

            if (offlineWarehouseDto == null) {
                System.out.println(AnsiColor.RED + "존재하지 않는 창고 ID 입니다. 다시 입력해주세요." + AnsiColor.RESET);
            } else {
                break;
            }
        }

        while (true) {
            System.out.println(AnsiColor.GREEN + "현재 수량 : " + offlineWarehouseDto.getQuantity() + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "판매할 수량을 입력하세요" + AnsiColor.RESET);

            System.out.print("""
                    > 입력:""");
            saleQuantity = sc.nextInt();
            sc.nextLine(); // 줄바꿈 제거용

            if (saleQuantity > offlineWarehouseDto.getQuantity()) {
                System.out.println(AnsiColor.RED + "보유 수량 초과 판매 할 수 없습니다." + AnsiColor.RESET);
            } else {
                int result = offlineSaleController.processSale(
                        offlineWarehouseDto, saleQuantity);

                if (result == 1) {
                    message = "판매 등록이 완료 되었습니다.";
                } else {
                    message = "판매 등록이 실패 되었습니다.";
                }
                break;
            }


        }

        // 판매 등록


    }

}
