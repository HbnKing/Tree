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
/*    */ public class SearchByTop_titleFrame
/*    */   extends JFrame
/*    */   implements ScreenSize
/*    */ {
/*    */   private static final long serialVersionUID = -7322132515741668254L;
/*    */   private TextFieldSearchPanel SearchByTop_titlePanel;
/*    */   private ButtonPanel buttonPanel;
/*    */   private ImageIcon iconForButtonPanel;
/*    */   private ImageIcon iconForTextField1;
/*    */   
/*    */   public SearchByTop_titleFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*    */   {
/* 40 */     setResizable(false);
/* 41 */     setTitle("搜索指定最高职称");
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
/* 54 */     this.SearchByTop_titlePanel = new TextFieldSearchPanel(this.iconForTextField1);
/* 55 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/*    */     
/* 57 */     getContentPane().add(this.SearchByTop_titlePanel, "Center");
/* 58 */     getContentPane().add(this.buttonPanel, "South");
/*    */     
/* 60 */     this.SearchByTop_titlePanel.getInputLabel().setText("请输入要搜索的职称：");
/*    */     
/* 62 */     this.SearchByTop_titlePanel.getInputTextField().setColumns(20);
/* 63 */     this.SearchByTop_titlePanel.getInputTextField().setDocument(
/* 64 */       new LengthLimitedDmt(10));
/*    */     
/* 66 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 68 */         SearchByTop_titleFrame.this.dispose();
/*    */       }
/* 70 */     });
/* 71 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 73 */         SearchByTop_titleFrame.this.SearchByTop_titlePanel.getInputTextField().setText("");
/*    */       }
/* 75 */     });
/* 76 */     final ArrayList<Node> list = new ArrayList();
/* 77 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 79 */         nodetree.findByTop_title(list, nodetree.getRootNode(), 
/* 80 */           SearchByTop_titleFrame.this.SearchByTop_titlePanel.getInputTextField().getText()
/* 81 */           .replaceAll(" ", ""));
/* 82 */         centerPanel.removeAll();
/* 83 */         centerPanel.add(new ShowFindingResultPanel(list, textarea), 
/* 84 */           "Center");
/* 85 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/* 86 */         SearchByTop_titleFrame.this.dispose();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\search\SearchByTop_titleFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */