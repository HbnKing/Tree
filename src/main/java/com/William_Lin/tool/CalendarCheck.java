/*    */ package com.William_Lin.tool;
/*    */ 
/*    */ 
/*    */ public class CalendarCheck
/*    */ {
/*    */   public int year;
/*    */   
/*    */   public int month;
/*    */   public int day;
/*    */   
/*    */   public CalendarCheck(String year2, String month2, String day2)
/*    */   {
/* 13 */     this.day = Integer.parseInt(day2);
/* 14 */     this.month = Integer.parseInt(month2);
/* 15 */     this.year = Integer.parseInt(year2);
/*    */   }
/*    */   
/*    */   public boolean CheckResult() {
/* 19 */     if (this.month == 2) {
/* 20 */       if (((this.year % 4 == 0) && (this.year % 100 != 0)) || (this.year % 400 == 0)) {
/* 21 */         if (this.day > 29) {
/* 22 */           return false;
/*    */         }
/* 24 */         return true; }
/* 25 */       if (this.day > 28) {
/* 26 */         return false;
/*    */       }
/* 28 */       return true; }
/* 29 */     if (((this.month == 2) || (this.month == 4) || (this.month == 6) || (this.month == 9) || 
/* 30 */       (this.month == 11)) && 
/* 31 */       (this.day == 31)) {
/* 32 */       return false;
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tool\CalendarCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */