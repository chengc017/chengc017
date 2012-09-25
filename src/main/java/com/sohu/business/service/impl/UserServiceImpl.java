package com.sohu.business.service.impl;

import com.sohu.business.utils.ProxyDataSourceFactory;
import com.sohu.suc.platform.dao.IDao;
import com.sohu.suc.platform.dao.OpUniq;

public class UserServiceImpl implements UserService {
	private final IDao dao = ProxyDataSourceFactory.getLocalIDao();

	private final String bizName = "admin-app";

	
//验证用户登录
	public boolean isLoginUser(final String userName, final String password) {

		StringBuilder sqlBuffer = new StringBuilder();
		sqlBuffer.append("select ID from USER");

		sqlBuffer.append(" where USER_NAME = ? and PASSWD=? and LOGIN_STATUS=? and STATUS=?");
		String sql = sqlBuffer.toString();
	    Boolean b = dao.queryUniq(new OpUniq.ExistOpUniq(sql, bizName) .addParams(userName,password,0,1)
        );
	    return b;

	}

}
