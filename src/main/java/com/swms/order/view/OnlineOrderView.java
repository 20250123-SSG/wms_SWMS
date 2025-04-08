package com.swms.order.view;

public class OnlineOrderView {
    public static void displayInsertOnlineOrder(int result) {

    }

    public static void displayCheckWarehouseStock(int quantity) {
    }

    public static void displayShoesOrderMoney(int available) {

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
