package com.swms.user.model.service;

import com.swms.user.model.dto.AccountDto;
import com.swms.user.model.dto.UserDto;
import org.apache.ibatis.session.SqlSession;

import static com.swms.common.Template.getSqlSession;

public class AccountService {

    public Boolean checkIdDuplication (String id) {
        SqlSession sqlSession = getSqlSession();

        sqlSession.close();
        return true;
    }

    public UserDto login(AccountDto account) {
        SqlSession sqlSession = getSqlSession();

        UserDto user = new UserDto();
        sqlSession.close();
        return user;
    }

    public int registAccount(AccountDto account) {
        SqlSession sqlSession = getSqlSession();

        int result = 0;

        try {

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally{
            sqlSession.close();
        }

        return result;
    }



}
