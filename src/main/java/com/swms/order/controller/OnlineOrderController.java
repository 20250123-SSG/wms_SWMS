package com.swms.order.controller;

import com.swms.order.model.dto.OnlineOrderDetailDto;
import com.swms.order.model.dto.OnlineOrderDto;
import com.swms.order.model.service.OnlineOrderService;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesOrderDto;
import com.swms.shoes.model.dto.ShoesSelectDto;
import com.swms.shoes.view.ShoesResultView;
import com.swms.user.model.dto.UserDto;
import com.swms.order.view.OnlineOrderView;

import java.util.List;
import java.util.Map;


public class OnlineOrderController {
    private OnlineOrderService onlineOrderService = new OnlineOrderService();


    public void orderPrint(UserDto userDto, ShoesDto shoesDto) {
        // 주문서 출력하는 뷰
    }

    //온라인 주문 서비스 (트랜젝션처리완)
    public void onlineOrder(UserDto user, ShoesDto shoes) {
        int result = onlineOrderService.onlineOrder(user, shoes);
        ShoesResultView.displayShoesOrder(result);
    }

}
