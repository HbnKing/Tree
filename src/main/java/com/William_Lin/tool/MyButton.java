/*    */ package com.William_Lin.tool;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyButton
/*    */   extends JButton
/*    */ {
/*    */   private static final long serialVersionUID = 892658197710680505L;
/* 17 */   private ImageIcon icon = null;
/*    */   
/*    */   public MyButton(ImageIcon icon) {
/* 20 */     this.icon = icon;
/* 21 */     setOpaque(false);
/*    */   }
/*    */   
/*    */   protected void paintComponent(Graphics g) {
/* 25 */     g.drawImage(this.icon.getImage(), 0, 0, getWidth(), getHeight(), 
/* 26 */       this);
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tool\MyButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */