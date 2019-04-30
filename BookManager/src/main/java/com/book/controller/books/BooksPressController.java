
package com.book.controller.books;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.entity.BooksPress;
import com.book.service.BooksPressService;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月2日 下午3:02:03 

* 类说明 

*/
@Controller
@RequestMapping("/booksPress")
public class BooksPressController {
	@Autowired
	private BooksPressService booksPressService;
	/**
	 * 获得所有数据
	 * @return
	 */
	@RequestMapping("/getAllBooksPress.do")
	@ResponseBody
	public List<BooksPress> getAllBooksPress(){
		return booksPressService.getAllBooksPress();
	}
	/**
	 * 分页显示获得所有数据
	 * @return
	 */
	@RequestMapping("/getBooksPressByPage.do")
	@ResponseBody
	public Map<String, Object> getBooksPressByPage(int page, int rows,@RequestParam(name="pressName",required=false) String pressName) {
		return this.booksPressService.getBooksPressByPage(page, rows,pressName);
	}
	/**
	 * 添加或修改数据
	 * @param booksPress
	 * @return
	 */
	@RequestMapping("/insertOrUpdateBooksPress.do")
	@ResponseBody
	public int insertOrUpdateBooksPress(@RequestBody BooksPress booksPress){
		return booksPressService.insertOrUpdateBooksPress(booksPress);
	}
	/**
	 * 通过id得到数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/getBooksPressById.do")
	@ResponseBody
	public BooksPress getBooksPressById(String id){
		return this.booksPressService.getBooksPressById(id);
	}
	/**
	 * 删除数据
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteBooksPress.do")
	@ResponseBody
	public boolean deleteBooksPress(String ids){
		return this.booksPressService.deleteBooksPress(ids);
	}
}
