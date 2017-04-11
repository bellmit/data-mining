package com.jdrx.dm.baseinfo.mybatis.parser.impl;

import com.jdrx.dm.baseinfo.mybatis.parser.SqlServer;
import com.jdrx.dm.baseinfo.page.Page;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.Configuration;

import java.util.List;
import java.util.Map;

/**
 * sql server分页处理类
 * @author 赵少泉
 * @date 2015年8月26日 下午1:10:20
 */
public class SqlServerParser extends AbstractParser{
	
	private static final SqlServer pageSql = new SqlServer();

	@Override
	public boolean isSupportedMappedStatementCache(){
		// 由于sql server每次分页参数都是直接写入到sql语句中，因此不能缓存MS
		return false;
	}

	@Override
	public List<ParameterMapping> getPageParameterMapping(Configuration configuration, BoundSql boundSql){
		return boundSql.getParameterMappings();
	}

	@Override
	public String getPageSql(String sql){
		Page<?> page = new Page<Object>();
		return pageSql.convertToPageSql(sql, page.getStartRow(), page.getPageSize());
	}

	@Override
	public Map<String,Object> setPageParameter(MappedStatement ms, Object parameterObject, BoundSql boundSql, Page<?> page){
		return super.setPageParameter(ms, parameterObject, boundSql, page);
	}
	
}