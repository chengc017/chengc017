package com.sohu.business.model.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	private static final long serialVersionUID = 6272070972327529190L;

	private int id;
	
	private String userName;
	private String passwd;
	//账号创建时期
	private Date c_date;
	//用户状态
	private int user_status;
	//用户是否已经登录
	private boolean login_status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	public int getUser_status() {
		return user_status;
	}
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
	public boolean isLogin_status() {
		return login_status;
	}
	public void setLogin_status(boolean login_status) {
		this.login_status = login_status;
	}
	
}
