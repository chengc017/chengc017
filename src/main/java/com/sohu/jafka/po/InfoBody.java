package com.sohu.jafka.po;
/**
 * 消息记录
 * {image_id: 'aEgfsg23Df', folder_id:'HqBY3gsN', folder_name:'幸福生活'
		created_at:2012-08-19 22:20:12,
		image_original_name:'hello.jpg', image_original_width:1024, 
		image_original_height:768,
		folder_creator:'kaktos@sohu.com', tag_list:"美女|少女|萌"}
 * @author xuewuhao
 *
 */
public class InfoBody {
	
	/**
	 * 图片id
	 */
	private String image_id;
	/**
	 * 专辑id
	 */
	private String folder_id;
	/**
	 * 专辑名称
	 */
	private String folder_name;
	/**
	 * 图片创建时间
	 */
	private String created_at;
	/**
	 * 图片名称 
	 */
	private String image_original_name;
	/**
	 * 图片宽度
	 */
	private int image_original_width;
	/**
	 * 图片高度
	 */
	private int image_original_height;
	/**
	 * 专辑所有者
	 */
	private String folder_creator;
	/**
	 * 图片标签
	 */
	private String tag_list;
	
	
	public InfoBody(String image_id, String folder_id, String folder_name, String created_at,
			String image_original_name, int image_original_width, int image_original_height, String folder_creator,
			String tag_list) {
		super();
		this.image_id = image_id;
		this.folder_id = folder_id;
		this.folder_name = folder_name;
		this.created_at = created_at;
		this.image_original_name = image_original_name;
		this.image_original_width = image_original_width;
		this.image_original_height = image_original_height;
		this.folder_creator = folder_creator;
		this.tag_list = tag_list;
	}


	public String getImage_id() {
		return image_id;
	}


	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}


	public String getFolder_id() {
		return folder_id;
	}


	public void setFolder_id(String folder_id) {
		this.folder_id = folder_id;
	}


	public String getFolder_name() {
		return folder_name;
	}


	public void setFolder_name(String folder_name) {
		this.folder_name = folder_name;
	}


	public String getCreated_at() {
		return created_at;
	}


	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}


	public String getImage_original_name() {
		return image_original_name;
	}


	public void setImage_original_name(String image_original_name) {
		this.image_original_name = image_original_name;
	}


	public int getImage_original_width() {
		return image_original_width;
	}


	public void setImage_original_width(int image_original_width) {
		this.image_original_width = image_original_width;
	}


	public int getImage_original_height() {
		return image_original_height;
	}


	public void setImage_original_height(int image_original_height) {
		this.image_original_height = image_original_height;
	}


	public String getFolder_creator() {
		return folder_creator;
	}


	public void setFolder_creator(String folder_creator) {
		this.folder_creator = folder_creator;
	}


	public String getTag_list() {
		return tag_list;
	}


	public void setTag_list(String tag_list) {
		this.tag_list = tag_list;
	}
	
	
}
