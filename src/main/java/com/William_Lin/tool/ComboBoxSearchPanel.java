/*    */ package com.William_Lin.tool;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.FlowLayout;
/*    */ import java.awt.Font;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JComboBox;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ComboBoxSearchPanel
/*    */   extends MyPanel
/*    */ {
/*    */   private static final long serialVersionUID = -8820659399895429917L;
/*    */   private JComboBox inputComboBox;
/*    */   private JLabel inputLabel;
/*    */   
/*    */   public ComboBoxSearchPanel(ImageIcon icon)
/*    */   {
/* 25 */     super(icon);
/* 26 */     setLayout(new FlowLayout(1, 5, 5));
/* 27 */     setPreferredSize(new Dimension(230, 0));
/* 28 */     setBackground(new Color(255, 255, 255));
/* 29 */     setBorder(new EmptyBorder(5, 5, 5, 5));
/*    */     
/* 31 */     this.inputLabel = new JLabel();
/* 32 */     add(this.inputLabel);
/* 33 */     this.inputLabel.setFont(new Font("隶书", 1, 16));
/*    */     
/* 35 */     this.inputComboBox = new JComboBox();
/* 36 */     add(this.inputComboBox);
/*    */   }
/*    */   
/*    */   public JLabel getInputLabel() {
/* 40 */     return this.inputLabel;
/*    */   }
/*    */   
/*    */   public JComboBox getInputComboBox() {
/* 44 */     return this.inputComboBox;
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tool\ComboBoxSearchPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */