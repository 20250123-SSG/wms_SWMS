package com.swms.shoes.model.service;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dao.ShoesManagementMapper;
import org.apache.ibatis.session.SqlSession;

import static com.swms.common.Template.getSqlSession;

public class ShoesManagementService {
    private ShoesManagementMapper shoesManagementMapper;

    public int registShoes(ShoesDto menu) {
        SqlSession sqlSession = getSqlSession();
        shoesManagementMapper = sqlSession.getMapper(ShoesManagementMapper.class);

        int result = 0;

        try {
            result = shoesManagementMapper.insertShoes(menu);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally{
            sqlSession.close();
        }

        return result;
    }

    public int modifyShoes(ShoesDto menu) {

        SqlSession sqlSession = getSqlSession();
        shoesManagementMapper = sqlSession.getMapper(ShoesManagementMapper.class);

        int result = 0;
        try {
            result = shoesManagementMapper.updateShoes(menu);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }

        return result;

    }
    public int removeShoes(int id) {

        SqlSession sqlSession = getSqlSession();
        shoesManagementMapper = sqlSession.getMapper(ShoesManagementMapper.class);

        int result = 0;
        try {
            result = shoesManagementMapper.deleteShoes(id);
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

