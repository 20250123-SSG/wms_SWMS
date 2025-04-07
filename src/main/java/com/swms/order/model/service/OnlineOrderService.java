package com.swms.order.model.service;

import com.swms.order.model.dao.OnlineOrderMapper;
import com.swms.order.model.dto.OnlineOrderDetailDto;
import com.swms.order.model.dto.OnlineOrderDto;
import com.swms.shoes.model.dao.ShoesMapper;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesSelectDto;
import com.swms.user.model.dto.UserDto;
import com.swms.warehouse.model.dao.OnlineWarehouseMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;

public class OnlineOrderService {

    private OnlineOrderMapper onlineOrderMapper;
    private OnlineWarehouseMapper onlineWarehouseMapper;


    // 구매 트랜젝션
    public int onlineOrder(UserDto userDto, ShoesDto shoesDto) {
        SqlSession sqlSession = getSqlSession();
        onlineOrderMapper = sqlSession.getMapper(OnlineOrderMapper.class);
        onlineWarehouseMapper = sqlSession.getMapper(OnlineWarehouseMapper.class);

        // TODO : 예외발생시 반환값처리
        try{
            // 창고 수량 체크 (shoes >> warehouse로 변경)
            int quantity = onlineWarehouseMapper.checkWarehouseStock(shoesDto.getShoesId());
            // 금액체크
            int available =  (userDto.getMoney() >= shoesDto.getShoesPrice()) ? 0 : 1;
            // 창고에서 재고 차감
            int update = onlineWarehouseMapper.updateShoesQuantity(shoesDto.getShoesId());
            //사용자 금액 차감
            userDto.setMoney(userDto.getMoney() - shoesDto.getShoesPrice());
            // 구매내역등록
            OnlineOrderDto orderDto = OnlineOrderDto.builder()
                    .userId(userDto.getUserId())
                    .totalPrice(shoesDto.getShoesPrice())
                    .size(shoesDto.getSize())
                    .build();
            try {
                int insertOrder = onlineOrderMapper.insertOnlineOrder(orderDto);
                sqlSession.commit();
            }catch (Exception e) {
                e.printStackTrace();
                sqlSession.rollback();
            }
            OnlineOrderDetailDto orderDetail = OnlineOrderDetailDto.builder()
                    .orderId(orderDto.getOrderId())
                    .shoesId(shoesDto.getShoesId())
                    .quantity(1)
                    .build();

            int insertOrderDetail = onlineOrderMapper.insertOnlineOrderDetail(orderDetail);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally{
            sqlSession.close();
        }
        int finalresult = 0; //  TODO: 결과값 반환
        return finalresult;
    }
}
