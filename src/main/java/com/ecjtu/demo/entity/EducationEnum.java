package com.ecjtu.demo.entity;

public enum EducationEnum {



	//未选(0,"未选"),Primary (1,"小学") ,Junior (2,"初中") ,High(3,"高中"),University(4,"大学"),Universitys(5,"大学以上");
	//ENUM('未选', '小学', '初中', '高中', '大学', '大学以上')
	//ENUM('未选', 'Primary', 'Junior', 'High', 'University', 'Universitys')
	未选(0,"未选"),小学 (1,"小学") ,初中 (2,"初中") ,高中(3,"高中"),大学(4,"大学"),大学以上(5,"大学以上");
	private Integer code;
	private String discribe;
	public Integer getCode() {
		return code;
	}
	public String getDiscribe() {
		return discribe;
	}
	private EducationEnum(Integer code ,String discribe) {
		this.code = code;
		this.discribe = discribe;
	}

}
	 