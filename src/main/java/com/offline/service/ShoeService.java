package com.offline.service;

import com.offline.dao.ShoeMapper;
import com.offline.dto.OfflineStackDto;
import com.offline.dto.OfflinesaelDto;
import org.apache.ibatis.session.SqlSession;

import static com.offline.common.Template.getSqlSession;

public class ShoeService {
    private ShoeMapper shoeMapper;
    public OfflineStackDto shoesSearch(String code){
        SqlSession sqlSession = getSqlSession();
        shoeMapper = sqlSession.getMapper(ShoeMapper.class);
        OfflineStackDto offStack = shoeMapper.shoesSearch(code);
        sqlSession.close();
        return offStack;
    }
}
