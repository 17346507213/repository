
package com.book.controller.application;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年4月4日 下午2:07:56 

* 类说明 

*/
@Configuration
@ConfigurationProperties(prefix="custom")
@PropertySource("classpath:custom.properties")
public class CustomProperties {
	/**
	 * 图书照片的存放路径
	 */
	private String uploadBookFileUrl;

	public String getUploadBookFileUrl() {
		return uploadBookFileUrl;
	}

	public void setUploadBookFileUrl(String uploadBookFileUrl) {
		this.uploadBookFileUrl = uploadBookFileUrl;
	}
	
}
