
package com.book.entity;

import java.io.Serializable;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月2日 下午2:27:58 

* 类说明  图书分类

*/

public class BooksType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//分类id
	private String id;
	//分类编号
	private String code;
	//分类名称
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
