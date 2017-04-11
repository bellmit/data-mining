package com.jdrx.dm.core.util;

import com.jdrx.dm.baseinfo.commons.UUIDUtil;
import com.jdrx.dm.bean.entity.Column;
import com.jdrx.dm.bean.entity.Database;
import com.jdrx.dm.bean.entity.Job;
import org.apache.commons.lang.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 赵少泉 on 2016-07-22.
 */
public class SqlFactory {

    public void abc()throws Exception{
        Job job = new Job();
        Database db = new Database();
        Connection conn = ConnectionManage.initConn(db);
        JdbcDriverEnum jde = JdbcDriverEnum.valueOf(StringUtils.upperCase(db.getType()));
        ResultSet result = conn.prepareStatement(getSQL(jde, job.getSql())).executeQuery();
        ResultSetMetaData metaData = result.getMetaData();
        List<Column> list = new ArrayList<>();
        for(int i=1;i<=metaData.getColumnCount();i++){
            Column column = new Column();
            column.setId(UUIDUtil.uuid());
            column.setTabId("");
            column.setNum(i);
            column.setName(metaData.getColumnName(i));
            column.setAlias(metaData.getColumnLabel(i));
            column.setType(metaData.getColumnTypeName(i));
            column.setPrecision(metaData.getPrecision(i));
            column.setScale(metaData.getScale(i));
            list.add(column);
        }
    }

    public String getSQL(JdbcDriverEnum jde, String sql){
        switch(jde){
            case ORACLE:
                return String.format("SELECT * FROM(%s)t WHERE rownum=1", sql);
            case MYSQL:
            case MARIADB:
                return String.format("SELECT * FROM(%s)t LIMIT 0,1", sql);
            case HIVE:
                return String.format("SELECT * FROM(%s)t LIMIT 1", sql);
            case SQLSERVER2000:
            case SQLSERVER2005:
                return String.format("SELECT TOP 1 * FROM(%s)t", sql);
        }
        return sql;
    }
}
