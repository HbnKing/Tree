/*    */ package com.William_Lin.tool;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.FlowLayout;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ButtonPanel
/*    */   extends MyPanel
/*    */ {
/*    */   private static final long serialVersionUID = 2038569188213387804L;
/*    */   private JButton resetButton;
/*    */   private JButton okButton;
/*    */   private JButton cancelButton;
/*    */   
/*    */   public ButtonPanel(ImageIcon icon)
/*    */   {
/* 25 */     super(icon);
/* 26 */     setLayout(new FlowLayout(1));
/* 27 */     setPreferredSize(new Dimension(200, 50));
/* 28 */     setBackground(new Color(222, 222, 222));
/* 29 */     setBorder(new EmptyBorder(5, 5, 5, 5));
/*    */     
/* 31 */     this.resetButton = new JButton("重置");
/* 32 */     add(this.resetButton);
/*    */     
/* 34 */     this.okButton = new JButton("确定");
/* 35 */     add(this.okButton);
/*    */     
/* 37 */     this.cancelButton = new JButton("取消");
/* 38 */     add(this.cancelButton);
/*    */   }
/*    */   
/*    */   public JButton getResetButton() {
/* 42 */     return this.resetButton;
/*    */   }
/*    */   
/*    */   public JButton getOkButton() {
/* 46 */     return this.okButton;
/*    */   }
/*    */   
/*    */   public JButton getCancelButton() {
/* 50 */     return this.cancelButton;
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tool\ButtonPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */