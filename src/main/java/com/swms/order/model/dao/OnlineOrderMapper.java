package com.swms.order.model.dao;

import com.swms.order.model.dto.OnlineOrderDetailDto;
import com.swms.order.model.dto.OnlineOrderDto;

public interface OnlineOrderMapper {

    int insertOnlineOrder(OnlineOrderDto order);

    int insertOnlineOrderDetail(OnlineOrderDetailDto orderDetail);

    int checkWarehouseStock(int shoesId);
}