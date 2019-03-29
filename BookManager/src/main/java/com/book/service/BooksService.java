 
package com.book.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午1:43:25 

* 类说明 

*/

public interface BooksService {

	/**
	 * 通过id获得图书信息
	 * @param id 图书id
	 * @return 图书信息
	 */
     Map<String,Object> getBooksById(String id);
 	/**
 	 * 获得所有的图书信息
 	 * @return 图书信息
 	 */
	List<Map<String, Object>> getAllBooks();
}
