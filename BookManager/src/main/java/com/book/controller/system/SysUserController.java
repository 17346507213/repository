
package com.book.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.service.SysUserService;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午6:21:10 

* 类说明 

*/
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
	@Autowired
	private SysUserService syUserService;
	/**
	 * 用户登陆是否成功
	 * @param loginName
	 * @param password
	 * @return
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public boolean isLogin(String loginName,String password){
		return this.syUserService.login(loginName, password);
	}
}
