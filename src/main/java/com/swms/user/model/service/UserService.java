package com.swms.user.model.service;

import com.swms.user.model.dao.UserMapper;
import com.swms.user.model.dto.UserDto;
import org.apache.ibatis.session.SqlSession;

import static com.swms.common.Template.getSqlSession;

public class UserService {

    private UserMapper userMapper;

    public int updateAddress(UserDto userDto, String address) {

        SqlSession sqlSession = getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);

        int result = 0;
        try {
            userDto.setAddress(address);
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

}
