package com.swms.shoes.model.service;

import com.swms.shoes.model.dao.ShoesMapper;
import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesSelectDto;
import com.swms.shoes.model.dto.ShoesSelectOptionDto;
import com.swms.user.model.dto.CartDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.swms.common.Template.getSqlSession;

public class ShoesService {
    private ShoesMapper shoesMapper;



    public List<ShoesSelectDto> selectShoesList(ShoesSelectOptionDto shoesSelectOptionDto, int page) {
        int limit = 5;
        int offset = (page - 1) * limit;
        shoesSelectOptionDto.setOffset(offset);

        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        List<ShoesSelectDto> list = shoesMapper.selectShoesList(shoesSelectOptionDto);
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

    public ShoesDto getShoesId(ShoesDto shoes) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        ShoesDto shoesId = shoesMapper.getShoesId(shoes);
        sqlSession.close();
        return shoesId;
    }

    public int insertToCart(CartDto cart) {

        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);

        int result = 0;
        try {
            result = shoesMapper.insertToCart(cart);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return result;
    }

    public List<ShoesDto> searchByShoesName(String shoesName) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        List<ShoesDto> searchList = shoesMapper.searchByShoesName(shoesName);
        return searchList;
    }
}
