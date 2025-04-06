package com.swms.order.controller;

import com.swms.order.model.dto.OnlineOrderDetailDto;
import com.swms.order.model.dto.OnlineOrderDto;
import com.swms.order.model.service.OnlineOrderService;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesOrderDto;
import com.swms.user.model.dto.UserDto;
import com.swms.order.view.OnlineOrderView;


public class OnlineOrderController {
    private OnlineOrderService onlineOrderService = new OnlineOrderService();

    public void insertOnlineOrder(UserDto user, ShoesDto shoes){
        OnlineOrderDto order = OnlineOrderDto.builder()
                .userId(user.getUserId())
                .totalPrice(shoes.getShoesPrice())
                .size(shoes.getSize())
                .build();
        int result = onlineOrderService.insertOnlineOrder(order);

        OnlineOrderDetailDto orderDetail = OnlineOrderDetailDto.builder()
                .orderId(order.getOrderId())
                .shoesId(shoes.getShoesId())
                .quantity(1)
                .build();

        int result2 = onlineOrderService.insertOnlineOrderDetail(orderDetail);
        if(result == 1 && result2 == 1) {
            OnlineOrderView.displayInsertOnlineOrder(result);
        }
    }
}
