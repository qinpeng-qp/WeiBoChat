package com.qp.respmessage;

public class Articles {
	
	/*{
		    "result": true,
		    "receiver_id":456,
		    "sender_id":123,
		    "type": "articles",
		    "data": {
		    "articles": [
		        {
		            "display_name": "两个故事",
		            "summary": "今天讲两个故事，分享给你。谁是公司？谁又是中国人？​",
		            "image": "http://storage.mcp.weibo.cn/0JlIv.jpg",
		            "url": "http://e.weibo.com/mediaprofile/article/detail?uid=1722052204&aid=983319"
		        },
		        ... //最多支持8个图文，建议为1或3个
		    ]
		 }
		}*/
	
	private String display_name;//图文的显示名称标题
	private String summary;	//图文的文字描述，大于等于2个图文时，仅显示第一个图文的描述
	private String image;	//图文的缩略显示图片，需为JPG、PNG格式，单图及多图
	private String url;		//图文的URL地址，点击后跳转（注：该url必须为完整的url，例如， http://weibo.com/xxx ，如果省略掉”http:// “，则无法发送图文消息）
	/**
	 * @return the display_name
	 */
	public String getDisplay_name() {
		return display_name;
	}
	/**
	 * @param display_name the display_name to set
	 */
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
