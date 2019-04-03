
package com.book.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.book.entity.BooksAuthor;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月3日 下午1:30:45 

* 类说明 

*/

public interface BooksAuthorService {

	/**
	 * 分页查询数据
	 * @param startIndex
	 * @param rows
	 * @return
	 */
	public Map<String,Object> getAllBooksAuthorByPage(int page,int rows);
	
	/**
	 * 添加数据
	 * @param BooksAuthor
	 * @return
	 */
	public int insertOrUpdateBooksAuthor(BooksAuthor booksAuthor);
	/**
	 * 通过id得到一条数据
	 * @param id
	 * @return
	 */
	public BooksAuthor getBooksAuthorById(String id);
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	public int deleteBooksAuthor(String ids);

}
