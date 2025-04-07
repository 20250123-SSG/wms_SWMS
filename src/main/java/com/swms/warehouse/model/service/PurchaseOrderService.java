package com.swms.warehouse.model.service;


import com.swms.warehouse.model.dao.OnlineWarehouseMapper;
import com.swms.warehouse.model.dao.PurchaseOrderMapper;
import com.swms.warehouse.model.dto.OnlineWarehouseDto;
import com.swms.warehouse.model.dto.PurchaseOrderDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;


public class PurchaseOrderService {


    private PurchaseOrderMapper purchaseOrderMapper;


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
}
