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
/*    */ public class SearchByTelephoneFrame
/*    */   extends JFrame
/*    */   implements ScreenSize
/*    */ {
/*    */   private static final long serialVersionUID = 4187278137278450811L;
/*    */   private TextFieldSearchPanel SearchByTelephonePanel;
/*    */   private ButtonPanel buttonPanel;
/*    */   private ImageIcon iconForButtonPanel;
/*    */   private ImageIcon iconForTextField1;
/*    */   
/*    */   public SearchByTelephoneFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*    */   {
/* 40 */     setResizable(false);
/* 41 */     setTitle("搜索指定姓名");
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
/* 54 */     this.SearchByTelephonePanel = new TextFieldSearchPanel(this.iconForTextField1);
/* 55 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/*    */     
/* 57 */     getContentPane().add(this.SearchByTelephonePanel, "Center");
/*    */     
/* 59 */     getContentPane().add(this.buttonPanel, "South");
/*    */     
/* 61 */     this.SearchByTelephonePanel.getInputLabel().setText("请输入要搜索的电话号码：");
/*    */     
/* 63 */     this.SearchByTelephonePanel.getInputTextField().setColumns(15);
/* 64 */     this.SearchByTelephonePanel.getInputTextField().setDocument(
/* 65 */       new NumberLengthLimitedDmt(15));
/*    */     
/* 67 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 69 */         SearchByTelephoneFrame.this.dispose();
/*    */       }
/* 71 */     });
/* 72 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 74 */         SearchByTelephoneFrame.this.SearchByTelephonePanel.getInputTextField().setText("");
/*    */       }
/* 76 */     });
/* 77 */     final ArrayList<Node> list = new ArrayList();
/* 78 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 80 */         nodetree.findByTelephone(list, nodetree.getRootNode(), 
/* 81 */           SearchByTelephoneFrame.this.SearchByTelephonePanel.getInputTextField().getText());
/* 82 */         centerPanel.removeAll();
/* 83 */         centerPanel.add(new ShowFindingResultPanel(list, textarea), 
/* 84 */           "Center");
/* 85 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/* 86 */         SearchByTelephoneFrame.this.dispose();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\search\SearchByTelephoneFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */