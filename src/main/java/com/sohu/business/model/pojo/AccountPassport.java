package com.sohu.business.model.pojo;

import java.util.Date;

public class AccountPassport {
	private int id;
	//passport
	private String passport;
	//备注
	private String memo;
	//创建时间
	private Date c_date;
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
