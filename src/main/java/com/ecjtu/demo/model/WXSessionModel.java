package com.ecjtu.demo.model;

public class WXSessionModel {

	private String session_key;
	private String openid;
	private long errcode ;
	private String errmsg ;

	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
