package com.qp.jsonutil;
/**
 * json处理的工具类
 */
import java.awt.font.TextMeasurer;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.TableUI;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.translate.demo.BaiDuTransLate;
import com.google.gson.Gson;
import com.qp.req.TextMessage;
import com.qp.respmessage.Articles;
import com.qp.respmessage.Data;
import com.qp.respmessage.RespMessage;
import com.qp.tools.TuLin;
import com.qp.type.MessageType;


public class JsonUtil {

	/***
	 * 获取 request 中 json 字符串的内容
	 * 
	 * @param request
	 * @return : <code>byte[]</code>
	 * @throws IOException
	 */

	TextMessage reqMessage;
	RespMessage respMessage;
	Data data;

	public String getRequestJsonString(HttpServletRequest request) throws IOException {
		String submitMehtod = request.getMethod();
		// GET
		if (submitMehtod.equals("GET")) {
			return new String(request.getQueryString().getBytes("iso-8859-1"), "utf-8").replaceAll("%22", "\"");
			// POST
		} else {
			return getRequestPostStr(request);
		}
	}

	/**
	 * 描述:获取 post 请求的 byte[] 数组
	 * 
	 * <pre>
	 * 举例：
	 * </pre>
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public byte[] getRequestPostBytes(HttpServletRequest request) throws IOException {
		int contentLength = request.getContentLength();
		if (contentLength < 0) {
			return null;
		}
		byte buffer[] = new byte[contentLength];
		for (int i = 0; i < contentLength;) {

			int readlen = request.getInputStream().read(buffer, i, contentLength - i);
			if (readlen == -1) {
				break;
			}
			i += readlen;
		}
		return buffer;
	}

	/**
	 * 描述:获取 post 请求内容
	 * 
	 * <pre>
	 * 举例：
	 * </pre>
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public String getRequestPostStr(HttpServletRequest request) throws IOException {
		byte buffer[] = getRequestPostBytes(request);
		String charEncoding = request.getCharacterEncoding();
		if (charEncoding == null) {
			charEncoding = "UTF-8";
		}
		return new String(buffer, charEncoding);
	}

	/**
	 * 获取request中的json将数据封装在类中
	 * 
	 * @throws IOException
	 */
	public void requestJson(HttpServletRequest request) throws IOException {
		reqMessage = new TextMessage();
		Gson gson = new Gson();
		// 获取request中的json
		String content = getRequestJsonString(request);
		//System.out.println(content);
		
		// 将json数据封装在请求消息类里面以便存取,封装在请求消息的类中，字段要一一对应
		// 调用谷歌json的fromJson方法将json数据转换为对象
		
		//JSONObject jsonObject = new JSONObject();
		/**
		 * 将json字符串转化为JSONOBJECT对象
		 * 通过getJSONObject("对象")获得指定的对象然后再获得需要的数据
		 *
		 */
		JSONObject jsonObject = JSONObject.parseObject(content);
		JSONObject jsdata = jsonObject.getJSONObject("data");
		//得到key将其封装在Data类中
		data.setKey(jsdata.getString("key"));
		//System.out.println("key"+jsdata.getString("key"));
		
		
		/*Data data = new Data();
		data = jsonObject.toJavaObject(json, Data.class);*/
		reqMessage = gson.fromJson(content, TextMessage.class);

		// JSON.parseObject(content);

		//System.out.println(reqMessage.toString());

	}

