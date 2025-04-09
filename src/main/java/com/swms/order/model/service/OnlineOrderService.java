package com.swms.order.model.service;

import com.swms.order.model.dao.OnlineOrderMapper;
import com.swms.order.model.dto.OnlineOrderDetailDto;
import com.swms.order.model.dto.OnlineOrderDto;
import com.swms.order.model.dto.OnlineOrderStatsDto;
import com.swms.shoes.model.dao.ShoesMapper;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesSelectDto;
import com.swms.store.model.dao.OfflineSaleMapper;
import com.swms.store.model.dto.OfflineSaleStatsDto;
import com.swms.user.model.dto.UserDto;
import com.swms.warehouse.model.dao.OnlineWarehouseMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;

public class OnlineOrderService {

    private OnlineOrderMapper onlineOrderMapper;
    private OnlineWarehouseMapper onlineWarehouseMapper;

    public List<OnlineOrderStatsDto> getOnlineDailyStats(int page) {
        SqlSession sqlSession = getSqlSession();
        onlineOrderMapper = sqlSession.getMapper(OnlineOrderMapper.class);

        int limit = 10;
        int offset = (page - 1) * limit;

        List<OnlineOrderStatsDto> list = onlineOrderMapper.selectOnlineDailyStats(limit, offset);
        sqlSession.close();
        return list;
    }

    public List<OnlineOrderStatsDto> getOnlineMonthlyStats(int page) {
        SqlSession sqlSession = getSqlSession();
        onlineOrderMapper = sqlSession.getMapper(OnlineOrderMapper.class);

        int limit = 10;
        int offset = (page - 1) * limit;

        List<OnlineOrderStatsDto> list = onlineOrderMapper.selectOnlineMonthlyStats(limit, offset);
        sqlSession.close();
        return list;
    }


    // 구매 트랜젝션
    public int onlineOrder(UserDto userDto, ShoesDto shoesDto, int quauntity) {
        SqlSession sqlSession = getSqlSession();
        onlineOrderMapper = sqlSession.getMapper(OnlineOrderMapper.class);
        onlineWarehouseMapper = sqlSession.getMapper(OnlineWarehouseMapper.class);

        // TODO : 예외발생시 반환값처리
        try {
            // 창고에서 재고 차감
            int update = onlineWarehouseMapper.updateShoesQuantity(shoesDto.getShoesId());
            //사용자 금액 차감
            userDto.setMoney(userDto.getMoney() - shoesDto.getShoesPrice());

            // 구매내역등록
            OnlineOrderDto orderDto = OnlineOrderDto.builder()
                    .userId(userDto.getUserId())
                    .totalPrice(shoesDto.getShoesPrice() * quauntity)
                    .size(shoesDto.getSize())
                    .build();

            int insertOrder = onlineOrderMapper.insertOnlineOrder(orderDto);
            if(insertOrder == 1){
                System.out.println("주문 완료");
            }
            OnlineOrderDetailDto orderDetail = OnlineOrderDetailDto.builder()
                    .orderId(orderDto.getOrderId())
                    .shoesId(shoesDto.getShoesId())
                    .quantity(quauntity)
                    .build();

            int insertOrderDetail = onlineOrderMapper.insertOnlineOrderDetail(orderDetail);
            if(insertOrderDetail == 1){
                System.out.println("상세 주문 완료");
            }

            sqlSession.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
        int finalresult = 0; //  TODO: 결과값 반환
        return finalresult;
    }

    public int checkWarehouseStock(ShoesDto shoes) {
        SqlSession sqlSession = getSqlSession();
        onlineOrderMapper = sqlSession.getMapper(OnlineOrderMapper.class);
        onlineWarehouseMapper = sqlSession.getMapper(OnlineWarehouseMapper.class);

        int quantity = onlineWarehouseMapper.checkWarehouseStock(shoes.getShoesId());
        return quantity;
    }
}
