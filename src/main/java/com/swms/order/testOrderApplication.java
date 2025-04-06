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


        // **창고에서 수량있는지 확인**
        onlineOrderController.checkWarehouseStock(shoesDto);
        // 주문서 출력

        // [구매] 트랜젝션
        // 금액체크 & 차감
        onlineOrderController.checkMoney(userDto, shoesDto);
        // 창고에서 제품 delete
        //구매내역등록
        onlineOrderController.insertOnlineOrder(userDto, shoesDto);
    }
}
