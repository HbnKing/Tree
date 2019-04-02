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
/*     */ public class FamilyRootFrame
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
/*     */   public FamilyRootFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*     */   {
/*  46 */     setTitle("添加家谱中的祖先");
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
/*     */     
/*  66 */     getContentPane().add(this.noticePanel, "North");
/*     */     
/*  68 */     getContentPane().add(this.informationPanel, "Center");
/*     */     
/*  70 */     getContentPane().add(this.buttonPanel, "South");
/*     */     
/*  72 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  74 */         FamilyRootFrame.this.informationPanel.getNameTextField().setText("");
/*  75 */         FamilyRootFrame.this.informationPanel.getBornplaceTextField().setText("");
/*  76 */         FamilyRootFrame.this.informationPanel.getJobTextField().setText("");
/*  77 */         FamilyRootFrame.this.informationPanel.getTop_titleTextField().setText("");
/*  78 */         FamilyRootFrame.this.informationPanel.getTelephoneTextField().setText("");
/*  79 */         FamilyRootFrame.this.informationPanel.getAddressTextField().setText("");
/*  80 */         FamilyRootFrame.this.informationPanel.getYearTextField1().setText("");
/*  81 */         FamilyRootFrame.this.informationPanel.getYearTextField2().setText("");
/*  82 */         FamilyRootFrame.this.informationPanel.getSexButtonGroup().clearSelection();
/*  83 */         FamilyRootFrame.this.informationPanel.getMarriedButtonGroup().clearSelection();
/*  84 */         FamilyRootFrame.this.informationPanel.getDeadButtonGroup().clearSelection();
/*  85 */         FamilyRootFrame.this.informationPanel.getHasChildButtonGroup().clearSelection();
/*  86 */         FamilyRootFrame.this.informationPanel.getCentimeterComboBox().setSelectedIndex(0);
/*  87 */         FamilyRootFrame.this.informationPanel.getMeterComboBox().setSelectedIndex(0);
/*  88 */         FamilyRootFrame.this.informationPanel.getDecimeterComboBox().setSelectedIndex(0);
/*  89 */         FamilyRootFrame.this.informationPanel.getMonthComboBox1().setSelectedIndex(0);
/*  90 */         FamilyRootFrame.this.informationPanel.getDayComboBox1().setSelectedIndex(0);
/*  91 */         FamilyRootFrame.this.informationPanel.getMonthComboBox2().setSelectedIndex(0);
/*  92 */         FamilyRootFrame.this.informationPanel.getDayComboBox2().setSelectedIndex(0);
/*  93 */         FamilyRootFrame.this.informationPanel.getEducationComboBox().setSelectedIndex(0);
/*     */       }
/*     */       
/*  96 */     });
/*  97 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  99 */         if ((FamilyRootFrame.this.informationPanel.getNameTextField().getText().equals("")) || 
/*     */         
/* 101 */           (FamilyRootFrame.this.informationPanel.getBornplaceTextField().getText().equals("")) || 
/*     */           
/* 103 */           (FamilyRootFrame.this.informationPanel.getYearTextField1().getText().equals("")) || 
/* 104 */           ((!FamilyRootFrame.this.informationPanel.getMaleButton().isSelected()) && 
/* 105 */           (!FamilyRootFrame.this.informationPanel.getFemaleButton().isSelected())) || (
/* 106 */           (!FamilyRootFrame.this.informationPanel.getIsDeadButton().isSelected()) && 
/* 107 */           (!FamilyRootFrame.this.informationPanel.getIsAliveButton().isSelected()))) {
/* 108 */           JOptionPane.showMessageDialog(null, "请填写全部信息。", "错误提示", 
/* 109 */             0);
/* 110 */           return;
/*     */         }
/* 112 */         String year = FamilyRootFrame.this.informationPanel.getYearTextField1().getText()
/* 113 */           .trim();
/* 114 */         String month = FamilyRootFrame.this.informationPanel.getMonthComboBox1()
/* 115 */           .getSelectedItem().toString();
/* 116 */         String day = FamilyRootFrame.this.informationPanel.getDayComboBox1()
/* 117 */           .getSelectedItem().toString();
/* 118 */         if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 119 */           JOptionPane.showMessageDialog(null, "出生日期输入有误。", "错误提示", 
/* 120 */             0);
/* 121 */           return;
/*     */         }
/* 123 */         String birthday = year + "-" + month + "-" + day;
///*     */         byte sex;
/* 125 */         byte sex; if (FamilyRootFrame.this.informationPanel.getMaleButton().isSelected()) {
/* 126 */           sex = 0;
/*     */         } else
/* 128 */           sex = 1;
/* 129 */         boolean isDead = false;
/* 130 */         if (FamilyRootFrame.this.informationPanel.getIsDeadButton().isSelected()) {
/* 131 */           isDead = true;
/* 132 */           if (FamilyRootFrame.this.informationPanel.getYearTextField2().getText().equals(
/* 133 */             "")) {
/* 134 */             JOptionPane.showMessageDialog(null, "请填写死亡日期时间。", 
/* 135 */               "错误提示", 0);
/* 136 */             return;
/*     */           }
/* 138 */           year = 
/* 139 */             FamilyRootFrame.this.informationPanel.getYearTextField2().getText().trim();
/* 140 */           month = FamilyRootFrame.this.informationPanel.getMonthComboBox2()
/* 141 */             .getSelectedItem().toString();
/* 142 */           day = FamilyRootFrame.this.informationPanel.getDayComboBox2().getSelectedItem()
/* 143 */             .toString();
/* 144 */           if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 145 */             JOptionPane.showMessageDialog(null, "死亡日期输入有误。", 
/* 146 */               "错误提示", 0);
/* 147 */             return;
/*     */           }
/*     */           
/* 150 */           if (!new BirthdayDeathdayCheck(year, month, day, birthday).DateCheckResult()) {
/* 151 */             JOptionPane.showMessageDialog(null, "死亡日期先于出生日期，输入有误。", 
/* 152 */               "错误提示", 0); return;
/*     */           }
/*     */         }
/*     */         
///*     */         String deathday;
/*     */         String deathday;
/* 158 */         if (isDead) {
/* 159 */           deathday = year + "-" + month + "-" + day;
/*     */         } else {
/* 161 */           deathday = "";
/*     */         }
/*     */         
/* 164 */         int meter = FamilyRootFrame.this.informationPanel.getMeterComboBox().getSelectedIndex();
/* 165 */         int decimeter = FamilyRootFrame.this.informationPanel.getDecimeterComboBox()
/* 166 */           .getSelectedIndex();
/* 167 */         int centimeter = FamilyRootFrame.this.informationPanel.getCentimeterComboBox()
/* 168 */           .getSelectedIndex();
/* 169 */         double height = meter + decimeter / 10.0D + 
/* 170 */           centimeter / 100.0D;
/* 171 */         DecimalFormat df = new DecimalFormat("#.00");
/* 172 */         height = Double.parseDouble(df.format(height));
/* 173 */         boolean married = false;
/* 174 */         if (FamilyRootFrame.this.informationPanel.getMarriedButton().isSelected())
/* 175 */           married = true;
/* 176 */         boolean hasChild = false;
/* 177 */         if (FamilyRootFrame.this.informationPanel.getHasButton().isSelected())
/* 178 */           hasChild = true;
/* 179 */         Node temp = new Node(FamilyRootFrame.this.informationPanel.getNameTextField()
/* 180 */           .getText().replaceAll(" ", ""), FamilyRootFrame.this.informationPanel
/* 181 */           .getBornplaceTextField().getText().replaceAll(" ", ""), 
/* 182 */           birthday, deathday, sex, isDead, FamilyRootFrame.this.informationPanel
/* 183 */           .getJobTextField().getText()
/* 184 */           .replaceAll(" ", ""), FamilyRootFrame.this.informationPanel
/* 185 */           .getTelephoneTextField().getText().replaceAll(
/* 186 */           " ", ""), FamilyRootFrame.this.informationPanel
/* 187 */           .getTop_titleTextField().getText().replaceAll(
/* 188 */           " ", ""), FamilyRootFrame.this.informationPanel
/* 189 */           .getAddressTextField().getText().replaceAll(
/* 190 */           " ", ""), height, 
/*     */           
/* 192 */           (byte)FamilyRootFrame.this.informationPanel.getEducationComboBox().getSelectedIndex(), married, hasChild);
/* 193 */         nodetree.addRootMember(temp);
/* 194 */         JOptionPane.showMessageDialog(null, "添加成功。", "提示", 
/* 195 */           1);
/* 196 */         FamilyRootFrame.this.dispose();
/* 197 */         centerPanel.removeAll();
/* 198 */         centerPanel.add(new ShowAllMemberPanel(centerPanel, textarea, 
/* 199 */           nodetree), "Center");
/* 200 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/*     */       }
/*     */       
/* 203 */     });
/* 204 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 206 */         FamilyRootFrame.this.dispose();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\add\FamilyRootFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */