package com.swms.store.model.service;

import com.swms.store.model.dao.OfflineSaleMapper;
import com.swms.store.model.dto.OfflineSaleDto;
import com.swms.store.model.dto.OfflineSaleStatsDto;
import com.swms.warehouse.model.dao.OfflineWarehouseMapper;
import com.swms.warehouse.model.dao.PurchaseOrderMapper;
import com.swms.warehouse.model.dto.OfflineWarehouseDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;

public class OfflineSaleService {

    private OfflineSaleMapper offlineSaleMapper;
    private OfflineWarehouseMapper offlineWarehouseMapper;

    public int processSale(OfflineWarehouseDto offlineWarehouseDto, OfflineSaleDto offlineSaleDto) {
        SqlSession sqlSession = getSqlSession();
        offlineSaleMapper = sqlSession.getMapper(OfflineSaleMapper.class);
        offlineWarehouseMapper = sqlSession.getMapper(OfflineWarehouseMapper.class);

        int result = 0;
        try {
            // 판매 수량 만큼 창고 업데이트
            offlineWarehouseMapper.updateQuantity(offlineWarehouseDto);
            // 판매 등록
            result = offlineSaleMapper.createOfflineSale(offlineSaleDto);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return result;

    }

    public List<OfflineSaleDto> selectOfflineSaleByStoreId(int page, int storeId) {
        SqlSession sqlSession = getSqlSession();
        offlineSaleMapper = sqlSession.getMapper(OfflineSaleMapper.class);

        int limit = 5;
        int offset = (page - 1) * limit;

        List<OfflineSaleDto> list =
                offlineSaleMapper.selectOfflineSaleByStoreId(storeId, limit, offset);

        sqlSession.close();

        return list;
    }


    public List<OfflineSaleStatsDto> getDailySales(Integer storeId, int page) {
        SqlSession sqlSession = getSqlSession();
        offlineSaleMapper = sqlSession.getMapper(OfflineSaleMapper.class);

        int limit = 10;
        int offset = (page - 1) * limit;

        List<OfflineSaleStatsDto> list = offlineSaleMapper.selectDailySales(storeId, limit, offset);
        sqlSession.close();
        return list;
    }

    public List<OfflineSaleStatsDto> getMonthlySales(Integer storeId, int page) {
        SqlSession sqlSession = getSqlSession();
        offlineSaleMapper = sqlSession.getMapper(OfflineSaleMapper.class);

        int limit = 10;
        int offset = (page - 1) * limit;

        List<OfflineSaleStatsDto> list = offlineSaleMapper.selectMonthlySales(storeId, limit, offset);
        sqlSession.close();
        return list;
    }


}
