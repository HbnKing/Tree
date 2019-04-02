/*    */ package com.William_Lin.internalFrame.search;
/*    */ 
/*    */ import com.William_Lin.internalFrame.ShowFindingResultPanel;
/*    */ import com.William_Lin.node.Node;
/*    */ import com.William_Lin.tool.ButtonPanel;
/*    */ import com.William_Lin.tool.ComboBoxSearchPanel;
/*    */ import com.William_Lin.tool.ScreenSize;
/*    */ import com.William_Lin.tree.NodeTree;
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Container;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.net.URL;
/*    */ import java.util.ArrayList;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JComboBox;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextArea;
/*    */ import javax.swing.SwingUtilities;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SearchByEducationFrame
/*    */   extends JFrame
/*    */   implements ScreenSize
/*    */ {
/*    */   private static final long serialVersionUID = -8200633648052841401L;
/*    */   private ButtonPanel buttonPanel;
/*    */   private ComboBoxSearchPanel SearchByEducationComboBox;
/*    */   private ImageIcon iconForComboBox;
/*    */   private ImageIcon iconForButtonPanel;
/*    */   
/*    */   public SearchByEducationFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*    */   {
/* 39 */     setResizable(false);
/* 40 */     setTitle("搜索指定学历程度");
/* 41 */     setLayout(new BorderLayout());
/* 42 */     setSize(450, 140);
/* 43 */     setLocation((int)((screenWidth - getWidth()) * 0.618D / 1.618D), 
/* 44 */       (int)((screenHeight - getHeight()) * 0.618D / 1.618D));
/* 45 */     setDefaultCloseOperation(2);
/* 46 */     setVisible(true);
/*    */     
/* 48 */     URL resource = getClass().getResource("/img/4.png");
/* 49 */     this.iconForButtonPanel = new ImageIcon(resource);
/* 50 */     resource = getClass().getResource("/img/5.png");
/* 51 */     this.iconForComboBox = new ImageIcon(resource);
/*    */     
/* 53 */     this.SearchByEducationComboBox = new ComboBoxSearchPanel(this.iconForComboBox);
/*    */     
/* 55 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/*    */     
/* 57 */     getContentPane().add(this.SearchByEducationComboBox, "Center");
/*    */     
/* 59 */     getContentPane().add(this.buttonPanel, "South");
/*    */     
/* 61 */     this.SearchByEducationComboBox.getInputLabel().setText("请输入要搜索的学历程度：");
/*    */     
/* 63 */     this.SearchByEducationComboBox.getInputComboBox().addItem("没上学");
/* 64 */     this.SearchByEducationComboBox.getInputComboBox().addItem("小学");
/* 65 */     this.SearchByEducationComboBox.getInputComboBox().addItem("初中");
/* 66 */     this.SearchByEducationComboBox.getInputComboBox().addItem("高中");
/* 67 */     this.SearchByEducationComboBox.getInputComboBox().addItem("大学专科");
/* 68 */     this.SearchByEducationComboBox.getInputComboBox().addItem("大学本科");
/* 69 */     this.SearchByEducationComboBox.getInputComboBox().addItem("研究生");
/* 70 */     this.SearchByEducationComboBox.getInputComboBox().addItem("博士");
/* 71 */     this.SearchByEducationComboBox.getInputComboBox().addItem("博士以上");
/*    */     
/* 73 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 75 */         SearchByEducationFrame.this.dispose();
/*    */       }
/* 77 */     });
/* 78 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener()
/*    */     {
/*    */       public void actionPerformed(ActionEvent e) {
/* 81 */         SearchByEducationFrame.this.SearchByEducationComboBox.getInputComboBox().setSelectedIndex(0);
/*    */       }
/* 83 */     });
/* 84 */     final ArrayList<Node> list = new ArrayList();
/* 85 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 87 */         byte choice = 
/* 88 */           (byte)SearchByEducationFrame.this.SearchByEducationComboBox.getInputComboBox().getSelectedIndex();
/* 89 */         nodetree.findByEducation(list, nodetree.getRootNode(), choice);
/* 90 */         centerPanel.removeAll();
/* 91 */         centerPanel.add(new ShowFindingResultPanel(list, textarea), 
/* 92 */           "Center");
/* 93 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/* 94 */         SearchByEducationFrame.this.dispose();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\search\SearchByEducationFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */