package com.sohu.business.utils;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.sohu.suc.platform.dao.DaoFactory;
import com.sohu.suc.platform.dao.IDao;
import com.sohu.suc.platform.ddd.ds.DataSourceFactory;
import com.sohu.suc.platform.ddd.ds.IDataSourceFactory;
import com.sohu.suc.platform.ddd.ds.impl.MultiProxyDataSourceFactory;

public class ProxyDataSourceFactory {
	static IDataSourceFactory defaultFactory;
	static IDao dao=null;
	//取得本地数据源的Idao
    public static IDao getLocalIDao(){
    	init();
    	if(dao!=null){
    		return dao;
    	}
    	dao=DaoFactory.getIDao();
    	return dao;
    }
    //代理本地数据源
    public static void init() {
        defaultFactory = DataSourceFactory.getInstance();
        
        MultiProxyDataSourceFactory factory = new MultiProxyDataSourceFactory();
        {
            factory.getDataSources().put("admin-app", buildDataSource("admin-app"));
          //  factory.getDataSources().put("guest", buildDataSource("guest"));
        }
        DataSourceFactory.setDataSourceFactory(factory);
    }

 //   获取本地数据源
    private static DataSource buildDataSource(String dbName) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/"+dbName);
        ds.setUsername("root");
        ds.setPassword("10344381");
        ds.setDefaultAutoCommit(true);
        return ds;
    }
   
   

}
