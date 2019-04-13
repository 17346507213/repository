
package com.book.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.book.entity.BooksInfo;
import com.book.entity.BooksPress;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午1:40:44 

* 类说明 图书管理数据访问层

*/

public interface BooksInfoMapper {
	/**
	 * 获得所有的图书信息
	 * @return 图书信息
	 */
	@Select("select * from books_info order by book_code")
	List<Map<String,Object>> getAllBooks();
	public /**
	 * 获得所有的图书信息并通过分页显示
	 * @return 图书信息
	 */
	@Select("select * from books_info order by book_code limit #{arg0},#{arg1}")
	List<BooksInfo> getAllBooksByPage(int startIndex,int rows);
	/**
	 * 获得所有的图书记录条数
	 * @return
	 */
	@Select("select COUNT(books_info.id) from books_info")
	int getAllBoksInfoCount();
	/**
	 * 通过id获得图书信息
	 * @param id 图书id
	 * @return 图书信息
	 */
	@Select("select * from books_info where id = #{arg0}")
	BooksInfo getBooksById(String id);
	/**
	 * 添加数据
	 * @param BooksPress
	 * @return
	 */
	@Insert("insert into books_info (id,book_code,book_name,book_author,book_press,book_type,book_price,"
			+ "book_address,upload_image,book_image,register_date,book_state,book_profile) "
			+ "value(uuid(),#{bookCode},#{bookName},#{bookAuthor},#{bookPress},#{bookType},#{bookPrice},"
			+ "#{bookAddress},#{uploadImage},#{bookImage},#{registerDate},#{bookState},#{bookProfile})")
	public int insertBooksInfo(BooksInfo booksInfo);

	/**
	 * 修改数据
	 * @param BooksPress
	 * @return
	 */
	@Update("update books_info set book_code=#{bookCode},book_name=#{bookName},book_author=#{bookAuthor},"
			+ "book_press=#{bookPress},book_type=#{bookType},book_price=#{bookPrice},book_address=#{bookAddress},"
			+ "upload_image=#{uploadImage},book_image=#{bookImage},register_date=#{registerDate},book_state=#{bookState},book_profile=#{bookProfile} where id=#{id}")
	public int updateBooksInfo(BooksInfo booksInfo);
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	@Delete("DELETE from books_info where id in(${ids})")
	public int deleteBooksInfo(@Param(value="ids") String ids);
}
