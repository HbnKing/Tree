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
/*     */ public class SearchByBirthdayFrame
/*     */   extends JFrame
/*     */   implements ScreenSize
/*     */ {
/*     */   private static final long serialVersionUID = 6074626350387758837L;
/*     */   private ButtonPanel buttonPanel;
/*     */   private JPanel birthdayPanel;
/*     */   private JTextField yearTextField;
/*     */   private JComboBox monthComboBox;
/*     */   private JComboBox dayComboBox;
/*     */   private ImageIcon iconForDayPanel;
/*     */   private ImageIcon iconForButtonPanel;
/*     */   
/*     */   public SearchByBirthdayFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*     */   {
/*  50 */     setTitle("搜索指定出生日期");
/*  51 */     setLayout(new BorderLayout());
/*  52 */     setSize(450, 135);
/*  53 */     setLocation((int)((screenWidth - getWidth()) * 0.618D / 1.618D), 
/*  54 */       (int)((screenHeight - getHeight()) * 0.618D / 1.618D));
/*  55 */     setDefaultCloseOperation(2);
/*  56 */     setVisible(true);
/*     */     
/*  58 */     URL resource = getClass().getResource("/img/4.png");
/*  59 */     this.iconForButtonPanel = new ImageIcon(resource);
/*  60 */     resource = getClass().getResource("/img/5.png");
/*  61 */     this.iconForDayPanel = new ImageIcon(resource);
/*     */     
/*  63 */     this.birthdayPanel = new MyPanel(this.iconForDayPanel);
/*     */     
/*  65 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/*     */     
/*  67 */     getContentPane().add(this.birthdayPanel, "Center");
/*     */     
/*  69 */     getContentPane().add(this.buttonPanel, "South");
/*  70 */     add(this.birthdayPanel);
/*  71 */     JLabel birthdayLabel = new JLabel("出生日期：");
/*  72 */     this.birthdayPanel.add(birthdayLabel);
/*  73 */     birthdayLabel.setFont(new Font("隶书", 1, 16));
/*  74 */     this.yearTextField = new JTextField();
/*  75 */     this.birthdayPanel.add(this.yearTextField);
/*  76 */     this.yearTextField.setColumns(4);
/*  77 */     this.yearTextField.setDocument(new NumberLengthLimitedDmt(4));
/*  78 */     JLabel yearLabel1 = new JLabel("年");
/*  79 */     this.birthdayPanel.add(yearLabel1);
/*  80 */     this.monthComboBox = new JComboBox();
/*  81 */     this.birthdayPanel.add(this.monthComboBox);
/*  82 */     for (int i = 1; i <= 12; i++)
/*  83 */       this.monthComboBox.addItem(Integer.valueOf(i));
/*  84 */     JLabel monthLabel = new JLabel("月");
/*  85 */     this.birthdayPanel.add(monthLabel);
/*  86 */     this.dayComboBox = new JComboBox();
/*  87 */     this.birthdayPanel.add(this.dayComboBox);
/*  88 */     for (int i = 1; i <= 31; i++)
/*  89 */       this.dayComboBox.addItem(Integer.valueOf(i));
/*  90 */     JLabel dayLabel1 = new JLabel("日");
/*  91 */     this.birthdayPanel.add(dayLabel1);
/*     */     
/*  93 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  95 */         SearchByBirthdayFrame.this.dispose();
/*     */       }
/*  97 */     });
/*  98 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 100 */         SearchByBirthdayFrame.this.yearTextField.setText("");
/* 101 */         SearchByBirthdayFrame.this.monthComboBox.setSelectedIndex(0);
/* 102 */         SearchByBirthdayFrame.this.dayComboBox.setSelectedIndex(0);
/*     */       }
/* 104 */     });
/* 105 */     final ArrayList<Node> list = new ArrayList();
/* 106 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 108 */         String year = SearchByBirthdayFrame.this.yearTextField.getText().trim();
/* 109 */         String month = SearchByBirthdayFrame.this.monthComboBox.getSelectedItem().toString();
/* 110 */         String day = SearchByBirthdayFrame.this.dayComboBox.getSelectedItem().toString();
/* 111 */         String birthday = year + "-" + month + "-" + day;
/* 112 */         nodetree.findByBirthday(list, nodetree.getRootNode(), birthday);
/* 113 */         centerPanel.removeAll();
/* 114 */         centerPanel.add(new ShowFindingResultPanel(list, textarea), 
/* 115 */           "Center");
/* 116 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/* 117 */         SearchByBirthdayFrame.this.dispose();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\search\SearchByBirthdayFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */