package com.swms.user.model.service;

import com.swms.order.model.dto.OnlineOrderDto;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.model.dao.ShoppingCartMapper;
import com.swms.user.model.dto.UserDto;
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



    public int removeCart(int shoesid) {

        SqlSession sqlSession = getSqlSession();
        shoppingCartMapper = sqlSession.getMapper(ShoppingCartMapper.class);

        int result = 0;
        try {
            result = shoppingCartMapper.deleteCart(shoesid);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally{
            sqlSession.close();
        }

        return result;

    }
    public int createOrder(UserDto user, int price) {
        // MyBatis SqlSession 받아오기 (예시)
        SqlSession sqlSession = getSqlSession();
        shoppingCartMapper = sqlSession.getMapper(ShoppingCartMapper.class);

        OnlineOrderDto orderDto = OnlineOrderDto.builder()
                .userId(user.getUserId())
                .totalPrice(price)
                .build();
        try {

            shoppingCartMapper.insertOnlineOrder(orderDto);
            sqlSession.commit();

            // orderDto.getOrderId()로 새로 생성된 PK 값 확인 가능
            System.out.println("생성된 orderId = " + orderDto.getOrderId());

            return orderDto.getOrderId();  // 정상적으로 삽입된 행 수
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException("주문 생성 실패", e);
        } finally {
            sqlSession.close();
        }
    }
}

//    public int buyCart(String buyName) {
//
//        SqlSession sqlSession = getSqlSession();
//        shoppingCartMapper = sqlSession.getMapper(ShoppingCartMapper.class);
//
//        int result = 0;
//        try {
//            result = shoppingCartMapper.buyCart(Integer.parseInt(buyName));
//            sqlSession.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            sqlSession.rollback();
//        }finally{
//            sqlSession.close();
//        }
//
//        return result;
//
//    }


