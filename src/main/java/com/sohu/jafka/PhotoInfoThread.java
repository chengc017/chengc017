package com.sohu.jafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 启动线程读取消息
 * @author xuewuhao
 *
 */
public class PhotoInfoThread extends Thread {
	private static final Logger logger = LoggerFactory.getLogger(PhotoInfoThread.class);
	public void run() {
		// 线程未中断执行循环
		while (!this.isInterrupted()) {
			try {
				FetchPhotoSimpleHandler handler = new FetchPhotoSimpleHandler();
				handler.infoHandler();
				Thread.sleep(2000); // 每隔2000ms执行一次
			} catch (InterruptedException e) {
				logger.error("", e);
			}

		}
	}

}
