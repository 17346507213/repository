
package com.book.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.SysMenuMapper;
import com.book.service.SysMenuService;
import com.mysql.jdbc.StringUtils;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午11:13:32 

* 类说明 

*/
@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Override
	public List<Map<String, Object>> getSysMenuByParentId(String id) {
		return this.sysMenuMapper.getSysMenuByParentId(id);
	}

	@Override
	public Map<String, Object> getAllSysMenuByPage(int page, int rows) {
		//获得开始索引号
		int startIndex = (page-1)*rows;
		List<Map<String,Object>> list = this.sysMenuMapper.getAllSysMenuByPage(startIndex, rows);
		int total = this.sysMenuMapper.getAllSysMenuCount();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	@Override
	public int insertOrUpdateSysMenu(Map<String, Object> sysMenu) {
		if(StringUtils.isNullOrEmpty(String.valueOf(sysMenu.get("order_by")))){
			sysMenu.put("order_by", 1);
		}
		if(StringUtils.isNullOrEmpty(String.valueOf(sysMenu.get("id")))){
			return this.sysMenuMapper.insertSysMenu(sysMenu);
		}else{
			return this.sysMenuMapper.updateSysMenu(sysMenu);
		}
	}

	@Override
	public boolean deleteSysMenu(String ids) {
		int i = this.sysMenuMapper.deleteSysMenu(ids);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public Map<String, Object> getSysMenuById(String id) {
		return this.sysMenuMapper.getSysMenuById(id);
	}

	@Override
	public List<Map<String, Object>> getSysMenuByNotId(String id) {
		List<Map<String,Object>> list = this.sysMenuMapper.getSysMenuByNotId(id);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("id", "-1");
		map.put("menu_name", "顶层菜单");
		list.add(0, map);
		return list;
	}

}
