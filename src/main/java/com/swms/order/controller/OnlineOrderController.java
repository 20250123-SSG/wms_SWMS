package com.swms.order.controller;

import com.swms.common.AnsiColor;
import com.swms.order.model.dto.OnlineOrderStatsDto;
import com.swms.order.model.service.OnlineOrderService;
import com.swms.order.view.OnlineOrderView;
import com.swms.shoes.model.dto.ShoesDto;

import com.swms.user.model.dto.UserDto;

import java.util.List;


public class OnlineOrderController {
    private OnlineOrderService onlineOrderService = new OnlineOrderService();

    public List<OnlineOrderStatsDto> getOnlineDailyStats(int page) {
        return onlineOrderService.getOnlineDailyStats(page);
    }

    public List<OnlineOrderStatsDto> getOnlineMonthlyStats(int page) {
        return onlineOrderService.getOnlineMonthlyStats(page);
    }


    public void orderPrint(UserDto userDto, ShoesDto shoesDto) {
        // 주문서 출력하는 뷰
    }

    //온라인 주문 서비스 (트랜젝션처리완)
    public void onlineOrder(UserDto user, ShoesDto shoes, int buyQuantity) {
        int result = onlineOrderService.onlineOrder(user, shoes, buyQuantity);
        OnlineOrderView.displayShoesOrder(result);
    }

    // 금액체크
    public int checkMoney(UserDto user, int price, int quantity){
        int available =  (user.getMoney() >= price * quantity) ? 1 : 0;
        OnlineOrderView.PurchaseFailedMoney(available); //

        return available;
    }

}
