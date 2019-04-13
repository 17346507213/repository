package com.book.controller.books;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.entity.BooksInfo;
import com.book.service.BooksInfoService;
/**
 * 图书控制器类
 * @author lilei
 *
 */
@Controller
@RequestMapping("/booksInfo")
public class BooksInfoController {
	@Autowired
	private BooksInfoService booksInfoService;
	/**
	 * 获得所有的图书信息
	 * @return
	 */
	@RequestMapping("/getAllBooks.do")
	@ResponseBody
	public List<Map<String,Object>> getAllBooks(){
		 return this.booksInfoService.getAllBooks();
	}
	@RequestMapping("/getAllBooksByPage.do")
	@ResponseBody
	public Map<String,Object> getAllBooksByPage(int page, int rows) {
		return this.booksInfoService.getAllBooksByPage(page, rows);
	}
	/**
	 * 通过id得到图书信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/getBooksInfoById.do")
	@ResponseBody
	public BooksInfo getBooksInfoById(String id) {
		return this.booksInfoService.getBooksById(id);
	}
	/**
	 * 添加或修改数据
	 * @param booksInfo
	 * @return
	 */
	@RequestMapping("/insertOrUpdateBooksInfo.do")
	@ResponseBody
	public int insertOrUpdateBooksInfo(@RequestBody BooksInfo booksInfo){
		 return this.booksInfoService.insertOrUpdateBooksInfo(booksInfo);
	}
	/**
	 * 删除图书的数据
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteBooksInfo.do")
	@ResponseBody
	public int deleteBooksInfo(String ids){
		return this.booksInfoService.deleteBooksInfo(ids);
	}
}
