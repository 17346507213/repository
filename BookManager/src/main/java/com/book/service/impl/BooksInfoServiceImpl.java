
package com.book.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.BooksInfo;
import com.book.mapper.BooksInfoMapper;
import com.book.service.BooksInfoService;
import com.mysql.jdbc.StringUtils;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午1:43:49 

* 类说明 
 
*/
@Service 
public class BooksInfoServiceImpl implements BooksInfoService{
	@Autowired
	private BooksInfoMapper booksInfoMapper;
	@Override
	public List<Map<String, Object>> getAllBooks() {
		return booksInfoMapper.getAllBooks();
	}

	@Override
	public BooksInfo getBooksById(String id) {
		return this.booksInfoMapper.getBooksById(id);
	}

	@Override
	public Map<String,Object> getAllBooksByPage(int page, int rows) {
		int startIndex = (page-1)*rows;
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("total", this.booksInfoMapper.getAllBoksInfoCount());
		map.put("rows", this.booksInfoMapper.getAllBooksByPage(startIndex, rows));
		return map;
	}

	@Override
	public int insertOrUpdateBooksInfo(BooksInfo booksInfo) {
		if(StringUtils.isNullOrEmpty(booksInfo.getId())){
			booksInfo.setBookState("1");
			if(booksInfo.getRegisterDate()==null){
				booksInfo.setRegisterDate(new Date());
			}
			return this.booksInfoMapper.insertBooksInfo(booksInfo);
		}else{
			return this.booksInfoMapper.updateBooksInfo(booksInfo);
		}
	}

	@Override
	public int deleteBooksInfo(String ids) {
		return this.booksInfoMapper.deleteBooksInfo(ids);
	}

}
