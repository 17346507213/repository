
package com.book.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午1:40:44 

* 类说明 图书管理数据访问层

*/

public interface BooksMapper {
	/**
	 * 获得所有的图书信息
	 * @return 图书信息
	 */
	@Select("select * from books_info order by book_code")
	List<Map<String,Object>> getAllBooks();
	/**
	 * 通过id获得图书信息
	 * @param id 图书id
	 * @return 图书信息
	 */
	@Select("select * from books_info where id = #{arg0}")
	Map<String,Object> getBooksById(String id);
}
