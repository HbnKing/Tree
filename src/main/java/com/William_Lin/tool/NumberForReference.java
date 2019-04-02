/*    */ package com.William_Lin.tool;
/*    */ 
/*    */ 
/*    */ public class NumberForReference<N extends Number>
/*    */ {
/*    */   private N n;
/*    */   
/*    */ 
/*    */   public NumberForReference()
/*    */   {
/* 11 */     this.n = null;
/*    */   }
/*    */   
/*    */   public NumberForReference(N n)
/*    */   {
/* 16 */     this.n = n;
/*    */   }
/*    */   
/*    */   public N getNumber() {
/* 20 */     return this.n;
/*    */   }
/*    */   
/*    */   public void setNumber(N n) {
/* 24 */     this.n = n;
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tool\NumberForReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */