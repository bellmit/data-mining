package com.jdrx.dm.core.util;


import com.jdrx.dm.baseinfo.page.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 操作数据对象接口
 */
public interface GeneralMapper<E,PK extends Serializable>{
	/**
	 * 保存对象
	 * @param entity
	 * 			持久对象
	 */
	void save(E entity) throws Exception;
	
	/**
	 * 更新对象数据
	 * @param entity
	 * 			持久对象
	 * @return 最新的数据
	 */
	void update(E entity) throws Exception;

	/**
	 * 执行ql语句，可以是更新或者删除操作
	 * @param params
	 *            key表示ql中参数变量名，value表示该参数变量值
	 * @return 返回执行后受影响的数据个数
	 */
	int executeUpdate(Map<String, Object> params)throws Exception;

	/**
	 * 获取指定条件下的数据对象
	 * @param params
	 *            key表示ql中参数变量名，value表示该参数变量值
	 * @return 返回指定条件下的所有数据对象
	 */
	<T> List<T> query(Map<String, Object> params)throws Exception;

	/**
	 * 分页查询，获取满足条件下的对象
	 * @param page
	 * 				分页信息
	 * @throws Exception
	 */
	<T> void queryPager(Page<T> page)throws Exception;
	
	/**
	 * 结合对象主键id值获取该数据对象
	 * @param id
	 *          主键值
	 * @return 
	 * 			数据对象或者null
	 */
	E find(PK id)throws Exception;

	/**
	 * 删除数据对象
	 * @param id
	 * 			主键值
	 * @return
	 * 			删除成功数
	 */
	int delete(PK id)throws Exception;
}
