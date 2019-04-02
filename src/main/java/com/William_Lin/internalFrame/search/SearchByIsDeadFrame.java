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
/*    */ public class SearchByIsDeadFrame
/*    */   extends JFrame
/*    */   implements ScreenSize
/*    */ {
/*    */   private static final long serialVersionUID = -2173410387301469328L;
/*    */   private RadioButtonSearchPanel SearchByIsDeadPanel;
/*    */   private ButtonPanel buttonPanel;
/*    */   private ImageIcon iconForRadioButton;
/*    */   private ImageIcon iconForButtonPanel;
/*    */   
/*    */   public SearchByIsDeadFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*    */   {
/* 39 */     setResizable(false);
/* 40 */     setTitle("搜索指定的死亡情况");
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
/* 54 */     this.SearchByIsDeadPanel = new RadioButtonSearchPanel(this.iconForRadioButton);
/*    */     
/* 56 */     this.SearchByIsDeadPanel.getInputLabel().setText("请输入要搜索的死亡情况：");
/* 57 */     this.SearchByIsDeadPanel.getYesButton().setText("已死亡");
/* 58 */     this.SearchByIsDeadPanel.getNoButton().setText("未死亡");
/*    */     
/* 60 */     getContentPane().add(this.SearchByIsDeadPanel, "Center");
/* 61 */     getContentPane().add(this.buttonPanel, "South");
/*    */     
/* 63 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 65 */         SearchByIsDeadFrame.this.dispose();
/*    */       }
/* 67 */     });
/* 68 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 70 */         SearchByIsDeadFrame.this.SearchByIsDeadPanel.getChoiceButtonGroup().clearSelection();
/*    */       }
/* 72 */     });
/* 73 */     final ArrayList<Node> list = new ArrayList();
/* 74 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/*    */         boolean isDead;
/* 77 */         if (SearchByIsDeadFrame.this.SearchByIsDeadPanel.getYesButton().isSelected()) {
/* 78 */           isDead = true; } else { 
//	boolean isDead;
/* 79 */           if (SearchByIsDeadFrame.this.SearchByIsDeadPanel.getNoButton().isSelected())
/* 80 */             isDead = false; else return;
/*    */         }
///*    */         boolean isDead;
/* 83 */         nodetree.findByIsDead(list, nodetree.getRootNode(), isDead);
/* 84 */         centerPanel.removeAll();
/* 85 */         centerPanel.add(new ShowFindingResultPanel(list, textarea), 
/* 86 */           "Center");
/* 87 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/* 88 */         SearchByIsDeadFrame.this.dispose();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\search\SearchByIsDeadFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */