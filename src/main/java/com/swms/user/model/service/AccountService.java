package com.swms.user.model.service;

import com.swms.user.model.dao.AccountMapper;
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

    public boolean checkPassword(AccountDto inputAccountDto) {
        SqlSession sqlSession = getSqlSession();
        accountMapper = sqlSession.getMapper(AccountMapper.class);
        AccountDto storeAccountDto = accountMapper.findByAccountIncludingPassword(inputAccountDto.getAccount());

        boolean checkPassword = inputAccountDto.getPassword().equals(storeAccountDto.getPassword());
        if(!checkPassword){
            // 비밀번호가 틀렸다 리턴
        }

        sqlSession.close();

        return true;
    }

    public UserDto login(AccountDto accountDto) {
        SqlSession sqlSession = getSqlSession();
        accountMapper = sqlSession.getMapper(AccountMapper.class);

        UserDto userDto = accountMapper.findUserByAccount(accountDto);

        sqlSession.close();

        return userDto;
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
