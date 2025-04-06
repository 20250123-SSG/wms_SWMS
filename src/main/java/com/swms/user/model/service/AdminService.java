package com.swms.user.model.service;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.model.dao.AdminMapper;
import org.apache.ibatis.session.SqlSession;

import static com.swms.common.Template.getSqlSession;

public class AdminService {
    private AdminMapper adminMapper;

    public int registShoes(ShoesDto menu) {
        SqlSession sqlSession = getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);

        int result = 0;

        try {
            result = adminMapper.insertShoes(menu);
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
        adminMapper = sqlSession.getMapper(AdminMapper.class);

        int result = 0;
        try {
            result = adminMapper.updateShoes(menu);
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
        adminMapper = sqlSession.getMapper(AdminMapper.class);

        int result = 0;
        try {
            result = adminMapper.deleteShoes(id);
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

