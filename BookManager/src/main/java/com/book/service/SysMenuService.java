
package com.book.service;

import java.util.List;
import java.util.Map;


/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午11:12:16 

* 类说明 

*/

public interface SysMenuService {
	public List<Map<String,Object>> getSysMenuByParentId(String id);
	/**
	 * 分页显示菜单信息
	 * @param page 当前页码
	 * @param rows 每页显示的数据条数
	 * @return 数据
	 */
	public Map<String,Object> getAllSysMenuByPage(int page,int rows);
	/**
	 * 添加或修改数据
	 * @param sysMenu
	 * @return
	 */
	public int insertOrUpdateSysMenu(Map<String,Object> sysMenu);
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	public boolean deleteSysMenu(String ids);
	/**
	 * 通过id 查询菜单信息
	 * @param id
	 * @return
	 */
	public Map<String,Object> getSysMenuById(String id);
	/**
	 * 查询菜单信息，排除id数据
	 * @param id
	 * @return
	 */
	public List<Map<String,Object>> getSysMenuByNotId(String id);
}
