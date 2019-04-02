
package com.book.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.SysUserMapper;
import com.book.service.SysUserService;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午6:16:18 

* 类说明 

*/
@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapper sysUserMapper;
	@Override
	public Map<String,Object> login(String loginName, String password) {
		Map<String,Object> user = this.sysUserMapper.getUserByLoginName(loginName);
		if(user!=null && user.get("password").equals(password)){
			return user;
		}
		return null;
	}

}