	/**
	 * 将javabean转换为JSON
	 * 
	 * @throws IOException
	 */
	public String javaToJson(HttpServletRequest request) throws IOException {
		respMessage = new RespMessage();
		data = new Data();
		Articles articles1 = new Articles();
		Articles articles2 = new Articles();
		Gson gson = new Gson();
		
		
		//从请求体获得JSON序列化为javabean
		requestJson(request);
		respMessage.setResult(true);
		// respMessage.setType("articles");
		respMessage.setReceiver_id(reqMessage.getSender_id());
		respMessage.setSender_id(reqMessage.getReceiver_id());
		//System.out.println(data.getKey());
		
		//菜单推送事件
		if(reqMessage.getType().equals("event")) {
			//bt1是创建菜单时设置的key
			if(data.getKey().equals("bt1")) {
				respMessage.setType("text");
				//调用图灵API,查询天气
				String weather = TuLin.getTuLinAnswer("黄冈天气");
				data.setText(weather);
			}else if(data.getKey().equals("bt2")) {
				respMessage.setType("text");
				data.setText("请输入你要翻译的句子，输入格式如"+"\"翻译你好啊\"");
			}
			
			
		}/*else if (reqMessage.getText().equals("1")) {
			respMessage.setType("text");
			String respContent = " 您好，欢迎关注我的微博！[微笑]";
			String content = URLEncoder.encode(respContent, "utf-8");
			data.setText(content);

		}*/else if(reqMessage.getText().startsWith("翻译")){
			//System.out.println(reqMessage.getText().substring(2));
			String transResp ="翻译内容为："+ BaiDuTransLate.transLate(reqMessage.getText().substring(2));
			respMessage.setType("text");
			data.setText(transResp);
			
			
		} else if (reqMessage.getText().equals("1") ||reqMessage.getText().equals("图文") ) {
			respMessage.setType("articles");

			articles1.setDisplay_name(URLEncoder.encode("测试", "utf-8"));
			articles1.setImage(URLEncoder.encode("http://storage.mcp.weibo.cn/0JlIv.jpg", "utf-8"));
			articles1.setUrl(URLEncoder
					.encode("http://e.weibo.com/mediaprofile/article/detail?uid=1722052204&aid=983319", "utf-8"));
			articles1.setSummary("图文。");

			articles2.setDisplay_name(URLEncoder.encode("测试", "utf-8"));
			articles2.setImage(URLEncoder.encode("http://storage.mcp.weibo.cn/0JlIv.jpg", "utf-8"));
			articles2.setUrl(URLEncoder
					.encode("http://e.weibo.com/mediaprofile/article/detail?uid=1722052204&aid=983319", "utf-8"));
			articles2.setSummary("图文。");
			data.getArticles().add(articles1);
			data.getArticles().add(articles2);
		}else if(reqMessage.getText().equals("地理位置")){
			//地理位置
			respMessage.setType(MessageType.POSITION);
			data.setLatitude("123.343434");
			data.setLongitude("344.3344");
			
			
		}else if(reqMessage.getText().equals("黄冈天气") || reqMessage.getText().equals("2")){
			TuLin lin = new TuLin();
			respMessage.setType("text");
			data.setText(URLEncoder.encode(lin.getTuLinAnswer("黄冈天气").toString(),"utf-8"));
			
		}else if(reqMessage.getText().equals("3") || reqMessage.getText().equals("电影推荐")){
			respMessage.setType("articles");

			articles1.setDisplay_name(URLEncoder.encode("我滴个神啊 ，极力推荐的一部印度片   云盘密码：yrs2", "utf-8"));
			articles1.setImage(URLEncoder.encode("http://img31.mtime.cn/mg/2015/10/25/171834.31683959.jpg", "utf-8"));
			articles1.setUrl(URLEncoder
					.encode("https://pan.baidu.com/s/1-__PZOqz85TJjHaWrO8EnQ", "utf-8"));
			articles1.setSummary("图文。");
			
			data.getArticles().add(articles1);
			
		}else {
			//配合图灵的回复
			String tuLinAnswer = TuLin.getTuLinAnswer(reqMessage.getText());
			respMessage.setType("text");
			String respContent =  tuLinAnswer+"\\n"+
									 "请回复以下关键字[鲜花]"+"\\n"
									+ "  1、 图文"+"\\n"
									+ "  2、黄冈天气"+"\\n"
									+ "  3、电影推荐   "+"\\n"
									+ "  4、翻译 "+"\\n"
									+"   直接输入翻译内容格式为："+"\\n"
								    +"翻译你好";
									
			String content = URLEncoder.encode(respContent, "utf-8");
			data.setText(content);

			
		}
		// 回复内容
		/*
		 * String respContent = " 您好，欢迎关注我的微博！[微笑]"; String content =
		 * URLEncoder.encode(respContent, "utf-8"); //respMessage.setData(data);
		 * data1.setText(content);
		 */
		// System.out.println(JSONObject.toJSON(data1));

		respMessage.setData(data);

		String json = gson.toJson(respMessage);
			
		return json;

	}

}
