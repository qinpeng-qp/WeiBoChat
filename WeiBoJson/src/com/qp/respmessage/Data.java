package com.qp.respmessage;
import java.util.ArrayList;
import java.util.List;
/**
 * 封装data里面的属性
 * @author qp
 *
 */
public class Data {
	//文本内容
	private String text;
	//
	private String key;
	
	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}



	//文章
	private List<Articles> articles = new ArrayList<Articles>();
	
	//地理位置
	private String  longitude;	//经度
	private String latitude;	//纬度











	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}



	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}



	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	

	/**
	 * @return the articles
	 */
	public List<Articles> getArticles() {
		return articles;
	}



	/**
	 * @param articles the articles to set
	 */
	public void setArticles(List<Articles> articles) {
		this.articles = articles;
	}



	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
