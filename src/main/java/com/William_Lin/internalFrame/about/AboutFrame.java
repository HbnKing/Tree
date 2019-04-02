/*    */ package com.William_Lin.internalFrame.about;
/*    */ 
/*    */ import com.William_Lin.tool.MyPanel;
/*    */ import com.William_Lin.tool.ScreenSize;
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Font;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.net.URL;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTextArea;
/*    */ import javax.swing.border.TitledBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AboutFrame
/*    */   extends JFrame
/*    */   implements ScreenSize
/*    */ {
/*    */   private static final long serialVersionUID = -253593869431139958L;
/*    */   private JPanel aboutPanel;
/*    */   private ImageIcon iconForAboutFrame;
/*    */   
/*    */   public AboutFrame()
/*    */   {
/* 34 */     setTitle("关于家谱管理系统");
/* 35 */     setSize(320, 250);
/* 36 */     setLocation((int)((screenWidth - getWidth()) * 0.618D / 1.618D), 
/* 37 */       (int)((screenHeight - getHeight()) * 0.618D / 1.618D));
/* 38 */     setLayout(new BorderLayout());
/* 39 */     setDefaultCloseOperation(2);
/* 40 */     setVisible(true);
/* 41 */     setResizable(false);
/*    */     
/* 43 */     URL resource = getClass().getResource("/img/back.png");
/* 44 */     this.iconForAboutFrame = new ImageIcon(resource);
/*    */     
/* 46 */     this.aboutPanel = new MyPanel(this.iconForAboutFrame);
/* 47 */     this.aboutPanel.setLayout(new BorderLayout(0, 0));
/* 48 */     this.aboutPanel.setBorder(new TitledBorder(null, "", 
/* 49 */       0, 
/* 50 */       0, null, null));
/* 51 */     this.aboutPanel.setPreferredSize(new Dimension(310, 0));
/* 52 */     setContentPane(this.aboutPanel);
/*    */     
/* 54 */     String message1 = "家谱管理系统(Java)";
/* 55 */     String message2 = "版本：1.0.0";
/* 56 */     String message = "<html>" + message1 + "<br>" + message2 + "</html>";
/* 57 */     JLabel label1 = new JLabel(message);
/* 58 */     label1.setFont(new Font("楷体", 1, 16));
/* 59 */     this.aboutPanel.add(label1, "North");
/* 60 */     JScrollPane scrollPane1 = new JScrollPane();
/* 61 */     this.aboutPanel.add(scrollPane1, "Center");
/* 62 */     JTextArea textarea = new JTextArea();
/* 63 */     textarea.setOpaque(false);
/* 64 */     textarea.setLineWrap(true);
/* 65 */     scrollPane1.setViewportView(textarea);
/* 66 */     textarea.setText("         本软件是基于Java语言的家谱管理系统，可以实现对家谱的添加、修改、删除、搜索、保存、统计、查询等功能。此软件不使用系统的数据库，而是使用二进制文件对记录进行保存。此软件为初始版本，功能仍有欠缺。");
/*    */     
/*    */ 
/* 69 */     textarea.setEditable(false);
/*    */     
/* 71 */     JButton okButton = new JButton("确定");
/* 72 */     okButton.setOpaque(false);
/* 73 */     this.aboutPanel.add(okButton, "South");
/* 74 */     okButton.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 76 */         AboutFrame.this.dispose();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\about\AboutFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */