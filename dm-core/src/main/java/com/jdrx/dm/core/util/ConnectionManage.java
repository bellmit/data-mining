package com.jdrx.dm.core.util;

import com.jdrx.dm.bean.entity.Database;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by 赵少泉 on 2016-07-22.
 */
public class ConnectionManage {
    private static final Logger logger = LoggerFactory.getLogger(ConnectionManage.class);

    public static Connection initConn(Database db)throws Exception{
        Assert.notNull(db, "数据库实例不能为空");
        JdbcDriverEnum jde = JdbcDriverEnum.valueOf(StringUtils.upperCase(db.getType()));
        Assert.notNull(jde, "数据库类型不匹配");
        try{
            Class.forName(jde.getDriver());
        }catch(ClassNotFoundException e){
            logger.error(e.getMessage(), e);
            throw new Exception("未找到驱动程序类，加载驱动失败");
        }
        return DriverManager.getConnection(jde.getUrl(db.getHost(), db.getPort(), db.getInstance()), db.getUser(), db.getPass());
    }

}
