/*    */ package com.William_Lin.internalFrame.search;
/*    */ 
/*    */ import com.William_Lin.internalFrame.ShowFindingResultPanel;
/*    */ import com.William_Lin.node.Node;
/*    */ import com.William_Lin.tool.ButtonPanel;
/*    */ import com.William_Lin.tool.NumberLengthLimitedDmt;
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
/*    */ public class SearchByLevelFrame
/*    */   extends JFrame
/*    */   implements ScreenSize
/*    */ {
/*    */   private static final long serialVersionUID = -6709718837935789371L;
/*    */   private TextFieldSearchPanel SearchByLevelPanel;
/*    */   private ButtonPanel buttonPanel;
/*    */   private ImageIcon iconForButtonPanel;
/*    */   private ImageIcon iconForTextField1;
/*    */   
/*    */   public SearchByLevelFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*    */   {
/* 40 */     setResizable(false);
/* 41 */     setTitle("搜索指定的家谱中辈份");
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
/* 54 */     this.SearchByLevelPanel = new TextFieldSearchPanel(this.iconForTextField1);
/* 55 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/* 56 */     getContentPane().add(this.SearchByLevelPanel, "Center");
/* 57 */     getContentPane().add(this.buttonPanel, "South");
/*    */     
/* 59 */     this.SearchByLevelPanel.getInputLabel().setText("请输入要搜索的辈份：");
/*    */     
/* 61 */     this.SearchByLevelPanel.getInputTextField().setColumns(6);
/* 62 */     this.SearchByLevelPanel.getInputTextField().setDocument(
/* 63 */       new NumberLengthLimitedDmt(6));
/*    */     
/* 65 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 67 */         SearchByLevelFrame.this.dispose();
/*    */       }
/* 69 */     });
/* 70 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 72 */         SearchByLevelFrame.this.SearchByLevelPanel.getInputTextField().setText("");
/*    */       }
/* 74 */     });
/* 75 */     final ArrayList<Node> list = new ArrayList();
/* 76 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 78 */         String input = SearchByLevelFrame.this.SearchByLevelPanel.getInputTextField().getText().replaceAll(" ", "");
/* 79 */         if (input.equals(""))
/* 80 */           return;
/* 81 */         nodetree.findByLevel(list, nodetree.getRootNode(), 
/* 82 */           Integer.parseInt(input));
/* 83 */         centerPanel.removeAll();
/* 84 */         centerPanel.add(new ShowFindingResultPanel(list, textarea), 
/* 85 */           "Center");
/* 86 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/* 87 */         SearchByLevelFrame.this.dispose();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\search\SearchByLevelFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */