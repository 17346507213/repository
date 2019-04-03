
package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.book.entity.BooksAuthor;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月3日 下午1:21:28 

* 类说明 

*/

public interface BooksAuthorMapper {
	/**
	 * 查询所有的信息
	 * @return
	 */
	@Select("select * from books_author order by author_name")
	public List<BooksAuthor> getAllBooksAuthor();
	/**
	 * 分页查询数据
	 * @param startIndex
	 * @param rows
	 * @return
	 */
	@Select("select * from books_author order by author_name LIMIT #{arg0},#{arg1}")
	public List<BooksAuthor> getAllBooksAuthorByPage(int startIndex,int rows);
	/**
	 * 获得所有的数据条数
	 * @return
	 */
	@Select("select COUNT(books_author.id) from books_author")
	public int getAllBooksAuthorCount();
	/**
	 * 添加数据
	 * @param BooksAuthor
	 * @return
	 */
	@Insert("insert into books_author (id,author_name,author_sex,author_nationality,author_Profile)"
			+ " value(uuid(),#{authorName},#{authorSex},#{authorNationality},#{authorProfile})")
	public int insertBooksAuthor(BooksAuthor booksAuthor);
	/**
	 * 通过id得到一条数据
	 * @param id
	 * @return
	 */
	@Select("select * from books_author m where m.id = #{arg0}")
	public BooksAuthor getBooksAuthorById(String id);
	/**
	 * 修改数据
	 * @param BooksAuthor
	 * @return
	 */
	@Update("update books_author set author_name=#{authorName},"
			+ "author_nationality=#{authorNationality},author_sex=#{authorSex},author_Profile=#{authorProfile} where id=#{id}")
	public int updateBooksAuthor(BooksAuthor booksAuthor);
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	@Delete("DELETE from books_author where id in(${ids})")
	public int deleteBooksAuthor(@Param(value="ids") String ids);
}
