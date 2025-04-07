package com.swms.warehouse.model.service;

import com.swms.warehouse.model.dao.OfflineWarehouseMapper;
import com.swms.warehouse.model.dto.OfflineWarehouseDto;
import org.apache.ibatis.session.SqlSession;
import static com.swms.common.Template.getSqlSession;

import java.util.List;


public class OfflineWarehouseService {


    private OfflineWarehouseMapper offlineWarehouseMapper;

    public List<OfflineWarehouseDto> selectAllOnlineWarehouse(int page) {
        SqlSession sqlSession = getSqlSession();
        offlineWarehouseMapper = sqlSession.getMapper(OfflineWarehouseMapper.class);

        int size = 10;
        int offset = (page - 1) * size;

        List<OfflineWarehouseDto> list = offlineWarehouseMapper.selectAllOfflineWarehouse(size, offset);

        sqlSession.close();
        return list;
    }
}
