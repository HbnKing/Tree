package com.ecjtu.demo.entity;


public enum SexEnum {
	//MALE(0,"男") ,FEMALE(1,"女") ,UNKNOWN(2,"未定义");

	男(0,"男") ,女(1,"女") ;
	private Integer code;
	private String discribe;
	public Integer getCode() {
		return code;
	}
	public String getDiscribe() {
		return discribe;
	}
	private SexEnum(Integer code ,String discribe) {
		this.code = code;
		this.discribe = discribe;
	}

}
	 
	 
	 
