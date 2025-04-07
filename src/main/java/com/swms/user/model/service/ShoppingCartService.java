package com.swms.user.model.service;

import com.swms.order.model.service.OnlineOrderService;
import com.swms.shoes.model.dao.ShoesManagementMapper;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.view.ShoesResultView;
import com.swms.user.model.dao.ShoppingCartMapper;
import com.swms.user.model.dto.ShoppingCartDto;
import com.swms.user.model.dto.UserDto;
import com.swms.order.controller.OnlineOrderController.*;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;

public class ShoppingCartService {
    OnlineOrderService onlineOrderService =new OnlineOrderService();
    private ShoppingCartMapper shoppingCartMapper;

    public List<ShoesDto> selectCartList(UserDto userDto){
        SqlSession sqlSession = getSqlSession();
        shoppingCartMapper = sqlSession.getMapper(ShoppingCartMapper.class);
        List<ShoesDto> list =shoppingCartMapper.checkShoppingCart(userDto);
        sqlSession.close();
        return list;
    }

    public int removeShoes(int id) {

        SqlSession sqlSession = getSqlSession();
        shoppingCartMapper = sqlSession.getMapper(ShoppingCartMapper.class);

        int result = 0;
        try {
            result = shoppingCartMapper.deleteShoes(id);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally{
            sqlSession.close();
        }

        return result;

    }
}
