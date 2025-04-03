package com.swms.shoes.model.service;

import com.swms.shoes.model.dao.ShoesMapper;
import com.swms.shoes.model.dto.ShoesDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;

public class ShoesService {
    private ShoesMapper shoesMapper;

    public List<ShoesDto> selectMainShoes(ShoesDto option){
        SqlSession sqlSession = getSqlSession();
        shoesMapper = sqlSession.getMapper(ShoesMapper.class);
        System.out.println(option);
        List<ShoesDto> list = shoesMapper.selectMainShoes(option);
        System.out.println("조회하고온 결과");
        for(ShoesDto shoes : list){
            System.out.println(shoes);
        }
        return list;
    }
}
