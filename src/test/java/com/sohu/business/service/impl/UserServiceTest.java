package com.sohu.business.service.impl;

import org.junit.Test;
import org.slf4j.Logger;



public class UserServiceTest{
		private final static Logger logger=org.slf4j.LoggerFactory.getLogger(UserServiceTest.class);
	   @Test
	    public void testGetUser() {
		   UserServiceImpl userService=new UserServiceImpl();
		   boolean flag=userService.isLoginUser("chengc", "123");
		   //userService.insertUser();
	        logger.info("flag:"+flag);
	   }
}
