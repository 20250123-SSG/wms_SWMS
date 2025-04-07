package com.swms.store.model.service;

import com.swms.store.model.dao.StoreMapper;
import com.swms.store.model.dto.StoreDto;
import org.apache.ibatis.session.SqlSession;

import static com.swms.common.Template.getSqlSession;

public class StoreService {

    private StoreMapper storeMapper;

    public StoreDto getStoreByUserId(int userId) {
        SqlSession sqlSession = getSqlSession();
        storeMapper = sqlSession.getMapper(StoreMapper.class);

        sqlSession.close();

        return storeMapper.findByUserId(userId);
    }
}
