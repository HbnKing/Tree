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
/*     */ public class FamilySiblingFrame
/*     */   extends JFrame
/*     */   implements ScreenSize
/*     */ {
/*     */   private static final long serialVersionUID = 4411247887191385828L;
/*     */   private NoticePanel noticePanel;
/*     */   private InformationPanel informationPanel;
/*     */   private ButtonPanel buttonPanel;
/*     */   private ImageIcon iconForNoticePanel;
/*     */   private ImageIcon iconForInformationPanel;
/*     */   private ImageIcon iconForButtonPanel;
/*     */   
/*     */   public FamilySiblingFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree, final Node node)
/*     */   {
/*  46 */     setTitle("添加选中对象的兄弟姐妹");
/*  47 */     setLayout(new BorderLayout());
/*  48 */     setSize(430, 520);
/*  49 */     setLocation((int)((screenWidth - getWidth()) * 0.618D / 1.618D), 
/*  50 */       (int)((screenHeight - getHeight()) * 0.618D / 1.618D));
/*  51 */     setDefaultCloseOperation(2);
/*  52 */     setVisible(true);
/*  53 */     setResizable(false);
/*     */     
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
/*  65 */     getContentPane().add(this.noticePanel, "North");
/*     */     
/*  67 */     getContentPane().add(this.informationPanel, "Center");
/*     */     
/*  69 */     getContentPane().add(this.buttonPanel, "South");
/*     */     
/*  71 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  73 */         FamilySiblingFrame.this.informationPanel.getNameTextField().setText("");
/*  74 */         FamilySiblingFrame.this.informationPanel.getBornplaceTextField().setText("");
/*  75 */         FamilySiblingFrame.this.informationPanel.getJobTextField().setText("");
/*  76 */         FamilySiblingFrame.this.informationPanel.getTop_titleTextField().setText("");
/*  77 */         FamilySiblingFrame.this.informationPanel.getTelephoneTextField().setText("");
/*  78 */         FamilySiblingFrame.this.informationPanel.getAddressTextField().setText("");
/*  79 */         FamilySiblingFrame.this.informationPanel.getYearTextField1().setText("");
/*  80 */         FamilySiblingFrame.this.informationPanel.getYearTextField2().setText("");
/*  81 */         FamilySiblingFrame.this.informationPanel.getSexButtonGroup().clearSelection();
/*  82 */         FamilySiblingFrame.this.informationPanel.getMarriedButtonGroup().clearSelection();
/*  83 */         FamilySiblingFrame.this.informationPanel.getDeadButtonGroup().clearSelection();
/*  84 */         FamilySiblingFrame.this.informationPanel.getHasChildButtonGroup().clearSelection();
/*  85 */         FamilySiblingFrame.this.informationPanel.getCentimeterComboBox().setSelectedIndex(0);
/*  86 */         FamilySiblingFrame.this.informationPanel.getMeterComboBox().setSelectedIndex(0);
/*  87 */         FamilySiblingFrame.this.informationPanel.getDecimeterComboBox().setSelectedIndex(0);
/*  88 */         FamilySiblingFrame.this.informationPanel.getMonthComboBox1().setSelectedIndex(0);
/*  89 */         FamilySiblingFrame.this.informationPanel.getDayComboBox1().setSelectedIndex(0);
/*  90 */         FamilySiblingFrame.this.informationPanel.getMonthComboBox2().setSelectedIndex(0);
/*  91 */         FamilySiblingFrame.this.informationPanel.getDayComboBox2().setSelectedIndex(0);
/*  92 */         FamilySiblingFrame.this.informationPanel.getEducationComboBox().setSelectedIndex(0);
/*     */       }
/*     */       
/*  95 */     });
/*  96 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  98 */         if ((FamilySiblingFrame.this.informationPanel.getNameTextField().getText().equals("")) || 
/*     */         
/* 100 */           (FamilySiblingFrame.this.informationPanel.getBornplaceTextField().getText().equals("")) || 
/*     */           
/* 102 */           (FamilySiblingFrame.this.informationPanel.getYearTextField1().getText().equals("")) || 
/* 103 */           ((!FamilySiblingFrame.this.informationPanel.getMaleButton().isSelected()) && 
/* 104 */           (!FamilySiblingFrame.this.informationPanel.getFemaleButton().isSelected())) || (
/* 105 */           (!FamilySiblingFrame.this.informationPanel.getIsDeadButton().isSelected()) && 
/* 106 */           (!FamilySiblingFrame.this.informationPanel.getIsAliveButton().isSelected()))) {
/* 107 */           JOptionPane.showMessageDialog(null, "请填写全部信息。", "错误提示", 
/* 108 */             0);
/* 109 */           return;
/*     */         }
/* 111 */         String year = FamilySiblingFrame.this.informationPanel.getYearTextField1().getText()
/* 112 */           .trim();
/* 113 */         String month = FamilySiblingFrame.this.informationPanel.getMonthComboBox1()
/* 114 */           .getSelectedItem().toString();
/* 115 */         String day = FamilySiblingFrame.this.informationPanel.getDayComboBox1()
/* 116 */           .getSelectedItem().toString();
/* 117 */         if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 118 */           JOptionPane.showMessageDialog(null, "出生日期输入有误。", "错误提示", 
/* 119 */             0);
/* 120 */           return;
/*     */         }
/* 122 */         String birthday = year + "-" + month + "-" + day;
///*     */         byte sex;
/* 124 */         byte sex; if (FamilySiblingFrame.this.informationPanel.getMaleButton().isSelected()) {
/* 125 */           sex = 0;
/*     */         } else
/* 127 */           sex = 1;
/* 128 */         boolean isDead = false;
/* 129 */         if (FamilySiblingFrame.this.informationPanel.getIsDeadButton().isSelected()) {
/* 130 */           isDead = true;
/* 131 */           if (FamilySiblingFrame.this.informationPanel.getYearTextField2().getText().equals(
/* 132 */             "")) {
/* 133 */             JOptionPane.showMessageDialog(null, "请填写死亡日期时间。", 
/* 134 */               "错误提示", 0);
/* 135 */             return;
/*     */           }
/* 137 */           year = 
/* 138 */             FamilySiblingFrame.this.informationPanel.getYearTextField2().getText().trim();
/* 139 */           month = FamilySiblingFrame.this.informationPanel.getMonthComboBox2()
/* 140 */             .getSelectedItem().toString();
/* 141 */           day = FamilySiblingFrame.this.informationPanel.getDayComboBox2().getSelectedItem()
/* 142 */             .toString();
/* 143 */           if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 144 */             JOptionPane.showMessageDialog(null, "死亡日期输入有误。", 
/* 145 */               "错误提示", 0);
/* 146 */             return;
/*     */           }
/*     */           
/* 149 */           if (!new BirthdayDeathdayCheck(year, month, day, birthday).DateCheckResult()) {
/* 150 */             JOptionPane.showMessageDialog(null, "死亡日期先于出生日期，输入有误。", 
/* 151 */               "错误提示", 0); return;
/*     */           }
/*     */         }
/*     */         
///*     */         String deathday;
/*     */         String deathday;
/* 157 */         if (isDead) {
/* 158 */           deathday = year + "-" + month + "-" + day;
/*     */         } else {
/* 160 */           deathday = "";
/*     */         }
/*     */         
/* 163 */         int meter = FamilySiblingFrame.this.informationPanel.getMeterComboBox().getSelectedIndex();
/* 164 */         int decimeter = FamilySiblingFrame.this.informationPanel.getDecimeterComboBox()
/* 165 */           .getSelectedIndex();
/* 166 */         int centimeter = FamilySiblingFrame.this.informationPanel.getCentimeterComboBox()
/* 167 */           .getSelectedIndex();
/* 168 */         double height = meter + decimeter / 10.0D + 
/* 169 */           centimeter / 100.0D;
/* 170 */         DecimalFormat df = new DecimalFormat("#.00");
/* 171 */         height = Double.parseDouble(df.format(height));
/* 172 */         boolean married = false;
/* 173 */         if (FamilySiblingFrame.this.informationPanel.getMarriedButton().isSelected())
/* 174 */           married = true;
/* 175 */         boolean hasChild = false;
/* 176 */         if (FamilySiblingFrame.this.informationPanel.getHasButton().isSelected())
/* 177 */           hasChild = true;
/* 178 */         Node temp = new Node(FamilySiblingFrame.this.informationPanel.getNameTextField()
/* 179 */           .getText().replaceAll(" ", ""), FamilySiblingFrame.this.informationPanel
/* 180 */           .getBornplaceTextField().getText().replaceAll(" ", ""), 
/* 181 */           birthday, deathday, sex, isDead, FamilySiblingFrame.this.informationPanel
/* 182 */           .getJobTextField().getText()
/* 183 */           .replaceAll(" ", ""), FamilySiblingFrame.this.informationPanel
/* 184 */           .getTelephoneTextField().getText().replaceAll(
/* 185 */           " ", ""), FamilySiblingFrame.this.informationPanel
/* 186 */           .getTop_titleTextField().getText().replaceAll(
/* 187 */           " ", ""), FamilySiblingFrame.this.informationPanel
/* 188 */           .getAddressTextField().getText().replaceAll(
/* 189 */           " ", ""), height, 
/*     */           
/* 191 */           (byte)FamilySiblingFrame.this.informationPanel.getEducationComboBox().getSelectedIndex(), married, hasChild);
/* 192 */         nodetree.addSiblingMember(node, temp);
/* 193 */         JOptionPane.showMessageDialog(null, "添加成功。", "提示", 
/* 194 */           1);
/* 195 */         FamilySiblingFrame.this.dispose();
/* 196 */         centerPanel.removeAll();
/* 197 */         centerPanel.add(new ShowAllMemberPanel(centerPanel, textarea, 
/* 198 */           nodetree), "Center");
/* 199 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/*     */       }
/*     */       
/* 202 */     });
/* 203 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 205 */         FamilySiblingFrame.this.dispose();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\add\FamilySiblingFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */