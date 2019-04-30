
package com.book.controller.books;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.entity.BooksAuthor;
import com.book.service.BooksAuthorService;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月3日 下午1:39:38 

* 类说明 

*/
@Controller
@RequestMapping("/booksAuthor")
public class BooksAuthorController {
	@Autowired
	private BooksAuthorService booksAuthorService;
	@RequestMapping(value="/getAllBooksAuthorByPage.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> getAllBooksAuthorByPage(int page, int rows,@RequestParam(name="name",required=false) String name) {
		return this.booksAuthorService.getAllBooksAuthorByPage(page, rows,name);
	}
	@RequestMapping("/insertOrUpdateBooksAuthor.do")
	@ResponseBody
	public int insertOrUpdateBooksAuthor(@RequestBody BooksAuthor booksAuthor) {
		return this.booksAuthorService.insertOrUpdateBooksAuthor(booksAuthor);
	}
	@RequestMapping("/getBooksAuthorById.do")
	@ResponseBody
	public BooksAuthor getBooksAuthorById(String id) {
		return this.booksAuthorService.getBooksAuthorById(id);
	}
	@RequestMapping("/deleteBooksAuthor.do")
	@ResponseBody
	public int deleteBooksAuthor(String ids) {
		return this.booksAuthorService.deleteBooksAuthor(ids);
	}

}
