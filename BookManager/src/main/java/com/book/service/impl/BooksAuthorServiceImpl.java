
package com.book.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.book.entity.BooksAuthor;
import com.book.mapper.BooksAuthorMapper;
import com.book.service.BooksAuthorService;
import com.mysql.jdbc.StringUtils;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月3日 下午1:33:25 

* 类说明 

*/
@Service
public class BooksAuthorServiceImpl implements BooksAuthorService {
	@Autowired
	private BooksAuthorMapper booksAuthorMapper;
	@Override
	public Map<String, Object> getAllBooksAuthorByPage(int page, int rows,String name) {
		if(name!=null){
			name = "%"+name+"%";
		}
		int startIndex = (page-1)*rows;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", this.booksAuthorMapper.getAllBooksAuthorCount(name));
		map.put("rows", this.booksAuthorMapper.getAllBooksAuthorByPage(startIndex, rows,name));
		return map;
	}

	@Override
	public int insertOrUpdateBooksAuthor(BooksAuthor booksAuthor) {
		if(StringUtils.isNullOrEmpty(booksAuthor.getId())){
			return this.booksAuthorMapper.insertBooksAuthor(booksAuthor);
		}else{
			return this.booksAuthorMapper.updateBooksAuthor(booksAuthor);
		}
	}

	@Override
	public BooksAuthor getBooksAuthorById(String id) {
		return this.booksAuthorMapper.getBooksAuthorById(id);
	}

	@Override
	public int deleteBooksAuthor(String ids) {
		return this.booksAuthorMapper.deleteBooksAuthor(ids);
	}

}
