package com.swms.warehouse.model.dao;

import com.swms.warehouse.model.dto.OnlineWarehouseDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OnlineWarehouseMapper {

    List<OnlineWarehouseDto> selectAllOnlineWarehouse(
            @Param("limit") int limit,
            @Param("offset") int offset);

}