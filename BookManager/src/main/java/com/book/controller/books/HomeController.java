
package com.book.controller.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午3:42:31 

* 类说明 

*/
@Controller
public class HomeController {
	/**
	 * 默认首页
	 * @return
	 */
	@RequestMapping("/")
	public String toIndex(){
		return "redirect:/pages/login/login.jsp";
	}
}
