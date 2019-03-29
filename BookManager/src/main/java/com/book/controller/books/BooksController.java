package com.book.controller.books;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.service.BooksService;
/**
 * 图书控制器类
 * @author lilei
 *
 */
@Controller
@RequestMapping("/books")
public class BooksController {
	@Autowired
	private BooksService booksService;
	/**
	 * 获得所有的图书信息
	 * @return
	 */
	@RequestMapping("/getAllBooks.do")
	@ResponseBody
	public List<Map<String,Object>> getAllBooks(){
		 return this.booksService.getAllBooks();
	}
	
	/**
	 * 通过id得到图书信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/getBooksById.do")
	@ResponseBody
	public Map<String, Object> getBooksById(String id) {
		return this.booksService.getBooksById(id);
	}
	@RequestMapping("/booksView.do")
	public String testView(){
		return "/books/testView.jsp";
	}
}
