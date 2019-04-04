package com.ecjtu.demo.entity;

     
	 public enum Sex {
	     MAN('m'),
	     WOMAN('w');

	     public void setValue(char value) {
			this.value = value;
		}
		private char value;
	     Sex(char value) {
	         this.value = value;
	     }
	     public char getValue() {
	         return value;
	     }
	     
	 }
	 
	 
	 
