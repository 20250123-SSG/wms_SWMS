package com.swms.order.controller;

import com.swms.order.model.dto.OnlineOrderDto;
import com.swms.order.model.service.OnlineOrderService;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.model.dto.UserDto;
import com.swms.order.view.OnlineOrderView;


public class OnlineOrderController {
    private OnlineOrderService onlineOrderService = new OnlineOrderService();

    public void insertOnlineOrder(UserDto user, ShoesDto shoes, String size){
        OnlineOrderDto order = OnlineOrderDto.builder()
                .userId(user.getUserId())
                .totalPrice(shoes.getShoesPrice())
                .size(size)
                .build();

        int result = onlineOrderService.insertOnlineOrder(order);
        OnlineOrderView.displayInsertOnlineOrder(result);
    }
}
