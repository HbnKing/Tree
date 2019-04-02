/*    */ package com.William_Lin.tool;
/*    */ 
/*    */ import javax.swing.text.AttributeSet;
/*    */ import javax.swing.text.BadLocationException;
/*    */ import javax.swing.text.PlainDocument;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LengthLimitedDmt
/*    */   extends PlainDocument
/*    */ {
/*    */   private static final long serialVersionUID = 7440980776709152223L;
/*    */   private int limit;
/*    */   
/*    */   public LengthLimitedDmt(int limit)
/*    */   {
/* 21 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
/*    */   {
/* 26 */     if (str == null) {
/* 27 */       return;
/*    */     }
/* 29 */     if (getLength() + str.length() <= this.limit)
/*    */     {
/* 31 */       char[] upper = str.toCharArray();
/* 32 */       int length = 0;
/* 33 */       for (int i = 0; i < upper.length; i++) {
/* 34 */         upper[(length++)] = upper[i];
/*    */       }
/* 36 */       super.insertString(offset, new String(upper, 0, length), attr);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tool\LengthLimitedDmt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */