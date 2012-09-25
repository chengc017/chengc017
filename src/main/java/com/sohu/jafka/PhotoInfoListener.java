package com.sohu.jafka;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

 /**
  * 系统启动监听类
  * @author xuewuhao
  *
  */
public class PhotoInfoListener implements ServletContextListener {
	private PhotoInfoThread photoInfoThread;

	public void contextDestroyed(ServletContextEvent e) {
		if (photoInfoThread != null && photoInfoThread.isInterrupted()) {
			photoInfoThread.interrupt();
		}
	}

	// servlet 上下文初始化时启动线程
	public void contextInitialized(ServletContextEvent e) {
		if (photoInfoThread == null) {
			photoInfoThread = new PhotoInfoThread();
			photoInfoThread.start();
		}
	}
}
