
package com.book.service;

import java.util.Map;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午6:14:29 

* 类说明 

*/

public interface SysUserService {
	/**
	 * 通过用户名和密码判断是否登陆成功
	 * @param loginName
	 * @param password
	 * @return
	 */
	public Map<String,Object> login(String loginName,String password);
	
}
