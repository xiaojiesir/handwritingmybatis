package com.xiaojiesir.mymybatis.sqlSession;

import java.lang.reflect.Proxy;

//获取SqlSession对象
public class MySqlsession {
    private Excutor excutor = new MyExcutor();

    private MyConfiguration myConfiguration = new MyConfiguration();

    public <T> T selectOne(String statement,Object parameter){
        return excutor.query(statement,parameter);
    }
    @SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> clas){
    	/**
         * 产生某个对象的代理对象
         * ClassLoader loader    当前代理对象的类加载器
         * Class<?>[] interfaces 代理对象的接口
         * InvocationHandler h   InvocationHandler对象
         */
        return  (T) Proxy.newProxyInstance(clas.getClassLoader(),new Class[]{clas}, new MyMapperProxy(myConfiguration,this));
    }
}
