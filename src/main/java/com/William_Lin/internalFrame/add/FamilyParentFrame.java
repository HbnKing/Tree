/*     */ package com.William_Lin.internalFrame.add;
/*     */ 
/*     */ import com.William_Lin.internalFrame.ShowAllMemberPanel;
/*     */ import com.William_Lin.node.Node;
/*     */ import com.William_Lin.tool.BirthdayDeathdayCheck;
/*     */ import com.William_Lin.tool.ButtonPanel;
/*     */ import com.William_Lin.tool.CalendarCheck;
/*     */ import com.William_Lin.tool.InformationPanel;
/*     */ import com.William_Lin.tool.NoticePanel;
/*     */ import com.William_Lin.tool.ScreenSize;
/*     */ import com.William_Lin.tree.NodeTree;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Container;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.net.URL;
/*     */ import java.text.DecimalFormat;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.SwingUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FamilyParentFrame
/*     */   extends JFrame
/*     */   implements ScreenSize
/*     */ {
/*     */   private static final long serialVersionUID = 4788677056232474175L;
/*     */   private NoticePanel noticePanel;
/*     */   private InformationPanel informationPanel;
/*     */   private ButtonPanel buttonPanel;
/*     */   private ImageIcon iconForNoticePanel;
/*     */   private ImageIcon iconForInformationPanel;
/*     */   private ImageIcon iconForButtonPanel;
/*     */   
/*     */   public FamilyParentFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree, final Node node)
/*     */   {
/*  47 */     setTitle("添加选中对象的父亲");
/*  48 */     setLayout(new BorderLayout());
/*  49 */     setSize(430, 520);
/*  50 */     setLocation((int)((screenWidth - getWidth()) * 0.618D / 1.618D), 
/*  51 */       (int)((screenHeight - getHeight()) * 0.618D / 1.618D));
/*  52 */     setDefaultCloseOperation(2);
/*  53 */     setVisible(true);
/*  54 */     setResizable(false);
/*  55 */     URL resource = getClass().getResource("/img/1.png");
/*  56 */     this.iconForNoticePanel = new ImageIcon(resource);
/*  57 */     resource = getClass().getResource("/img/2.png");
/*  58 */     this.iconForInformationPanel = new ImageIcon(resource);
/*  59 */     resource = getClass().getResource("/img/3.png");
/*  60 */     this.iconForButtonPanel = new ImageIcon(resource);
/*     */     
/*  62 */     this.noticePanel = new NoticePanel(this.iconForNoticePanel);
/*  63 */     this.informationPanel = new InformationPanel(this.iconForInformationPanel);
/*  64 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/*     */     
/*  66 */     getContentPane().add(this.noticePanel, "North");
/*     */     
/*  68 */     getContentPane().add(this.informationPanel, "Center");
/*     */     
/*  70 */     getContentPane().add(this.buttonPanel, "South");
/*     */     
/*  72 */     this.informationPanel.getMaleButton().setSelected(true);
/*  73 */     this.informationPanel.getFemaleButton().setEnabled(false);
/*     */     
/*  75 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  77 */         FamilyParentFrame.this.informationPanel.getNameTextField().setText("");
/*  78 */         FamilyParentFrame.this.informationPanel.getBornplaceTextField().setText("");
/*  79 */         FamilyParentFrame.this.informationPanel.getJobTextField().setText("");
/*  80 */         FamilyParentFrame.this.informationPanel.getTop_titleTextField().setText("");
/*  81 */         FamilyParentFrame.this.informationPanel.getTelephoneTextField().setText("");
/*  82 */         FamilyParentFrame.this.informationPanel.getAddressTextField().setText("");
/*  83 */         FamilyParentFrame.this.informationPanel.getYearTextField1().setText("");
/*  84 */         FamilyParentFrame.this.informationPanel.getYearTextField2().setText("");
/*  85 */         FamilyParentFrame.this.informationPanel.getMaleButton().setSelected(true);
/*  86 */         FamilyParentFrame.this.informationPanel.getFemaleButton().setEnabled(false);
/*  87 */         FamilyParentFrame.this.informationPanel.getMarriedButtonGroup().clearSelection();
/*  88 */         FamilyParentFrame.this.informationPanel.getDeadButtonGroup().clearSelection();
/*  89 */         FamilyParentFrame.this.informationPanel.getHasChildButtonGroup().clearSelection();
/*  90 */         FamilyParentFrame.this.informationPanel.getCentimeterComboBox().setSelectedIndex(0);
/*  91 */         FamilyParentFrame.this.informationPanel.getMeterComboBox().setSelectedIndex(0);
/*  92 */         FamilyParentFrame.this.informationPanel.getDecimeterComboBox().setSelectedIndex(0);
/*  93 */         FamilyParentFrame.this.informationPanel.getMonthComboBox1().setSelectedIndex(0);
/*  94 */         FamilyParentFrame.this.informationPanel.getDayComboBox1().setSelectedIndex(0);
/*  95 */         FamilyParentFrame.this.informationPanel.getMonthComboBox2().setSelectedIndex(0);
/*  96 */         FamilyParentFrame.this.informationPanel.getDayComboBox2().setSelectedIndex(0);
/*  97 */         FamilyParentFrame.this.informationPanel.getEducationComboBox().setSelectedIndex(0);
/*     */       }
/*     */       
/* 100 */     });
/* 101 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 103 */         if ((FamilyParentFrame.this.informationPanel.getNameTextField().getText().equals("")) || 
/*     */         
/* 105 */           (FamilyParentFrame.this.informationPanel.getBornplaceTextField().getText().equals("")) || 
/*     */           
/* 107 */           (FamilyParentFrame.this.informationPanel.getYearTextField1().getText().equals("")) || 
/* 108 */           ((!FamilyParentFrame.this.informationPanel.getMaleButton().isSelected()) && 
/* 109 */           (!FamilyParentFrame.this.informationPanel.getFemaleButton().isSelected())) || (
/* 110 */           (!FamilyParentFrame.this.informationPanel.getIsDeadButton().isSelected()) && 
/* 111 */           (!FamilyParentFrame.this.informationPanel.getIsAliveButton().isSelected()))) {
/* 112 */           JOptionPane.showMessageDialog(null, "请填写全部信息。", "错误提示", 
/* 113 */             0);
/* 114 */           return;
/*     */         }
/* 116 */         if (FamilyParentFrame.this.informationPanel.getFemaleButton().isSelected()) {
/* 117 */           JOptionPane.showMessageDialog(null, "该成员为女性，不能成为祖先。", 
/* 118 */             "错误提示", 0);
/* 119 */           return;
/*     */         }
/* 121 */         String year = FamilyParentFrame.this.informationPanel.getYearTextField1().getText()
/* 122 */           .trim();
/* 123 */         String month = FamilyParentFrame.this.informationPanel.getMonthComboBox1()
/* 124 */           .getSelectedItem().toString();
/* 125 */         String day = FamilyParentFrame.this.informationPanel.getDayComboBox1()
/* 126 */           .getSelectedItem().toString();
/* 127 */         if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 128 */           JOptionPane.showMessageDialog(null, "出生日期输入有误。", "错误提示", 
/* 129 */             0);
/* 130 */           return;
/*     */         }
/* 132 */         String birthday = year + "-" + month + "-" + day;
///*     */         byte sex;
/* 134 */         byte sex; if (FamilyParentFrame.this.informationPanel.getMaleButton().isSelected()) {
/* 135 */           sex = 0;
/*     */         } else
/* 137 */           sex = 1;
/* 138 */         boolean isDead = false;
/* 139 */         if (FamilyParentFrame.this.informationPanel.getIsDeadButton().isSelected()) {
/* 140 */           isDead = true;
/* 141 */           if (FamilyParentFrame.this.informationPanel.getYearTextField2().getText().equals(
/* 142 */             "")) {
/* 143 */             JOptionPane.showMessageDialog(null, "请填写死亡日期时间。", 
/* 144 */               "错误提示", 0);
/* 145 */             return;
/*     */           }
/* 147 */           year = 
/* 148 */             FamilyParentFrame.this.informationPanel.getYearTextField2().getText().trim();
/* 149 */           month = FamilyParentFrame.this.informationPanel.getMonthComboBox2()
/* 150 */             .getSelectedItem().toString();
/* 151 */           day = FamilyParentFrame.this.informationPanel.getDayComboBox2().getSelectedItem()
/* 152 */             .toString();
/* 153 */           if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 154 */             JOptionPane.showMessageDialog(null, "死亡日期输入有误。", 
/* 155 */               "错误提示", 0);
/* 156 */             return;
/*     */           }
/*     */           
/* 159 */           if (!new BirthdayDeathdayCheck(year, month, day, birthday).DateCheckResult()) {
/* 160 */             JOptionPane.showMessageDialog(null, "死亡日期先于出生日期，输入有误。", 
/* 161 */               "错误提示", 0); return;
/*     */           }
/*     */         }
/*     */         
/*     */         String deathday;
///*     */         String deathday;
/* 167 */         if (isDead) {
/* 168 */           deathday = year + "-" + month + "-" + day;
/*     */         } else {
/* 170 */           deathday = "";
/*     */         }
/*     */         
/* 173 */         int meter = FamilyParentFrame.this.informationPanel.getMeterComboBox().getSelectedIndex();
/* 174 */         int decimeter = FamilyParentFrame.this.informationPanel.getDecimeterComboBox()
/* 175 */           .getSelectedIndex();
/* 176 */         int centimeter = FamilyParentFrame.this.informationPanel.getCentimeterComboBox()
/* 177 */           .getSelectedIndex();
/* 178 */         double height = meter + decimeter / 10.0D + 
/* 179 */           centimeter / 100.0D;
/* 180 */         DecimalFormat df = new DecimalFormat("#.00");
/* 181 */         height = Double.parseDouble(df.format(height));
/* 182 */         boolean married = false;
/* 183 */         if (FamilyParentFrame.this.informationPanel.getMarriedButton().isSelected())
/* 184 */           married = true;
/* 185 */         boolean hasChild = false;
/* 186 */         if (FamilyParentFrame.this.informationPanel.getHasButton().isSelected())
/* 187 */           hasChild = true;
/* 188 */         Node temp = new Node(FamilyParentFrame.this.informationPanel.getNameTextField()
/* 189 */           .getText().replaceAll(" ", ""), FamilyParentFrame.this.informationPanel
/* 190 */           .getBornplaceTextField().getText().replaceAll(" ", ""), 
/* 191 */           birthday, deathday, sex, isDead, FamilyParentFrame.this.informationPanel
/* 192 */           .getJobTextField().getText()
/* 193 */           .replaceAll(" ", ""), FamilyParentFrame.this.informationPanel
/* 194 */           .getTelephoneTextField().getText().replaceAll(
/* 195 */           " ", ""), FamilyParentFrame.this.informationPanel
/* 196 */           .getTop_titleTextField().getText().replaceAll(
/* 197 */           " ", ""), FamilyParentFrame.this.informationPanel
/* 198 */           .getAddressTextField().getText().replaceAll(
/* 199 */           " ", ""), height, 
/*     */           
/* 201 */           (byte)FamilyParentFrame.this.informationPanel.getEducationComboBox().getSelectedIndex(), married, hasChild);
/* 202 */         nodetree.addParentMember(node, temp);
/* 203 */         JOptionPane.showMessageDialog(null, "添加成功。", "提示", 
/* 204 */           1);
/* 205 */         FamilyParentFrame.this.dispose();
/* 206 */         centerPanel.removeAll();
/* 207 */         centerPanel.add(new ShowAllMemberPanel(centerPanel, textarea, 
/* 208 */           nodetree), "Center");
/* 209 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/*     */       }
/*     */       
/* 212 */     });
/* 213 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 215 */         FamilyParentFrame.this.dispose();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\add\FamilyParentFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */