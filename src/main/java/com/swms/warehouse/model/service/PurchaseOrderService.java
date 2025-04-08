package com.swms.warehouse.model.service;


import com.swms.warehouse.model.dao.OfflineWarehouseMapper;
import com.swms.warehouse.model.dao.OnlineWarehouseMapper;
import com.swms.warehouse.model.dao.PurchaseOrderMapper;
import com.swms.warehouse.model.dto.OfflineWarehouseDto;
import com.swms.warehouse.model.dto.OnlineWarehouseDto;
import com.swms.warehouse.model.dto.PurchaseOrderDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;


public class PurchaseOrderService {


    private PurchaseOrderMapper purchaseOrderMapper;
    private OfflineWarehouseMapper offlineWarehouseMapper;
    private OnlineWarehouseMapper onlineWarehouseMapper;


    public int createPurchaseOrder(PurchaseOrderDto purchaseOrderDto) {
        SqlSession sqlSession = getSqlSession();
        purchaseOrderMapper = sqlSession.getMapper(PurchaseOrderMapper.class);

        int result = 0;
        try {

            result = purchaseOrderMapper.createPurchaseOrder(purchaseOrderDto);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return result;
    }

    public List<PurchaseOrderDto> selectAllPurchaseOrder(int page) {
        SqlSession sqlSession = getSqlSession();
        purchaseOrderMapper = sqlSession.getMapper(PurchaseOrderMapper.class);

        int size = 5;
        int offset = (page - 1) * size;

        List<PurchaseOrderDto> list =
                purchaseOrderMapper.selectAllPurchaseOrder(size, offset);

        sqlSession.close();
        return list;
    }

    public PurchaseOrderDto selectWarehouseById(int purchaseOrderId) {
        SqlSession sqlSession = getSqlSession();
        purchaseOrderMapper = sqlSession.getMapper(PurchaseOrderMapper.class);


        PurchaseOrderDto purchaseOrderDto =
                purchaseOrderMapper.selectPurchaseOrderById(purchaseOrderId);

        sqlSession.close();
        return purchaseOrderDto;
    }

    public int approvePurchaseOrder(PurchaseOrderDto purchaseOrderDto, OfflineWarehouseDto offlineWarehouseDto, OnlineWarehouseDto onlineWarehouseDto) {
        SqlSession sqlSession = getSqlSession();
        purchaseOrderMapper = sqlSession.getMapper(PurchaseOrderMapper.class);
        offlineWarehouseMapper = sqlSession.getMapper(OfflineWarehouseMapper.class);
        onlineWarehouseMapper = sqlSession.getMapper(OnlineWarehouseMapper.class);

        int result = 0;
        try {
            onlineWarehouseMapper.updateAddQuantity(onlineWarehouseDto);

            int warehouseResult = offlineWarehouseMapper.updateAddQuantityByStoreAndShoesById(offlineWarehouseDto);
            // 없는 경우 생성
            if(warehouseResult == 0){
                offlineWarehouseMapper.upsertOfflineWarehouseQuantity(offlineWarehouseDto);
            }

            result = purchaseOrderMapper.updateStatusAndCompletionDate(purchaseOrderDto);

            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw e;
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public int updatePurchaseOrder(PurchaseOrderDto purchaseOrderDto) {
        int result = 0;
        SqlSession sqlSession = getSqlSession();
        purchaseOrderMapper = sqlSession.getMapper(PurchaseOrderMapper.class);

        try {
            result = purchaseOrderMapper.updateStatusAndCompletionDate(purchaseOrderDto);

            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw e;
        } finally {
            sqlSession.close();
        }

        return result;
    }

}
