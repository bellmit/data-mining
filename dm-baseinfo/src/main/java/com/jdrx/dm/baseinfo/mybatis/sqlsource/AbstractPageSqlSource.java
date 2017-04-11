package com.jdrx.dm.baseinfo.mybatis.sqlsource;

import com.jdrx.dm.baseinfo.mybatis.PagePlugin;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 分页处理抽象类
 * @author 赵少泉
 * @date 2015年8月26日 下午12:42:30
 */
public abstract class AbstractPageSqlSource implements SqlSource {

    /**
     * 获取Count查询的BoundSql
     *
     * @param parameterObject
     * @return
     */
    protected abstract BoundSql getCountBoundSql(Object  parameterObject);

    /**
     * 获取分页查询的BoundSql
     *
     * @param parameterObject
     * @return
     */
    protected abstract BoundSql getPageBoundSql(Object  parameterObject);

    /**
     * 获取BoundSql
     *
     * @param parameterObject
     * @return
     */
    @Override
    public BoundSql getBoundSql(Object parameterObject){
        if(PagePlugin.getCOUNT()){
            return getCountBoundSql(parameterObject);
        }else{
            return getPageBoundSql(parameterObject);
        }
    }
}
