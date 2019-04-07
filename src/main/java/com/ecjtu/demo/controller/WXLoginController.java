package com.ecjtu.demo.controller;


import com.ecjtu.demo.common.*;
import com.ecjtu.demo.model.WXSessionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WXLoginController {
	
	@Autowired
	private RedisOperator redis;

	private static GuavaOperator guavaOperator = GuavaOperator.getInstance();


	@PostMapping("/wxLogin2" )
	public IMoocJSONResult wxLogin2(String code) {
		
		System.out.println("wxlogin - code: " + code);
		
//		https://api.weixin.qq.com/sns/jscode2session?
//				appid=APPID&
//				secret=SECRET&
//				js_code=JSCODE&
//				grant_type=authorization_code
		
		String url = "https://api.weixin.qq.com/sns/jscode2session";
		Map<String, String> param = new HashMap<>();
		param.put("appid", "wx840572e0f601a9da");
		param.put("secret", "1f110c4b4d0ecbfe474731d6dd9f8ec8");
		param.put("js_code", code);
		param.put("grant_type", "authorization_code");
		
		String wxResult = HttpClientUtil.doGet(url, param);
		//System.out.println(wxResult);

		/**
		 * 将 httpget  请求的结果 转为 jsonObject
		 */
		WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);


		System.out.println(model.getOpenid());
		System.out.println(model.getSession_key());
		HttpHeaders headers=new HttpHeaders();
		headers.add("sessionId" ,model.getSession_key());
		// 存入session到redis
//		redis.set("user-redis-session:" + model.getOpenid(), 
//							model.getSession_key(), 
//							1000 * 60 * 30);


		guavaOperator.setData(model.getSession_key(),model.getOpenid());
		
		return IMoocJSONResult.ok(headers);
	}


	//demo
	@RequestMapping(value="/delete", method= RequestMethod.GET)
	public ResponseEntity<Void> deleteById(@RequestParam( value ="id",defaultValue = "")String id) {

		return ResponseEntity.noContent().build();
	}


	/**
	 * 修改后的登录方法
	 * @param code
	 * @return
	 */
	//@RequestMapping("/wxLogin" )
	@PostMapping("/wxLogin" )
	public ResponseEntity<IMoocJSONResult> wxLogin(@RequestParam (value = "code")String code) {

		System.out.println("wxlogin - code: " + code);
		//System.out.println("client session is :" +clientSession);

//		https://api.weixin.qq.com/sns/jscode2session?
//				appid=APPID&
//				secret=SECRET&
//				js_code=JSCODE&
//				grant_type=authorization_code

		String url = "https://api.weixin.qq.com/sns/jscode2session";
		Map<String, String> param = new HashMap<>();
		param.put("appid", "wx840572e0f601a9da");
		param.put("secret", "1f110c4b4d0ecbfe474731d6dd9f8ec8");
		param.put("js_code", code);
		param.put("grant_type", "authorization_code");

		String wxResult = HttpClientUtil.doGet(url, param);
		//System.out.println(wxResult);

		/**
		 * 将 httpget  请求的结果 转为 jsonObject
		 */
		WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);


		System.out.println(model.getOpenid());
		System.out.println(model.getSession_key());
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("sessionId" ,model.getSession_key());
		// 存入session到redis
//		redis.set("user-redis-session:" + model.getOpenid(),
//							model.getSession_key(),
//							1000 * 60 * 30);


		/**
		 * 保存 session_key  和  openId  到 缓存中
		 */
		guavaOperator.setData(model.getSession_key(),model.getOpenid());



		return ResponseEntity.ok().headers(httpHeaders).body(IMoocJSONResult.ok());
	}
	
}
