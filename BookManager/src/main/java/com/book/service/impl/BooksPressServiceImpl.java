
package com.book.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.BooksPress;
import com.book.mapper.BooksPressMapper;
import com.book.service.BooksPressService;
import com.mysql.jdbc.StringUtils;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月2日 下午6:27:10 

* 类说明 

*/
@Service
public class BooksPressServiceImpl implements BooksPressService {
	@Autowired
	private BooksPressMapper booksPressMapper;
	@Override
	public List<BooksPress> getAllBooksPress() {
		return booksPressMapper.getAllBooksPress();
	}

	@Override
	public int insertOrUpdateBooksPress(BooksPress booksPress) {
		if(StringUtils.isNullOrEmpty(booksPress.getId())){
			return this.booksPressMapper.insertBooksPress(booksPress);
		}else{
			return this.booksPressMapper.updateBooksPress(booksPress);
		}
	}

	@Override
	public BooksPress getBooksPressById(String id) {
		return this.booksPressMapper.getBooksPressById(id);
	}

	@Override
	public boolean deleteBooksPress(String ids) {
		int count = this.booksPressMapper.deleteBooksPress(ids);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public Map<String, Object> getBooksPressByPage(int page, int rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", this.booksPressMapper.getAllBooksPressCount());
		map.put("rows", this.booksPressMapper.getAllBooksPressByPage((page-1)*rows, rows));
		return map;
	}

}
