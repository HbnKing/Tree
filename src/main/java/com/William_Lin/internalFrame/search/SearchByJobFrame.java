/*    */ package com.William_Lin.internalFrame.search;
/*    */ 
/*    */ import com.William_Lin.internalFrame.ShowFindingResultPanel;
/*    */ import com.William_Lin.node.Node;
/*    */ import com.William_Lin.tool.ButtonPanel;
/*    */ import com.William_Lin.tool.LengthLimitedDmt;
/*    */ import com.William_Lin.tool.ScreenSize;
/*    */ import com.William_Lin.tool.TextFieldSearchPanel;
/*    */ import com.William_Lin.tree.NodeTree;
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Container;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.net.URL;
/*    */ import java.util.ArrayList;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextArea;
/*    */ import javax.swing.JTextField;
/*    */ import javax.swing.SwingUtilities;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SearchByJobFrame
/*    */   extends JFrame
/*    */   implements ScreenSize
/*    */ {
/*    */   private static final long serialVersionUID = -7963979002596922198L;
/*    */   private TextFieldSearchPanel SearchByJobPanel;
/*    */   private ButtonPanel buttonPanel;
/*    */   private ImageIcon iconForButtonPanel;
/*    */   private ImageIcon iconForTextField1;
/*    */   
/*    */   public SearchByJobFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*    */   {
/* 40 */     setResizable(false);
/* 41 */     setTitle("搜索指定工作");
/* 42 */     setLayout(new BorderLayout());
/* 43 */     setSize(450, 140);
/* 44 */     setLocation((int)((screenWidth - getWidth()) * 0.618D / 1.618D), 
/* 45 */       (int)((screenHeight - getHeight()) * 0.618D / 1.618D));
/* 46 */     setDefaultCloseOperation(2);
/* 47 */     setVisible(true);
/*    */     
/* 49 */     URL resource = getClass().getResource("/img/4.png");
/* 50 */     this.iconForButtonPanel = new ImageIcon(resource);
/* 51 */     resource = getClass().getResource("/img/5.png");
/* 52 */     this.iconForTextField1 = new ImageIcon(resource);
/*    */     
/* 54 */     this.SearchByJobPanel = new TextFieldSearchPanel(this.iconForTextField1);
/* 55 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/*    */     
/* 57 */     getContentPane().add(this.SearchByJobPanel, "Center");
/*    */     
/* 59 */     getContentPane().add(this.buttonPanel, "South");
/*    */     
/* 61 */     this.SearchByJobPanel.getInputLabel().setText("请输入要搜索的工作：");
/*    */     
/* 63 */     this.SearchByJobPanel.getInputTextField().setColumns(15);
/* 64 */     this.SearchByJobPanel.getInputTextField().setDocument(
/* 65 */       new LengthLimitedDmt(10));
/*    */     
/* 67 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 69 */         SearchByJobFrame.this.dispose();
/*    */       }
/* 71 */     });
/* 72 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 74 */         SearchByJobFrame.this.SearchByJobPanel.getInputTextField().setText("");
/*    */       }
/* 76 */     });
/* 77 */     final ArrayList<Node> list = new ArrayList();
/* 78 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 80 */         nodetree.findByJob(list, nodetree.getRootNode(), 
/* 81 */           SearchByJobFrame.this.SearchByJobPanel.getInputTextField().getText()
/* 82 */           .replaceAll(" ", ""));
/* 83 */         centerPanel.removeAll();
/* 84 */         centerPanel.add(new ShowFindingResultPanel(list, textarea), 
/* 85 */           "Center");
/* 86 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/* 87 */         SearchByJobFrame.this.dispose();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\search\SearchByJobFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */