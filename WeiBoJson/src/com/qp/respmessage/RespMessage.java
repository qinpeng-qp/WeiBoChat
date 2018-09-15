package com.qp.respmessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 回复文本消息
 * @author qp
 *
 */

public class RespMessage {
	/*{
		    "result": true,
		    "receiver_id":456,
		    "sender_id":123,
		    "type": "text",
		    "data":"{
		         "text": "中文消息"
		                 }"
		}
		 
		//返回样例
		{
		    "result":true,
		    "sender_id":"123",
		    "receiver_id":"456",
		    "type":"text",
		    "data":"%7B%22text%22%3A%22%E4%B8%AD%E6%96%87%E6%B6%88%E6%81%AF%22%7D"
		}
*/
	private boolean result;
	//接收者ID
	private String  receiver_id;
	//发送者ID
	private String sender_id;
	//消息类型
	private String type;
	
	private Object data ;
	


	


	
	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}


	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}
	
	
	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
	}
	/**
	 * @return the receiver_id
	 */
	public String getReceiver_id() {
		return receiver_id;
	}
	/**
	 * @param receiver_id the receiver_id to set
	 */
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	/**
	 * @return the sender_id
	 */
	public String getSender_id() {
		return sender_id;
	}
	/**
	 * @param sender_id the sender_id to set
	 */
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the data
	 *//*
	public String getData() {
		return data;
	}
	*//**
	 * @param data the data to set
	 *//*
	public void setData(String data) {
		this.data = data;
	}*/
	
	
	
	
}
