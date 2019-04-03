
package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.book.entity.BooksType;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月2日 下午2:41:02 

* 类说明 

*/

public interface BooksTypeMapper {
	/**
	 * 查询所有的图书分类信息
	 * @return
	 */
	@Select("select * from books_type order by code")
	public List<BooksType> getAllBooksType();
	/**
	 * 添加数据
	 * @param booksType
	 * @return
	 */
	@Insert("insert into books_type (id,code,name) value(uuid(),#{code},#{name})")
	public int insertBooksType(BooksType booksType);
	/**
	 * 通过id得到一条数据
	 * @param id
	 * @return
	 */
	@Select("select * from books_type m where m.id = #{arg0}")
	public BooksType getBooksTypeById(String id);
	/**
	 * 修改数据
	 * @param booksType
	 * @return
	 */
	@Update("update books_type set code=#{code},name=#{name} where id=#{id}")
	public int updateBooksType(BooksType booksType);
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	@Delete("DELETE from books_type where id in(${ids})")
	public int deleteBooksType(@Param(value="ids") String ids);
}
