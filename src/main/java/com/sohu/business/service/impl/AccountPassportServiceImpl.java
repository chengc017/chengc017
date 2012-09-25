package com.sohu.business.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.sohu.business.model.pojo.AccountPassport;
import com.sohu.business.utils.ProxyDataSourceFactory;
import com.sohu.suc.platform.dao.IDao;
import com.sohu.suc.platform.dao.OpList;
import com.sohu.suc.platform.dao.OpUpdate;

public class AccountPassportServiceImpl implements AccountPassportService{
	private final IDao dao = ProxyDataSourceFactory.getLocalIDao();
	private final String bizName = "admin-app";
	//通过passport获取通行证，数据库中有可能存在重复，这时需要查出来，使得管理员去删除
	public List<AccountPassport> getAccountsFromPassport(final String passport,final int start,final int end){
		
	        
	        List<AccountPassport> accountPassportS = dao.queryList(new OpList<AccountPassport>("select ID,PASSPORT,MEMO,C_DATE from ACCOUNT_PASSPORT where PASSPORT=? limit ?,?", bizName) {

	            @Override
	            protected void setParams(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, passport);
	            	ps.setInt(2, start);
	                ps.setInt(3, end);
	            }

	            @Override
	            protected AccountPassport parse(ResultSet rs) throws SQLException {
	            	AccountPassport accountPassport = new AccountPassport();
	            	accountPassport.setId(rs.getInt("ID"));
	            	accountPassport.setPassport(rs.getString("PASSPORT"));
	                accountPassport.setMemo(rs.getString("MEMO"));
	                accountPassport.setC_date(rs.getDate("C_DATE"));
	                return accountPassport;
	            }
	        });
	        return accountPassportS;
	        
	}
	//保存通行证
	public int saveAccountPassport(AccountPassport accountPassport){
		
		OpUpdate op = new OpUpdate("insert into ACCOUNT_PASSPORT(PASSPORT,MEMO,C_DATE) values(?,?,?)", bizName);
		op.addParams(accountPassport.getPassport(),accountPassport.getMemo(),new Date());
		int count = dao.update(op);
		return count;
	}
	//更新通行证
	public int updateAccountPassport(AccountPassport accountPassport){
		
		OpUpdate op = new OpUpdate("update ACCOUNT_PASSPORT set PASSPORT=?,MEMO=? where ID=?", bizName);
		op.addParams(accountPassport.getPassport(),accountPassport.getMemo(),accountPassport.getId());
		int count = dao.update(op);
		return count;
	}
	//删除通行证
	public int deleteAccountPassportById(int id){
		OpUpdate op = new OpUpdate("delete from ACCOUNT_PASSPORT where ID=?",bizName);
		op.addParams(id);
		int count =dao.update(op);
		return count;
	}
}
