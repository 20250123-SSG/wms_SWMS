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

//    public String searchBrandName(int brandId) {
//        SqlSession sqlSession = getSqlSession();
//        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
//        String brandName = shoesMapper.searchBrandName(brandId);
//        return brandName;
//    }
//
//    public String searchTypeName(int typeId) {
//        SqlSession sqlSession = getSqlSession();
//        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
//        String typeName = shoesMapper.searchTypeName(typeId);
//        return typeName;
//    }
    // TODO: session 닫아주기
    public List<ShoesDto> selectShoesList(Map<String, Object> map) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        List<ShoesDto> list = shoesMapper.selectShoesList(map);
        return list;
    }

    public ShoesDetailDto selectShoesDetail(String shoesName) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        ShoesDetailDto shoes = shoesMapper.selectShoesDetail(shoesName);
        return shoes;
    }
}
