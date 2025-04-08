package com.swms.warehouse.model.service;

import com.swms.warehouse.model.dao.OnlineWarehouseMapper;
import com.swms.warehouse.model.dto.OnlineWarehouseDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;

public class OnlineWarehouseService {
    private OnlineWarehouseMapper onlineWarehouseMapper;

    public List<OnlineWarehouseDto> selectAllOnlineWarehouse(int page) {
        SqlSession sqlSession = getSqlSession();
        onlineWarehouseMapper = sqlSession.getMapper(OnlineWarehouseMapper.class);

        int size = 10;
        int offset = (page - 1) * size;

        List<OnlineWarehouseDto> list = onlineWarehouseMapper.selectAllOnlineWarehouse(size, offset);

        sqlSession.close();
        return list;
    }

    public OnlineWarehouseDto selectWarehouseById(int onlineWarehouseId) {
        SqlSession sqlSession = getSqlSession();
        onlineWarehouseMapper = sqlSession.getMapper(OnlineWarehouseMapper.class);


        OnlineWarehouseDto onlineWarehouseDto =
                onlineWarehouseMapper.selectWarehouseById(onlineWarehouseId);

        sqlSession.close();
        return onlineWarehouseDto;
    }

    public int updateAddQuantity(OnlineWarehouseDto onlineWarehouseDto) {
        SqlSession sqlSession = getSqlSession();
        onlineWarehouseMapper = sqlSession.getMapper(OnlineWarehouseMapper.class);

        int result = 0;
        try {
            result = onlineWarehouseMapper.updateAddQuantity(onlineWarehouseDto);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return result;

    }
}
