

package com.book.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午6:09:54 

* 类说明 

*/

public interface SysUserMapper {
	/**
	 * 通过登录名查找用户信息
	 * @param loginName
	 * @param password
	 * @return
	 */
	@Select("select * from sys_user where login_name = #{arg0}")
	Map<String,Object> getUserByLoginName(String loginName);
}
