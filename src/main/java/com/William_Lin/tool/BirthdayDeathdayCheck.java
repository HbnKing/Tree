/*    */ package com.William_Lin.tool;
/*    */ 
/*    */ 
/*    */ public class BirthdayDeathdayCheck
/*    */ {
/*    */   int year;
/*    */   
/*    */   int month;
/*    */   
/*    */   int day;
/*    */   
/* 12 */   int[] birthdayInteger = new int[3];
/*    */   
/*    */   public BirthdayDeathdayCheck(String year1, String month1, String day1, String birthday)
/*    */   {
/* 16 */     this.day = Integer.parseInt(day1);
/* 17 */     this.month = Integer.parseInt(month1);
/* 18 */     this.year = Integer.parseInt(year1);
/* 19 */     String[] birthdayString = birthday.split("-");
/* 20 */     for (int i = 0; i < birthdayString.length; i++) {
/* 21 */       this.birthdayInteger[i] = Integer.parseInt(birthdayString[i]);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean DateCheckResult() {
/* 26 */     if (this.year > this.birthdayInteger[0])
/* 27 */       return true;
/* 28 */     if (this.year == this.birthdayInteger[0]) {
/* 29 */       if (this.month > this.birthdayInteger[1])
/* 30 */         return true;
/* 31 */       if (this.month == this.birthdayInteger[1]) {
/* 32 */         if (this.day > this.birthdayInteger[2]) {
/* 33 */           return true;
/*    */         }
/* 35 */         return false;
/*    */       }
/* 37 */       return false;
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tool\BirthdayDeathdayCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */