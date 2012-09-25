package com.sohu.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sohu.business.service.impl.UserService;

/**
 * @author chengchengbj8545
 *用户管理
 */
@Controller

public class UserController {
	@Autowired
	private UserService userService;
	
	
	/**
	 * 
	 *进入登陆页面
	 */
	@RequestMapping("login")
	public ModelAndView in_login(){
		ModelAndView mv=new ModelAndView("login");
		return mv;
	}
	
	/**
	 * 进行登陆验证
	 * 
	 *
	 */
	@RequestMapping("user!login.action")
	public ModelAndView login(
			@RequestParam(value="password",required=true)String password,
			@RequestParam(value="userName",required=true)String userName
			){
		//进行登陆验证
		boolean flag=userService.isLoginUser(userName, password);
		ModelAndView mv=null;
		if(flag){
			mv=new ModelAndView("managerAccountPassport");
			return mv;
		}
		mv=new ModelAndView("login");
		return mv;
	}
	
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
