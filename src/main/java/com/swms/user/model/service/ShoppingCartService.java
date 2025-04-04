package com.swms.user.model.service;

import com.swms.user.model.dao.ShoppingCartMapper;
import com.swms.user.model.dto.ShoppingCartDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;

public class ShoppingCartService {

    private ShoppingCartMapper shoppingCartMapper;

    public List<ShoppingCartDto> selectCartList(){
        SqlSession sqlSession = getSqlSession();
        shoppingCartMapper = sqlSession.getMapper(ShoppingCartMapper.class);
        List<ShoppingCartDto> list =shoppingCartMapper.checkShoppingCart();
        sqlSession.close();
        return list;
    }

}
