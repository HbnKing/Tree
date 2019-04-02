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
/*    */ public class SearchByAddressFrame
/*    */   extends JFrame
/*    */   implements ScreenSize
/*    */ {
/*    */   private static final long serialVersionUID = 670373554946030117L;
/*    */   private TextFieldSearchPanel SearchByAddressPanel;
/*    */   private ButtonPanel buttonPanel;
/*    */   private ImageIcon iconForButtonPanel;
/*    */   private ImageIcon iconForTextField1;
/*    */   
/*    */   public SearchByAddressFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*    */   {
/* 40 */     setResizable(false);
/* 41 */     setTitle("搜索指定地址");
/* 42 */     setLayout(new BorderLayout());
/* 43 */     setSize(450, 180);
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
/* 54 */     this.SearchByAddressPanel = new TextFieldSearchPanel(this.iconForTextField1);
/* 55 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/*    */     
/* 57 */     getContentPane().add(this.SearchByAddressPanel, "Center");
/* 58 */     getContentPane().add(this.buttonPanel, "South");
/*    */     
/* 60 */     this.SearchByAddressPanel.getInputLabel().setText("请输入要搜索的地址：");
/*    */     
/*    */ 
/* 63 */     this.SearchByAddressPanel.getInputTextField().setColumns(30);
/* 64 */     this.SearchByAddressPanel.getInputTextField().setDocument(
/* 65 */       new LengthLimitedDmt(23));
/*    */     
/*    */ 
/* 68 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 70 */         SearchByAddressFrame.this.dispose();
/*    */       }
/*    */       
/*    */ 
/* 74 */     });
/* 75 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 77 */         SearchByAddressFrame.this.SearchByAddressPanel.getInputTextField().setText("");
/*    */       }
/* 79 */     });
/* 80 */     final ArrayList<Node> list = new ArrayList();
/* 81 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 83 */         nodetree.findByAddress(list, nodetree.getRootNode(), 
/* 84 */           SearchByAddressFrame.this.SearchByAddressPanel.getInputTextField().getText()
/* 85 */           .replaceAll(" ", ""));
/* 86 */         centerPanel.removeAll();
/* 87 */         centerPanel.add(new ShowFindingResultPanel(list, textarea), 
/* 88 */           "Center");
/* 89 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/* 90 */         SearchByAddressFrame.this.dispose();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\search\SearchByAddressFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */