
package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.BooksType;
import com.book.mapper.BooksTypeMapper;
import com.book.service.BooksTypeService;
import com.mysql.jdbc.StringUtils;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月2日 下午2:59:02 

* 类说明 

*/
@Service
public class BooksTypeServiceImpl implements BooksTypeService {
	@Autowired
	private BooksTypeMapper booksTypeMapper;
	@Override
	public List<BooksType> getAllBooksType() {
		return booksTypeMapper.getAllBooksType();
	}

	@Override
	public int insertOrUpdateBooksType(BooksType booksType) {
		if(StringUtils.isNullOrEmpty(booksType.getId())){
			return booksTypeMapper.insertBooksType(booksType);
		}else{
			return booksTypeMapper.updateBooksType(booksType);
		}
		
	}

	

	@Override
	public boolean deleteBooksType(String ids) {
		int i = this.booksTypeMapper.deleteBooksType(ids);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public BooksType getBooksTypeById(String id) {
		return this.booksTypeMapper.getBooksTypeById(id);
	}

}
