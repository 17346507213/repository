
package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.book.entity.BooksPress;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月2日 下午6:17:41 

* 类说明 

*/

public interface BooksPressMapper {
	/**
	 * 查询所有的信息
	 * @return
	 */
	@Select("select * from books_press order by press_name")
	public List<BooksPress> getAllBooksPress();
	/**
	 * 分页查询数据
	 * @param startIndex
	 * @param rows
	 * @return
	 */
	@Select("select * from books_press order by press_name LIMIT #{arg0},#{arg1}")
	public List<BooksPress> getAllBooksPressByPage(int startIndex,int rows);
	/**
	 * 获得所有的数据条数
	 * @return
	 */
	@Select("select COUNT(books_press.id) from books_press")
	public int getAllBooksPressCount();
	/**
	 * 添加数据
	 * @param BooksPress
	 * @return
	 */
	@Insert("insert into books_press (id,press_name,press_address) value(uuid(),#{pressName},#{pressAddress})")
	public int insertBooksPress(BooksPress booksPress);
	/**
	 * 通过id得到一条数据
	 * @param id
	 * @return
	 */
	@Select("select * from books_press m where m.id = #{arg0}")
	public BooksPress getBooksPressById(String id);
	/**
	 * 修改数据
	 * @param BooksPress
	 * @return
	 */
	@Update("update books_press set press_name=#{pressName},press_address=#{pressAddress} where id=#{id}")
	public int updateBooksPress(BooksPress booksPress);
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	@Delete("DELETE from books_press where id in(${ids})")
	public int deleteBooksPress(@Param(value="ids") String ids);
}
