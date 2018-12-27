package com.dreamlee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

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
		String data = "小贾";
		mv.addObject("data", data);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/login")
	public String login(String username, String password, Model model) {
		String username_utf8 = null;
		try {
			username_utf8 = new String(username.getBytes("iso8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//String username_utf-8 = new String(usernameBytes, "UTF-8");
		model.addAttribute("username", username_utf8);
		model.addAttribute("password", password);
		return "success";
	}
}
