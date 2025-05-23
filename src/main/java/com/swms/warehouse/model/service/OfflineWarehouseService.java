package com.swms.warehouse.model.service;

import com.swms.warehouse.model.dao.OfflineWarehouseMapper;
import com.swms.warehouse.model.dto.OfflineWarehouseDto;
import org.apache.ibatis.session.SqlSession;
import static com.swms.common.Template.getSqlSession;

import java.util.List;


public class OfflineWarehouseService {


    private OfflineWarehouseMapper offlineWarehouseMapper;

    public List<OfflineWarehouseDto> selectAllStoreWarehouse(int page, int storeId) {
        SqlSession sqlSession = getSqlSession();
        offlineWarehouseMapper = sqlSession.getMapper(OfflineWarehouseMapper.class);

        int size = 5;
        int offset = (page - 1) * size;

        List<OfflineWarehouseDto> list =
                offlineWarehouseMapper.selectOfflineWarehouseByStoreId(storeId, size, offset);

        sqlSession.close();
        return list;
    }

    public OfflineWarehouseDto selectWarehouseById(int offlineWarehouseId) {
        SqlSession sqlSession = getSqlSession();
        offlineWarehouseMapper = sqlSession.getMapper(OfflineWarehouseMapper.class);


        OfflineWarehouseDto OfflineWarehouseDto =
                offlineWarehouseMapper.selectWarehouseById(offlineWarehouseId);

        sqlSession.close();
        return OfflineWarehouseDto;
    }
}
