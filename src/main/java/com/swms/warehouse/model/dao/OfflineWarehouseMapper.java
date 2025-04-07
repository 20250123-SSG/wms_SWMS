package com.swms.warehouse.model.dao;



import com.swms.warehouse.model.dto.OfflineWarehouseDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OfflineWarehouseMapper {

    List<OfflineWarehouseDto> selectOfflineWarehouseByStoreId(
            @Param("storeId") int storeId,
            @Param("limit") int limit,
            @Param("offset") int offset
    );

    OfflineWarehouseDto selectWarehouseById(
            @Param("offlineWarehouseId") int offlineWarehouseId
    );

}