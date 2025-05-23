package com.swms.user.model.service;

import com.swms.user.model.dao.ShoppingCartMapper;
import com.swms.user.model.dao.UserMapper;
import com.swms.user.model.dto.ShoppingCartDto;
import com.swms.user.model.dto.UserDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.swms.common.Template.getSqlSession;

public class UserService {

    private UserMapper userMapper;

    public int updateAddress(UserDto userDto, String address) {

        SqlSession sqlSession = getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);

        int result = 0;
        try {
            userDto.setAddress(address);
            System.out.println(userDto.getUserId());
            System.out.println(userDto.getAddress());

            result = userMapper.updateAddress(userDto);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }

        return result;
    }
    //돈 돈 돈 돈 돈 돈 돈 돈 돈 돈 돈 돈 돈 돈 돈 돈 돈 돈
    public int updateMoney(UserDto userDto, int money) {
        SqlSession sqlSession = getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);


        int result = 0;
        try {
            userDto.setMoney(userDto.getMoney() + money);
            System.out.println(userDto);
            result = userMapper.updateMoney(userDto);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }

        return result;

    }

    public int updatePhone(UserDto userDto, String phone) {
        SqlSession sqlSession = getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);


        int result = 0;
        try {
            userDto.setPhone(phone);
            System.out.println(userDto);
            result = userMapper.updatePhone(userDto);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }

        return result;

    }

}
