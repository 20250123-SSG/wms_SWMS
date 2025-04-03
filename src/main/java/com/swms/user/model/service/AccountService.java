package com.swms.user.model.service;

import com.swms.user.model.dao.AccountMapper;
import com.swms.user.model.dao.UserMapper;
import com.swms.user.model.dto.AccountDto;
import com.swms.user.model.dto.AccountUserDto;
import com.swms.user.model.dto.UserDto;
import org.apache.ibatis.session.SqlSession;

import static com.swms.common.Template.getSqlSession;

public class AccountService {

    private AccountMapper accountMapper;

    public boolean checkAccountDuplication (String account) {
        SqlSession sqlSession = getSqlSession();

        accountMapper = sqlSession.getMapper(AccountMapper.class);

        String existingId = accountMapper.selectByAccount(account);

        sqlSession.close();

        return existingId != null; // 중복이면 true, 없으면 false
    }

    public UserDto login(AccountDto account) {
        SqlSession sqlSession = getSqlSession();

        UserDto user = new UserDto();
        sqlSession.close();
        return user;
    }

    public int registAccountUser(AccountUserDto accountUser) {
        SqlSession sqlSession = getSqlSession();

        accountMapper = sqlSession.getMapper(AccountMapper.class);

        int result = 0;

        try {
            result = accountMapper.insertAccountUser(accountUser);
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
