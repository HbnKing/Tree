/*    */ package com.William_Lin.tool;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.FlowLayout;
/*    */ import java.awt.Font;
/*    */ import javax.swing.ButtonGroup;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JRadioButton;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RadioButtonSearchPanel
/*    */   extends MyPanel
/*    */ {
/*    */   private static final long serialVersionUID = 1415179733693030113L;
/*    */   private JLabel inputLabel;
/*    */   private JRadioButton yesButton;
/*    */   private JRadioButton noButton;
/*    */   private ButtonGroup choiceButtonGroup;
/*    */   
/*    */   public RadioButtonSearchPanel(ImageIcon icon)
/*    */   {
/* 30 */     super(icon);
/* 31 */     setLayout(new FlowLayout(1, 5, 5));
/* 32 */     setPreferredSize(new Dimension(230, 0));
/* 33 */     setBackground(new Color(255, 255, 255));
/* 34 */     setBorder(new EmptyBorder(5, 5, 5, 5));
/*    */     
/* 36 */     this.inputLabel = new JLabel();
/* 37 */     add(this.inputLabel);
/* 38 */     this.inputLabel.setFont(new Font("隶书", 1, 16));
/*    */     
/* 40 */     this.yesButton = new JRadioButton();
/* 41 */     add(this.yesButton);
/*    */     
/* 43 */     this.noButton = new JRadioButton();
/* 44 */     add(this.noButton);
/*    */     
/* 46 */     this.choiceButtonGroup = new ButtonGroup();
/* 47 */     this.choiceButtonGroup.add(this.yesButton);
/* 48 */     this.choiceButtonGroup.add(this.noButton);
/*    */   }
/*    */   
/*    */   public JLabel getInputLabel() {
/* 52 */     return this.inputLabel;
/*    */   }
/*    */   
/*    */   public JRadioButton getYesButton() {
/* 56 */     return this.yesButton;
/*    */   }
/*    */   
/*    */   public JRadioButton getNoButton() {
/* 60 */     return this.noButton;
/*    */   }
/*    */   
/*    */   public ButtonGroup getChoiceButtonGroup() {
/* 64 */     return this.choiceButtonGroup;
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tool\RadioButtonSearchPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */