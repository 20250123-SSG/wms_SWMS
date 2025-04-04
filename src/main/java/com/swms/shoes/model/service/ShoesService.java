package com.swms.shoes.model.service;

import com.swms.shoes.model.dao.ShoesMapper;
import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.swms.common.Template.getSqlSession;

public class ShoesService {
    private ShoesMapper shoesMapper;

    public List<ShoesDto> selectShoesList(Map<String, Object> map) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        List<ShoesDto> list = shoesMapper.selectShoesList(map);
        sqlSession.close();
        return list;
    }

    public ShoesDetailDto selectShoesDetail(String shoesName) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        ShoesDetailDto shoes = shoesMapper.selectShoesDetail(shoesName);
        sqlSession.close();
        return shoes;
    }
}
