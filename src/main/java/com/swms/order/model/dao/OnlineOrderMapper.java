package com.swms.order.model.dao;

import com.swms.order.model.dto.OnlineOrderDetailDto;
import com.swms.order.model.dto.OnlineOrderDto;
import com.swms.order.model.dto.OnlineOrderStatsDto;
import com.swms.store.model.dto.OfflineSaleStatsDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OnlineOrderMapper {

    int insertOnlineOrder(OnlineOrderDto order);

    int insertOnlineOrderDetail(OnlineOrderDetailDto orderDetail);

    List<OnlineOrderStatsDto> selectOnlineDailyStats(
            @Param("limit") int limit,
            @Param("offset") int offset);

    List<OnlineOrderStatsDto> selectOnlineMonthlyStats(
            @Param("limit") int limit,
            @Param("offset") int offset);


}