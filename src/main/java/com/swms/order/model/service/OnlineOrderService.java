package com.swms.order.model.service;

import com.swms.order.model.dao.OnlineOrderMapper;
import com.swms.order.model.dto.OnlineOrderDto;
import com.swms.shoes.model.dao.ShoesMapper;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesSelectDto;
import com.swms.user.model.dto.UserDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;

public class OnlineOrderService {

    private OnlineOrderMapper onlineOrderMapper;
    // 온라인 주문 테이블에 생성되어야함(order_id(자동생성), user_id(UserDto넘겨줘야함),price(ShoesDto넘겨줘야함),order_date(자동발생)
    public int insertOnlineOrder(OnlineOrderDto order) {
        SqlSession sqlSession = getSqlSession();
        onlineOrderMapper = sqlSession.getMapper(OnlineOrderMapper.class);
        int result = 0;
        try {
            result = onlineOrderMapper.insertOnlineOrder(order);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally{
            sqlSession.close();
        }

        return result;
    }

    // 온라인 주문 상세내역에 생성시키기 (Online_order_detail_id(자동), order_id(자동?), shoes_id, quantity)
    // UserDto + ShoesDto 로 주문서만들기
    // ShoesDto 활용해서 온라인 창고에서 -1 (id 포함하도록 수정해야함)
    // UserDto의 money가 shoes_price 보다 큰지 확인
}
