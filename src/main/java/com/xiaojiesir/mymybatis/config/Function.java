package com.xiaojiesir.mymybatis.config;

public class Function {
    private  String sqltype;//sql的类型
    private  String funcName;//方法名
    private  String sql;//sql语句
    private  Object resultType;//返回类型
    private  String parameterype;//参数类型

    public String getSqltype() {
        return sqltype;
    }

    public void setSqltype(String sqltype) {
        this.sqltype = sqltype;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Object getResultType() {
        return resultType;
    }

    public void setResultType(Object resultType) {
        this.resultType = resultType;
    }

    public String getParameterype() {
        return parameterype;
    }

    public void setParameterype(String parameterype) {
        this.parameterype = parameterype;
    }
}
