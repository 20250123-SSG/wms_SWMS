package com.swms.shoes.model.service;

import com.swms.shoes.model.dao.ShoesMapper;
import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesSelectDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.swms.common.Template.getSqlSession;

public class ShoesService {
    private ShoesMapper shoesMapper;



    public List<ShoesSelectDto> selectShoesList(Map<String, Object> map) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        List<ShoesSelectDto> list = shoesMapper.selectShoesList(map);
        sqlSession.close();
        return list;
    }

    public ShoesDto selectShoesDetail(String shoesName) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        ShoesDto shoes = shoesMapper.selectShoesDetail(shoesName);
        sqlSession.close();
        return shoes;
    }

    public List<String> selectShoesSizeList(String shoesName) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        List<String> sizeList = shoesMapper.selectShoesSizeList(shoesName);
        return sizeList;
    }

    public int getDisplayShoesCount(Map<String, Object> map) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        int countShoes = shoesMapper.getDisplayShoesCount(map);
        sqlSession.close();
        return countShoes;
    }

    public int getShoesId(ShoesDto shoes) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        int shoesId = shoesMapper.getShoesId(shoes);
        sqlSession.close();
        return shoesId;
    }

}
