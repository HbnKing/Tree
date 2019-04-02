/*     */ package com.William_Lin.internalFrame.search;
/*     */ 
/*     */ import com.William_Lin.internalFrame.ShowFindingResultPanel;
/*     */ import com.William_Lin.node.Node;
/*     */ import com.William_Lin.tool.ButtonPanel;
/*     */ import com.William_Lin.tool.MyPanel;
/*     */ import com.William_Lin.tool.NumberLengthLimitedDmt;
/*     */ import com.William_Lin.tool.ScreenSize;
/*     */ import com.William_Lin.tree.NodeTree;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Container;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.SwingUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SearchByDeathdayFrame
/*     */   extends JFrame
/*     */   implements ScreenSize
/*     */ {
/*     */   private static final long serialVersionUID = -390783979978402637L;
/*     */   private ButtonPanel buttonPanel;
/*     */   private JPanel deathdayPanel;
/*     */   private JTextField yearTextField;
/*     */   private JComboBox monthComboBox;
/*     */   private JComboBox dayComboBox;
/*     */   private ImageIcon iconForDayPanel;
/*     */   private ImageIcon iconForButtonPanel;
/*     */   
/*     */   public SearchByDeathdayFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*     */   {
/*  50 */     setResizable(false);
/*  51 */     setTitle("搜索指定死亡日期");
/*  52 */     setLayout(new BorderLayout());
/*  53 */     setSize(450, 135);
/*  54 */     setLocation((int)((screenWidth - getWidth()) * 0.618D / 1.618D), 
/*  55 */       (int)((screenHeight - getHeight()) * 0.618D / 1.618D));
/*  56 */     setDefaultCloseOperation(2);
/*  57 */     setVisible(true);
/*     */     
/*  59 */     URL resource = getClass().getResource("/img/4.png");
/*  60 */     this.iconForButtonPanel = new ImageIcon(resource);
/*  61 */     resource = getClass().getResource("/img/5.png");
/*  62 */     this.iconForDayPanel = new ImageIcon(resource);
/*     */     
/*  64 */     this.deathdayPanel = new MyPanel(this.iconForDayPanel);
/*     */     
/*  66 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/*     */     
/*  68 */     getContentPane().add(this.deathdayPanel, "Center");
/*     */     
/*  70 */     getContentPane().add(this.buttonPanel, "South");
/*     */     
/*  72 */     add(this.deathdayPanel);
/*  73 */     JLabel birthdayLabel = new JLabel("死亡日期：");
/*  74 */     this.deathdayPanel.add(birthdayLabel);
/*  75 */     birthdayLabel.setFont(new Font("隶书", 1, 16));
/*  76 */     this.yearTextField = new JTextField();
/*  77 */     this.deathdayPanel.add(this.yearTextField);
/*  78 */     this.yearTextField.setColumns(4);
/*  79 */     this.yearTextField.setDocument(new NumberLengthLimitedDmt(4));
/*  80 */     JLabel yearLabel1 = new JLabel("年");
/*  81 */     this.deathdayPanel.add(yearLabel1);
/*  82 */     this.monthComboBox = new JComboBox();
/*  83 */     this.deathdayPanel.add(this.monthComboBox);
/*  84 */     for (int i = 1; i <= 12; i++)
/*  85 */       this.monthComboBox.addItem(Integer.valueOf(i));
/*  86 */     JLabel monthLabel = new JLabel("月");
/*  87 */     this.deathdayPanel.add(monthLabel);
/*  88 */     this.dayComboBox = new JComboBox();
/*  89 */     this.deathdayPanel.add(this.dayComboBox);
/*  90 */     for (int i = 1; i <= 31; i++)
/*  91 */       this.dayComboBox.addItem(Integer.valueOf(i));
/*  92 */     JLabel dayLabel1 = new JLabel("日");
/*  93 */     this.deathdayPanel.add(dayLabel1);
/*     */     
/*  95 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  97 */         SearchByDeathdayFrame.this.dispose();
/*     */       }
/*  99 */     });
/* 100 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 102 */         SearchByDeathdayFrame.this.yearTextField.setText("");
/* 103 */         SearchByDeathdayFrame.this.monthComboBox.setSelectedIndex(0);
/* 104 */         SearchByDeathdayFrame.this.dayComboBox.setSelectedIndex(0);
/*     */       }
/* 106 */     });
/* 107 */     final ArrayList<Node> list = new ArrayList();
/* 108 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 110 */         String year = SearchByDeathdayFrame.this.yearTextField.getText().trim();
/* 111 */         String month = SearchByDeathdayFrame.this.monthComboBox.getSelectedItem().toString();
/* 112 */         String day = SearchByDeathdayFrame.this.dayComboBox.getSelectedItem().toString();
/* 113 */         String birthday = year + "-" + month + "-" + day;
/* 114 */         nodetree.findByDeathday(list, nodetree.getRootNode(), birthday);
/* 115 */         centerPanel.removeAll();
/* 116 */         centerPanel.add(new ShowFindingResultPanel(list, textarea), 
/* 117 */           "Center");
/* 118 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/* 119 */         SearchByDeathdayFrame.this.dispose();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\search\SearchByDeathdayFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */