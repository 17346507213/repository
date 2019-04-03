
package com.book.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.book.entity.BooksPress;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月2日 下午6:24:56 

* 类说明 

*/

public interface BooksPressService {
	/**
	 * 查询所有的信息
	 * @return
	 */
	public List<BooksPress> getAllBooksPress();
	/**
	 * 添加或修改
	 * @param BooksPress
	 * @return
	 */
	public int insertOrUpdateBooksPress(BooksPress booksPress);
	/**
	 * 通过id得到一条数据
	 * @param id
	 * @return
	 */
	public BooksPress getBooksPressById(String id);
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	public boolean deleteBooksPress(String ids);
	/**
	 * 分页显示出版信息
	 * @param page 当前页码
	 * @param rows 每页显示多少条
	 * @return
	 */
	public Map<String,Object> getBooksPressByPage(int page,int rows);
}
