package com.xiaojiesir.mymybatis.sqlSession;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xiaojiesir.mymybatis.bean.User;

public class MyExcutor implements Excutor {
    private MyConfiguration xmlConfiguration = new MyConfiguration();

    //MyBatis执行器，是MyBatis 调度的核心，负责SQL语句的生成和查询缓存的维护；
    @Override
    public <T> T query(String sql, Object parameter) {
    	System.out.println(sql);
        Connection connection = getConnection();
        ResultSet set = null;
        PreparedStatement pre = null;
        try{
            pre = connection.prepareStatement(sql);
            pre.setString(1,parameter.toString());
            set = pre.executeQuery();
            User u = new User();
            while (set.next()){
                u.setId(set.getString(1));
                u.setUsername(set.getString(2));
                u.setPassword(set.getString(3));
                System.out.println(u);
            }
            return (T)u;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(set!=null){
                    set.close();
                } if(pre!=null){
                    pre.close();
                } if(connection!=null){
                    connection.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }

        }
        return null;
    }
    private Connection getConnection(){
        try{
            Connection connection = xmlConfiguration.build("config.xml");
            return connection;
        }catch(Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}
