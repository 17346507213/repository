 
package com.book.service;

import java.util.List;
import java.util.Map;

import com.book.entity.BooksInfo;



/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午1:43:25 

* 类说明 

*/

public interface BooksInfoService {

	/**
	 * 通过id获得图书信息
	 * @param id 图书id
	 * @return 图书信息
	 */
	BooksInfo getBooksById(String id);
 	/**
 	 * 获得所有的图书信息
 	 * @return 图书信息
 	 */
	List<Map<String, Object>> getAllBooks();
	/**
	 * 分页查询图书信息
	 * @param page
	 * @param rows
	 * @return
	 */
	Map<String,Object> getAllBooksByPage(int page,int rows);
	/**
	 * 添加或修改数据
	 * @param booksInfo
	 * @return
	 */
	public int insertOrUpdateBooksInfo(BooksInfo booksInfo);
	/**
	 * 删除图书的数据
	 * @param ids
	 * @return
	 */
	public int deleteBooksInfo(String ids);
}
