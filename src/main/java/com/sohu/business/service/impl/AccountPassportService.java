package com.sohu.business.service.impl;

import java.util.List;

import com.sohu.business.model.pojo.AccountPassport;

public interface AccountPassportService {
	public List<AccountPassport> getAccountsFromPassport(final String passport,final int start,final int end);
	public int saveAccountPassport(AccountPassport accountPassport);
	public int updateAccountPassport(AccountPassport accountPassport);
	public int deleteAccountPassportById(int id);
}
