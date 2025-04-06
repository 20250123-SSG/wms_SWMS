package com.swms.order;

import com.swms.order.controller.OnlineOrderController;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesOrderDto;
import com.swms.user.model.dto.UserDto;

public class testOrderApplication {
    public static void main(String[] args) {
        OnlineOrderController onlineOrderController = new OnlineOrderController();
        UserDto userDto = new UserDto(4, "qwer", "1", "010-9378-8677", "rewq", 215000);
        ShoesDto shoesDto = new ShoesDto(1, "나이키", "스니커즈", "에어 포스 1", 129000, "270");
        onlineOrderController.insertOnlineOrder(userDto, shoesDto);
    }
}
