package com.sohu.jafka;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sohu.jafka.po.InfoBody;
import com.sohu.suc.platform.core.cache.ICacheFactory;
import com.sohu.suc.platform.mq.jafka.Consumers;
import com.sohu.suc.platform.mq.jafka.IMessageListener;

/**
 * 接收相册发送的图片消息
 * 
 * @author xuewuhao
 * 
 */
public class FetchPhotoSimpleHandler {
	@Autowired
	private ICacheFactory cacheFactory;
	private static final Logger logger = LoggerFactory.getLogger(FetchPhotoSimpleHandler.class);

	public void infoHandler() {
		Consumers.buildConsumer("account", "square", new IMessageListener<String>() {
			public void onMessage(String message) {
				System.out.println(message + " ==> " + new Date());
			}
		});
	}

	/**
	 * 
	 * @param message
	 */
	public void doInfo(String message) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		try {
			Map<String, Object> map = mapper.readValue(message, Map.class);
		} catch (JsonParseException jpe) {
			logger.error("JsonParseException", jpe);
		} catch (Exception e) {
			logger.error("Exception", e);
		}

	}
	
	public static void main(String a[]){
		FetchPhotoSimpleHandler p  = new FetchPhotoSimpleHandler();
		p.doInfo("{image_id: 'aEgfsg23Df', folder_id:'HqBY3gsN', folder_name:'幸福生活',created_at:'2012-08-19 22:20:12',image_original_name:'hello.jpg', image_original_width:1024,image_original_height:768,folder_creator:'kaktos@sohu.com', tag_list:'美女|少女|萌'}");
	}
}
