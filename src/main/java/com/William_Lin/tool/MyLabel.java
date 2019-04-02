/*    */ package com.William_Lin.tool;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyLabel
/*    */   extends JLabel
/*    */ {
/*    */   private static final long serialVersionUID = -4524582496714078475L;
/* 18 */   private ImageIcon icon = null;
/*    */   
/*    */   public MyLabel(ImageIcon icon) {
/* 21 */     this.icon = icon;
/* 22 */     setOpaque(false);
/*    */   }
/*    */   
/*    */   protected void paintComponent(Graphics g) {
/* 26 */     g.drawImage(this.icon.getImage(), 0, 0, getWidth(), getHeight(), 
/* 27 */       this);
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tool\MyLabel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */