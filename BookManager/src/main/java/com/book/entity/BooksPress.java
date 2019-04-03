
package com.book.entity;

import java.io.Serializable;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月2日 下午6:20:24 

* 类说明  出版社

*/

public class BooksPress implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String pressName;
	private String pressAddress;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPressName() {
		return pressName;
	}
	public void setPressName(String pressName) {
		this.pressName = pressName;
	}
	public String getPressAddress() {
		return pressAddress;
	}
	public void setPressAddress(String pressAddress) {
		this.pressAddress = pressAddress;
	}
	
}
