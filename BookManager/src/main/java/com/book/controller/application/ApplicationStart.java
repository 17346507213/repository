package com.book.controller.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication(scanBasePackages={"com.book.controller.*","com.book.service.impl"})
@MapperScan(value = "com.book.mapper")
public class ApplicationStart {
	public static void main(String[] args) {
		//启动程序
		SpringApplication.run(ApplicationStart.class, args);
	}
	
}
