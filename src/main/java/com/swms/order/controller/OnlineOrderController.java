package com.swms.order.controller;

import com.swms.order.model.service.OnlineOrderService;
import com.swms.order.view.OnlineOrderView;
import com.swms.shoes.model.dto.ShoesDto;

import com.swms.user.model.dto.UserDto;


public class OnlineOrderController {
    private OnlineOrderService onlineOrderService = new OnlineOrderService();

    // ✅ 월별 매출 조회
    public void offlineMonthlySales() {
        // 예시: 2025년 4월 매출 총합 등
        // 로직은 나중에 구현
    }

    // ✅ 일별 매출 조회
    public void offlineDailySales() {
        // 예시: 2025-04-07 매출 내역
        // 로직은 나중에 구현
    }


    public void orderPrint(UserDto userDto, ShoesDto shoesDto) {
        // 주문서 출력하는 뷰
    }

    //온라인 주문 서비스 (트랜젝션처리완)
    public void onlineOrder(UserDto user, ShoesDto shoes) {
        int result = onlineOrderService.onlineOrder(user, shoes);
        OnlineOrderView.displayShoesOrder(result);
    }

    // 금액체크
    public void checkMoney(UserDto user, ShoesDto shoes){
        int available =  (user.getMoney() >= shoes.getShoesPrice()*shoes.getQuantity()) ? 0 : 1;
        OnlineOrderView.PurchaseFailedMoney(available); // 구매불가 : 1
        if(available == 1){
            // 시작페이지로
        }
    }
    public void checkWarehouseStock(UserDto user, ShoesDto shoes) {
        int quantity = onlineOrderService.checkWarehouseStock(shoes);
        int available = (quantity > shoes.getQuantity()) ? 0 : 1;
        OnlineOrderView.PurchaseFailedStock(available);
        if (available == 1) {
            // 조회페이지로
        }
    }

}
