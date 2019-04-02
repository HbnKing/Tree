/*    */ package com.William_Lin.internalFrame.search;
/*    */ 
/*    */ import com.William_Lin.internalFrame.ShowFindingResultPanel;
/*    */ import com.William_Lin.node.Node;
/*    */ import com.William_Lin.tool.ButtonPanel;
/*    */ import com.William_Lin.tool.RadioButtonSearchPanel;
/*    */ import com.William_Lin.tool.ScreenSize;
/*    */ import com.William_Lin.tree.NodeTree;
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Container;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.net.URL;
/*    */ import java.util.ArrayList;
/*    */ import javax.swing.ButtonGroup;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JRadioButton;
/*    */ import javax.swing.JTextArea;
/*    */ import javax.swing.SwingUtilities;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SearchBySexFrame
/*    */   extends JFrame
/*    */   implements ScreenSize
/*    */ {
/*    */   private static final long serialVersionUID = 1665822780118925436L;
/*    */   private RadioButtonSearchPanel SearchBySexPanel;
/*    */   private ButtonPanel buttonPanel;
/*    */   private ImageIcon iconForRadioButton;
/*    */   private ImageIcon iconForButtonPanel;
/*    */   
/*    */   public SearchBySexFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*    */   {
/* 39 */     setResizable(false);
/* 40 */     setTitle("搜索指定的性别");
/* 41 */     setLayout(new BorderLayout());
/* 42 */     setSize(450, 135);
/* 43 */     setLocation((int)((screenWidth - getWidth()) * 0.618D / 1.618D), 
/* 44 */       (int)((screenHeight - getHeight()) * 0.618D / 1.618D));
/* 45 */     setDefaultCloseOperation(2);
/* 46 */     setVisible(true);
/*    */     
/* 48 */     URL resource = getClass().getResource("/img/4.png");
/* 49 */     this.iconForButtonPanel = new ImageIcon(resource);
/* 50 */     resource = getClass().getResource("/img/5.png");
/* 51 */     this.iconForRadioButton = new ImageIcon(resource);
/*    */     
/* 53 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/* 54 */     this.SearchBySexPanel = new RadioButtonSearchPanel(this.iconForRadioButton);
/*    */     
/* 56 */     this.SearchBySexPanel.getInputLabel().setText("请输入要搜索的性别：");
/* 57 */     this.SearchBySexPanel.getYesButton().setText("男");
/* 58 */     this.SearchBySexPanel.getNoButton().setText("女");
/*    */     
/* 60 */     getContentPane().add(this.SearchBySexPanel, "Center");
/*    */     
/* 62 */     getContentPane().add(this.buttonPanel, "South");
/*    */     
/* 64 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 66 */         SearchBySexFrame.this.dispose();
/*    */       }
/* 68 */     });
/* 69 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 71 */         SearchBySexFrame.this.SearchBySexPanel.getChoiceButtonGroup().clearSelection();
/*    */       }
/* 73 */     });
/* 74 */     final ArrayList<Node> list = new ArrayList();
/* 75 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/*    */         byte sex;
/* 78 */         if (SearchBySexFrame.this.SearchBySexPanel.getYesButton().isSelected()) {
/* 79 */           sex = 0; } else {
//	byte sex;
/* 80 */           if (SearchBySexFrame.this.SearchBySexPanel.getNoButton().isSelected())
/* 81 */             sex = 1; else return;
/*    */         }
///*    */         byte sex;
/* 84 */         nodetree.findBySex(list, nodetree.getRootNode(), sex);
/* 85 */         centerPanel.removeAll();
/* 86 */         centerPanel.add(new ShowFindingResultPanel(list, textarea), 
/* 87 */           "Center");
/* 88 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/* 89 */         SearchBySexFrame.this.dispose();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\search\SearchBySexFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */