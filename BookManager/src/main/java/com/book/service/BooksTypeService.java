
package com.book.service;

import java.util.List;


import com.book.entity.BooksType;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月2日 下午2:57:50 

* 类说明 

*/

public interface BooksTypeService {
	/**
	 * 查询所有的图书分类信息
	 * @return
	 */
	public List<BooksType> getAllBooksType();
	/**
	 * 添加数据
	 * @param booksType
	 * @return
	 */
	public int insertOrUpdateBooksType(BooksType booksType);
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	public boolean deleteBooksType( String ids);
	public BooksType getBooksTypeById(String id);
}
