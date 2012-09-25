package com.sohu.business.service.impl;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;

import com.sohu.business.model.pojo.AccountPassport;

public class AccountPassportServiceTest {
	private final static Logger logger=org.slf4j.LoggerFactory.getLogger(AccountPassportServiceTest.class);
	@Test
	public void getAccountsTest(){
		AccountPassportServiceImpl accountService=new AccountPassportServiceImpl();
		/*AccountPassport account=new AccountPassport();
		account.setPassport("chengyq2281@sina.com");*/
		List<AccountPassport> accounts=accountService.getAccountsFromPassport("chengyq2281@sina.com", 0, 10);
		logger.info("size:"+accounts.size());
	}
	@Test
	public void saveAccountTest(){
		AccountPassportServiceImpl accountService=new AccountPassportServiceImpl();
		AccountPassport account=new AccountPassport();
		account.setPassport("chengyq221@sina.com");
		account.setMemo("chengc221");
		int count=accountService.saveAccountPassport(account);
		logger.info("count"+count);
	}
	@Test
	public void updateAccountTest(){
		AccountPassportServiceImpl accountService=new AccountPassportServiceImpl();
		AccountPassport account=new AccountPassport();
		account.setId(1);
		account.setPassport("chengyq22122@sina.com");
		account.setMemo("chengc221cc");
		int count=accountService.updateAccountPassport(account);
		logger.info("count"+count);
	}
	@Test
	public void deleteAccountTest(){
		AccountPassportServiceImpl accountService=new AccountPassportServiceImpl();
		
		
		int count=accountService.deleteAccountPassportById(1);
		logger.info("count"+count);
	}
}
