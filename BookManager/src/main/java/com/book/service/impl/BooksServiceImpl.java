
package com.book.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.BooksMapper;
import com.book.service.BooksService;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午1:43:49 

* 类说明 
 
*/
@Service 
public class BooksServiceImpl implements BooksService{
	@Autowired
	private BooksMapper booksMapper;
	@Override
	public List<Map<String, Object>> getAllBooks() {
		return booksMapper.getAllBooks();
	}

	@Override
	public Map<String, Object> getBooksById(String id) {
		return this.booksMapper.getBooksById(id);
	}

}
