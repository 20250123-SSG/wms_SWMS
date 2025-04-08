package com.swms.warehouse.view;

import com.swms.common.AnsiColor;
import com.swms.warehouse.controller.OnlineWarehouseController;
import com.swms.warehouse.controller.PurchaseOrderController;
import com.swms.warehouse.model.dto.OfflineWarehouseDto;
import com.swms.warehouse.model.dto.OnlineWarehouseDto;
import com.swms.warehouse.model.dto.PurchaseOrderDto;

import java.util.List;
import java.util.Scanner;

public class PurchaseOrderView {
    private Scanner sc = new Scanner(System.in);
    private PurchaseOrderController purchaseOrderController = new PurchaseOrderController();
    private OnlineWarehouseController onlineWarehouseController = new OnlineWarehouseController();

    private String message = null;

    public void selectAllPurchaseOrder() {
        int page = 1;

        while (true) {
            List<PurchaseOrderDto> list = purchaseOrderController.selectAllPurchaseOrder(page);

            if (list.isEmpty()) {
                if (page > 1) {
                    --page;
                    list = purchaseOrderController.selectAllPurchaseOrder(page);
                    message = "⚠\uFE0F 마지막 페이지 입니다.";
                } else {
                    message = "⚠\uFE0F 발주 정보가 없습니다.";
                }
            }
            for (PurchaseOrderDto dto : list) {
                System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  🆔 발주 ID : " + dto.getPurchaseOrderId() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  🆔 신발 ID : " + dto.getShoesId() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  📝 발주 상태 : " + dto.getStatus() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  🏪 매장 : " + dto.getStoreName() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  👟 모델명 : " + dto.getShoesName() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  🏷️ 브랜드 : " + dto.getBrandName() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  🧩 종류 : " + dto.getShoesType() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  📏 사이즈 : " + dto.getSize() + AnsiColor.RESET);
                System.out.println(AnsiColor.BRIGHT_WHITE + "  📦 수량 : " + dto.getQuantity() + AnsiColor.RESET);
                System.out.println();

            }
            System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
            if (message != null) {
                System.out.println(AnsiColor.BRIGHT_RED + "                " + message + AnsiColor.RESET);
                message = null;
            }
            System.out.println(AnsiColor.BRIGHT_YELLOW + "                현재 페이지 : " + page + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                1. 다음 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                2. 이전 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                3. 발주 승인" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                4. 발주 취소" + AnsiColor.RESET);
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
                    approvePurchaseOrder();
                    break;
                case "4":
                    rejectPurchaseOrder();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }

        }

    }

    public void approvePurchaseOrder() {
        int purchaseOrderId;
        PurchaseOrderDto purchaseOrderDto;

        while (true) {
            System.out.println(AnsiColor.GREEN + "승인할 발주 ID를 입력하세요" + AnsiColor.RESET);
            System.out.print("""
                    > 입력:""");
            purchaseOrderId = sc.nextInt();
            sc.nextLine(); // 줄바꿈 제거용


            purchaseOrderDto = purchaseOrderController.selectWarehouseById(purchaseOrderId);

            if (purchaseOrderDto == null) {
                System.out.println(AnsiColor.RED + "존재하지 않는 발주 ID 입니다. 다시 입력해주세요." + AnsiColor.RESET);
                continue;
            }

            if (!purchaseOrderDto.getStatus().equals("승인요청")) {
                message = "이미 처리된 발주 입니다.";
            }

            OnlineWarehouseDto onlineWarehouseDto = onlineWarehouseController.selectWarehouseByShoesId(purchaseOrderDto.getShoesId());
            System.out.println(AnsiColor.GREEN + "온라인 창고 수량 : " + onlineWarehouseDto.getQuantity() + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "발주 요청 수량 : " + purchaseOrderDto.getQuantity() + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "✅ 승인은 Y, 보류는 아무 키나 입력하세요." + AnsiColor.RESET);
            System.out.print("> 입력: ");
            String approve = sc.nextLine().trim();

            if (approve.equalsIgnoreCase("Y")) {
                // 승인
                int result;
                if (purchaseOrderDto.getQuantity() > onlineWarehouseDto.getQuantity()) {
                    message = "온라인 창고 보유수량 보다 많은 발주는 승인 할 수 없습니다.";
                    break;
                } else {
                    result = purchaseOrderController.approvePurchaseOrder(purchaseOrderDto, onlineWarehouseDto);
                }

                if (result == 1) {
                    message = "발주 승인이 완료 되었습니다.";
                    break;
                } else {
                    message = "발주 승인이 실패 되었습니다.";
                }
            } else {
                // 보류
                message = "발주 승인이 취소 되었습니다.";
                break;
            }

        }
    }

    public void rejectPurchaseOrder() {
        int purchaseOrderId;
        PurchaseOrderDto purchaseOrderDto;

        while (true) {
            System.out.println(AnsiColor.GREEN + "취소할 발주 ID를 입력하세요" + AnsiColor.RESET);
            System.out.print("""
                    > 입력:""");
            purchaseOrderId = sc.nextInt();
            sc.nextLine(); // 줄바꿈 제거용


            purchaseOrderDto = purchaseOrderController.selectWarehouseById(purchaseOrderId);

            if (purchaseOrderDto == null) {
                System.out.println(AnsiColor.RED + "존재하지 않는 발주 ID 입니다. 다시 입력해주세요." + AnsiColor.RESET);
                continue;
            }

            if (!purchaseOrderDto.getStatus().equals("승인요청")) {
                message = "이미 처리된 발주 입니다.";
                break;
            }

            int result = purchaseOrderController.rejectPurchaseOrder(purchaseOrderDto);

            if (result == 1) {
                message = "발주가 취소 완료 되었습니다.";
                break;
            } else {
                message = "발주 취소가 실패 되었습니다.";
            }
        }
    }
}
