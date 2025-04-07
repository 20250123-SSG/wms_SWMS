package com.swms.shoes.model.service;

import com.swms.shoes.model.dao.ShoesMapper;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesOptionDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;

public class ShoesService {
    private ShoesMapper shoesMapper;

    public String searchBrandName(int brandId) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        String brandName = shoesMapper.searchBrandName(brandId);
        return brandName;
    }

    public String searchTypeName(int typeId) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        String typeName = shoesMapper.searchTypeName(typeId);
        return typeName;
    }


    // 상품조회관련 - 정렬 & 상품명 검색
    //인자 : 1. 가격, 아이디, 브랜드
    // 2. asc, desc
    // TODO : 추후 생각 더 해보기
    public List<ShoesDto> sortingByLatest(ShoesOptionDto selectOption) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        List<ShoesDto> list = shoesMapper.sortingByLatest(selectOption);
        return list;
    }

    public List<ShoesDto> sortingByPriceASC(ShoesOptionDto selectOption) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        List<ShoesDto> list = shoesMapper.sortingByPriceASC(selectOption);
        return list;
    }

    public List<ShoesDto> sortingByPriceDESC(ShoesOptionDto selectOption) {
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        List<ShoesDto> list = shoesMapper.sortingByPriceDESC(selectOption);
        return list;
    }


}
