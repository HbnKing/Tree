/*    */ package com.William_Lin.tool;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.FlowLayout;
/*    */ import java.awt.Font;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JTextField;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TextFieldSearchPanel
/*    */   extends MyPanel
/*    */ {
/*    */   private static final long serialVersionUID = 868027049144327208L;
/*    */   private JLabel inputLabel;
/*    */   private JTextField inputTextField;
/*    */   
/*    */   public TextFieldSearchPanel(ImageIcon icon)
/*    */   {
/* 24 */     super(icon);
/* 25 */     setLayout(new FlowLayout(1, 5, 5));
/* 26 */     setPreferredSize(new Dimension(230, 0));
/* 27 */     setBackground(new Color(255, 255, 255));
/* 28 */     setBorder(new EmptyBorder(5, 5, 5, 5));
/*    */     
/* 30 */     this.inputLabel = new JLabel();
/* 31 */     add(this.inputLabel);
/* 32 */     this.inputLabel.setFont(new Font("隶书", 1, 16));
/*    */     
/* 34 */     this.inputTextField = new JTextField();
/* 35 */     add(this.inputTextField);
/*    */   }
/*    */   
/*    */   public JLabel getInputLabel()
/*    */   {
/* 40 */     return this.inputLabel;
/*    */   }
/*    */   
/*    */   public JTextField getInputTextField() {
/* 44 */     return this.inputTextField;
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tool\TextFieldSearchPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */