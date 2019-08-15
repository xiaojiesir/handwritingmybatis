package com.xiaojiesir.mymybatis.sqlSession;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import com.xiaojiesir.mymybatis.config.Function;
import com.xiaojiesir.mymybatis.config.MapperBean;

public class MyMapperProxy implements InvocationHandler {

    private  MySqlsession mySqlsession;

    private  MyConfiguration myConfiguration;

    public  MyMapperProxy(MyConfiguration myConfiguration,MySqlsession mySqlsession){

        this.myConfiguration=myConfiguration;
        this.mySqlsession=mySqlsession;
    }
    /**
     * @param proxy 把代理对象自身传进去
     * @param method 代表当前调用的方法
     * @param args 当前调用方法的参数
     */
    @SuppressWarnings("null")
	@Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean readMapper = myConfiguration.readMapper("UserMapper.xml");
        if(!method.getDeclaringClass().getName().equals(readMapper.getInterfaceName())){
            return null;
        }
        List<Function> list = readMapper.getList();
        if(list !=null || list.size()!=0){
            for (Function function : list){
                if(method.getName().equals(function.getFuncName())){
                    return mySqlsession.selectOne(function.getSql(),String.valueOf(args[0]));
                }
            }

        }
        return null;
    }
}
