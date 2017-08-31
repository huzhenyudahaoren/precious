package cn.e3.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController{
	//在地址栏上如果写的是 localhost:8080/index  
	//那么 page 就为index,传递进来的参数也是index,返回的页面是index.jsp
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
		
		return page;
	}
}
