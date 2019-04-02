
package com.book.controller.system;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String isLogin(String loginName,String password,String code,HttpSession session){
			if(loginName!=null && password!=null && code!=null){
				String authCode = (String) session.getAttribute("authCode");
				if(code.toLowerCase().equals(authCode)){
					Map<String,Object> user = this.syUserService.login(loginName, password);
					if(user!=null){
						session.setAttribute("userId", user.get("id"));
						return "ok";
					}else{
						return "userMsg";
					}
				}else{
					return "codeMsg";
				}
			}else{
				return "userMsg";
			}
	}
}
