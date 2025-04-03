package com.swms.user.model.service;

import com.swms.user.model.dao.AccountMapper;
import com.swms.user.model.dao.UserMapper;
import com.swms.user.model.dto.AccountDto;
import com.swms.user.model.dto.UserDto;
import org.apache.ibatis.session.SqlSession;

import static com.swms.common.Template.getSqlSession;

public class AccountService {

    private AccountMapper accountMapper;

    public boolean checkIdDuplication (String id) {
        SqlSession sqlSession = getSqlSession();

        accountMapper = sqlSession.getMapper(AccountMapper.class);

        String existingId = accountMapper.selectById(id);  // DB에서 해당 ID 조회
        System.out.println(existingId);
        sqlSession.close();



        return existingId != null; // 중복이면 true, 없으면 false
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
