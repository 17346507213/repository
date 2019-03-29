
package com.book.controller.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.service.SysMenuService;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午11:16:40 

* 类说明 

*/
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;
	@RequestMapping("/loadMenu.do")
	@ResponseBody
	public List<Map<String,Object>> getSysMenuByParentId(@RequestParam(defaultValue="-1") String id){
		
		return this.sysMenuService.getSysMenuByParentId(id);
	}
	@RequestMapping("/getAllSysMenuByPage.do")
	@ResponseBody
	public Map<String,Object> getAllSysMenuByPage(int page,int rows){
		return this.sysMenuService.getAllSysMenuByPage(page, rows);
	}
	/**
	 * 保存一条数据
	 * @param sysMenu
	 * @return
	 */
	@RequestMapping("/insertSysMenu.do")
	@ResponseBody
	public int insertSysMenu(@RequestBody Map<String, Object> options){
		return this.sysMenuService.insertOrUpdateSysMenu(options);
	}
	
	/**
	 * 删除数据
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteSysMenu.do")
	@ResponseBody
	public boolean deleteSysMenu(String ids){
		return this.sysMenuService.deleteSysMenu(ids);
	}
	/**
	 * 通过id 查询一条数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/getSysMenuById.do")
	@ResponseBody
	public Map<String,Object> getSysMenuById(String id){
		return this.sysMenuService.getSysMenuById(id);
	}
	/**
	 * 查询菜单信息，排除id的数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/getSysMenuByNotId.do")
	@ResponseBody
	public List<Map<String,Object>> getSysMenuByNotId(String id){
		return this.sysMenuService.getSysMenuByNotId(id);
	}
}
