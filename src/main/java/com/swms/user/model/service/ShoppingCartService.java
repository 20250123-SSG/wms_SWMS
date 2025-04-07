package com.swms.user.model.service;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.model.dao.ShoppingCartMapper;
import com.swms.user.model.dto.ShoppingCartDto;
import com.swms.user.model.dto.UserDto;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;

public class ShoppingCartService {

    private ShoppingCartMapper shoppingCartMapper;

    public List<ShoesDto> selectCartList(UserDto userDto){
        SqlSession sqlSession = getSqlSession();
        shoppingCartMapper = sqlSession.getMapper(ShoppingCartMapper.class);
        List<ShoesDto> list =shoppingCartMapper.checkShoppingCart(userDto);
        sqlSession.close();
        return list;
    }

}
