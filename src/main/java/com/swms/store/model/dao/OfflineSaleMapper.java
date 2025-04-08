package com.swms.store.model.dao;


import com.swms.store.model.dto.OfflineSaleDto;
import com.swms.store.model.dto.OfflineSaleStatsDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OfflineSaleMapper {
    int createOfflineSale(OfflineSaleDto offlineSaleDto);

    List<OfflineSaleDto> selectOfflineSaleByStoreId(
            @Param("storeId") int storeId,
            @Param("limit") int limit,
            @Param("offset") int offset
    );

    List<OfflineSaleStatsDto> selectDailySales(@Param("storeId") int storeId,
                                               @Param("limit") int limit,
                                               @Param("offset") int offset);

    List<OfflineSaleStatsDto> selectMonthlySales(@Param("storeId") int storeId,
                                                 @Param("limit") int limit,
                                                 @Param("offset") int offset);
}