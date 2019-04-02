/*    */ package com.William_Lin.tool;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.FlowLayout;
/*    */ import java.awt.Font;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NoticePanel
/*    */   extends MyPanel
/*    */ {
/*    */   private static final long serialVersionUID = 9161587730003019218L;
/*    */   private JLabel noticeLabel;
/*    */   
/*    */   public NoticePanel(ImageIcon icon)
/*    */   {
/* 25 */     super(icon);
/* 26 */     setLayout(new FlowLayout(0, 5, 5));
/* 27 */     setPreferredSize(new Dimension(200, 50));
/* 28 */     setBackground(new Color(255, 255, 255));
/* 29 */     setBorder(new EmptyBorder(5, 5, 5, 5));
/*    */     
/* 31 */     this.noticeLabel = new JLabel("注意：标有“*“的空格为必填内容，请填好再提交。");
/* 32 */     this.noticeLabel.setFont(new Font("楷体", 1, 16));
/* 33 */     add(this.noticeLabel);
/*    */   }
/*    */   
/*    */   public JLabel getNoticeLabel() {
/* 37 */     return this.noticeLabel;
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tool\NoticePanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */