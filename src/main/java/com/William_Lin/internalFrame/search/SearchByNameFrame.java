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
/*    */ public class SearchByNameFrame
/*    */   extends JFrame
/*    */   implements ScreenSize
/*    */ {
/*    */   private static final long serialVersionUID = -5789110681152662795L;
/*    */   private TextFieldSearchPanel SearchByNamePanel;
/*    */   private ButtonPanel buttonPanel;
/*    */   private ImageIcon iconForButtonPanel;
/*    */   private ImageIcon iconForTextField1;
/*    */   
/*    */   public SearchByNameFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*    */   {
/* 40 */     setResizable(false);
/* 41 */     setTitle("搜索指定姓名");
/* 42 */     setLayout(new BorderLayout());
/* 43 */     setSize(450, 135);
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
/* 54 */     this.SearchByNamePanel = new TextFieldSearchPanel(this.iconForTextField1);
/* 55 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/*    */     
/* 57 */     getContentPane().add(this.SearchByNamePanel, "Center");
/*    */     
/* 59 */     getContentPane().add(this.buttonPanel, "South");
/*    */     
/* 61 */     this.SearchByNamePanel.getInputLabel().setText("请输入要搜索的姓名：");
/*    */     
/* 63 */     this.SearchByNamePanel.getInputTextField().setColumns(5);
/* 64 */     this.SearchByNamePanel.getInputTextField().setDocument(
/* 65 */       new LengthLimitedDmt(4));
/* 66 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 68 */         SearchByNameFrame.this.dispose();
/*    */       }
/* 70 */     });
/* 71 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 73 */         SearchByNameFrame.this.SearchByNamePanel.getInputTextField().setText("");
/*    */       }
/* 75 */     });
/* 76 */     final ArrayList<Node> list = new ArrayList();
/* 77 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 79 */         nodetree.findByName(list, nodetree.getRootNode(), 
/* 80 */           SearchByNameFrame.this.SearchByNamePanel.getInputTextField().getText()
/* 81 */           .replaceAll(" ", ""));
/* 82 */         centerPanel.removeAll();
/* 83 */         centerPanel.add(new ShowFindingResultPanel(list, textarea), 
/* 84 */           "Center");
/* 85 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/* 86 */         SearchByNameFrame.this.dispose();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\search\SearchByNameFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */