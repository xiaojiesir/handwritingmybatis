package com.xiaojiesir.mymybatis;

import com.xiaojiesir.mymybatis.bean.User;
import com.xiaojiesir.mymybatis.mapper.UserMapper;
import com.xiaojiesir.mymybatis.sqlSession.MySqlsession;

public class TestMybatis {
    public static void main(String[] args) {
        MySqlsession sqlsession = new MySqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.getUserById("1");
        System.out.println(user);
    }
}
