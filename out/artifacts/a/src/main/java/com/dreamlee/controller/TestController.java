package com.dreamlee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	//指定url到请求方法的映射
	//url中输入一个地址，找到这个方法
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		//模型和视图
		//model：模型对象中存放了返回给页面的数据
		//view：视图对象中存放了返回的页面的位置
		ModelAndView mv = new ModelAndView();
		String data = "DYY";
		mv.addObject("data", data);
		mv.setViewName("NewFile");
		return mv;
	}
}
