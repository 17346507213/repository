
package com.book.controller.books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.entity.BooksType;
import com.book.service.BooksTypeService;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月2日 下午3:02:03 

* 类说明 

*/
@Controller
@RequestMapping("/booksType")
public class BooksTypeController {
	@Autowired
	private BooksTypeService booksTypeService;
	
	@RequestMapping("/getAllBooksType.do")
	@ResponseBody
	public List<BooksType> getAllBooksType(){
		return booksTypeService.getAllBooksType();
	}
	@RequestMapping("/insertOrUpdateBooksType.do")
	@ResponseBody
	public int insertOrUpdateBooksType(@RequestBody BooksType booksType){
		return booksTypeService.insertOrUpdateBooksType(booksType);
	}
	@RequestMapping("/getBooksTypeById.do")
	@ResponseBody
	public BooksType getBooksTypeById(String id){
		return this.booksTypeService.getBooksTypeById(id);
	}
	@RequestMapping("/deleteBooksType.do")
	@ResponseBody
	public boolean deleteBooksType(String ids){
		return this.booksTypeService.deleteBooksType(ids);
	}
}
