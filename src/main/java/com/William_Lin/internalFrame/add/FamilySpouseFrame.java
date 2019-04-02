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
/*     */ public class FamilySpouseFrame
/*     */   extends JFrame
/*     */   implements ScreenSize
/*     */ {
/*     */   private static final long serialVersionUID = -112882105303949674L;
/*     */   private NoticePanel noticePanel;
/*     */   private InformationPanel informationPanel;
/*     */   private ButtonPanel buttonPanel;
/*     */   private ImageIcon iconForNoticePanel;
/*     */   private ImageIcon iconForInformationPanel;
/*     */   private ImageIcon iconForButtonPanel;
/*     */   
/*     */   public FamilySpouseFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree, final Node node)
/*     */   {
/*  47 */     setTitle("添加选中对象的配偶");
/*  48 */     setLayout(new BorderLayout());
/*  49 */     setSize(430, 520);
/*  50 */     setLocation((int)((screenWidth - getWidth()) * 0.618D / 1.618D), 
/*  51 */       (int)((screenHeight - getHeight()) * 0.618D / 1.618D));
/*  52 */     setDefaultCloseOperation(2);
/*  53 */     setVisible(true);
/*  54 */     setResizable(false);
/*     */     
/*  56 */     URL resource = getClass().getResource("/img/1.png");
/*  57 */     this.iconForNoticePanel = new ImageIcon(resource);
/*  58 */     resource = getClass().getResource("/img/2.png");
/*  59 */     this.iconForInformationPanel = new ImageIcon(resource);
/*  60 */     resource = getClass().getResource("/img/3.png");
/*  61 */     this.iconForButtonPanel = new ImageIcon(resource);
/*     */     
/*  63 */     this.noticePanel = new NoticePanel(this.iconForNoticePanel);
/*  64 */     this.informationPanel = new InformationPanel(this.iconForInformationPanel);
/*  65 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/*     */     
/*  67 */     getContentPane().add(this.noticePanel, "North");
/*     */     
/*  69 */     getContentPane().add(this.informationPanel, "Center");
/*     */     
/*  71 */     getContentPane().add(this.buttonPanel, "South");
/*     */     
/*  73 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  75 */         FamilySpouseFrame.this.informationPanel.getNameTextField().setText("");
/*  76 */         FamilySpouseFrame.this.informationPanel.getBornplaceTextField().setText("");
/*  77 */         FamilySpouseFrame.this.informationPanel.getJobTextField().setText("");
/*  78 */         FamilySpouseFrame.this.informationPanel.getTop_titleTextField().setText("");
/*  79 */         FamilySpouseFrame.this.informationPanel.getTelephoneTextField().setText("");
/*  80 */         FamilySpouseFrame.this.informationPanel.getAddressTextField().setText("");
/*  81 */         FamilySpouseFrame.this.informationPanel.getYearTextField1().setText("");
/*  82 */         FamilySpouseFrame.this.informationPanel.getYearTextField2().setText("");
/*  83 */         FamilySpouseFrame.this.informationPanel.getSexButtonGroup().clearSelection();
/*  84 */         FamilySpouseFrame.this.informationPanel.getMarriedButtonGroup().clearSelection();
/*  85 */         FamilySpouseFrame.this.informationPanel.getDeadButtonGroup().clearSelection();
/*  86 */         FamilySpouseFrame.this.informationPanel.getHasChildButtonGroup().clearSelection();
/*  87 */         FamilySpouseFrame.this.informationPanel.getCentimeterComboBox().setSelectedIndex(0);
/*  88 */         FamilySpouseFrame.this.informationPanel.getMeterComboBox().setSelectedIndex(0);
/*  89 */         FamilySpouseFrame.this.informationPanel.getDecimeterComboBox().setSelectedIndex(0);
/*  90 */         FamilySpouseFrame.this.informationPanel.getMonthComboBox1().setSelectedIndex(0);
/*  91 */         FamilySpouseFrame.this.informationPanel.getDayComboBox1().setSelectedIndex(0);
/*  92 */         FamilySpouseFrame.this.informationPanel.getMonthComboBox2().setSelectedIndex(0);
/*  93 */         FamilySpouseFrame.this.informationPanel.getDayComboBox2().setSelectedIndex(0);
/*  94 */         FamilySpouseFrame.this.informationPanel.getEducationComboBox().setSelectedIndex(0);
/*     */       }
/*     */       
/*  97 */     });
/*  98 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 100 */         if ((FamilySpouseFrame.this.informationPanel.getNameTextField().getText().equals("")) || 
/*     */         
/* 102 */           (FamilySpouseFrame.this.informationPanel.getBornplaceTextField().getText().equals("")) || 
/*     */           
/* 104 */           (FamilySpouseFrame.this.informationPanel.getYearTextField1().getText().equals("")) || 
/* 105 */           ((!FamilySpouseFrame.this.informationPanel.getMaleButton().isSelected()) && 
/* 106 */           (!FamilySpouseFrame.this.informationPanel.getFemaleButton().isSelected())) || (
/* 107 */           (!FamilySpouseFrame.this.informationPanel.getIsDeadButton().isSelected()) && 
/* 108 */           (!FamilySpouseFrame.this.informationPanel.getIsAliveButton().isSelected()))) {
/* 109 */           JOptionPane.showMessageDialog(null, "请填写全部信息。", "错误提示", 
/* 110 */             0);
/* 111 */           return;
/*     */         }
/* 113 */         String year = FamilySpouseFrame.this.informationPanel.getYearTextField1().getText()
/* 114 */           .trim();
/* 115 */         String month = FamilySpouseFrame.this.informationPanel.getMonthComboBox1()
/* 116 */           .getSelectedItem().toString();
/* 117 */         String day = FamilySpouseFrame.this.informationPanel.getDayComboBox1()
/* 118 */           .getSelectedItem().toString();
/* 119 */         if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 120 */           JOptionPane.showMessageDialog(null, "出生日期输入有误。", "错误提示", 
/* 121 */             0);
/* 122 */           return;
/*     */         }
/* 124 */         String birthday = year + "-" + month + "-" + day;
///*     */         byte sex;
/* 126 */         byte sex; if (FamilySpouseFrame.this.informationPanel.getMaleButton().isSelected()) {
/* 127 */           sex = 0;
/*     */         } else
/* 129 */           sex = 1;
/* 130 */         boolean isDead = false;
/* 131 */         if (FamilySpouseFrame.this.informationPanel.getIsDeadButton().isSelected()) {
/* 132 */           isDead = true;
/* 133 */           if (FamilySpouseFrame.this.informationPanel.getYearTextField2().getText().equals(
/* 134 */             "")) {
/* 135 */             JOptionPane.showMessageDialog(null, "请填写死亡日期时间。", 
/* 136 */               "错误提示", 0);
/* 137 */             return;
/*     */           }
/* 139 */           year = 
/* 140 */             FamilySpouseFrame.this.informationPanel.getYearTextField2().getText().trim();
/* 141 */           month = FamilySpouseFrame.this.informationPanel.getMonthComboBox2()
/* 142 */             .getSelectedItem().toString();
/* 143 */           day = FamilySpouseFrame.this.informationPanel.getDayComboBox2().getSelectedItem()
/* 144 */             .toString();
/* 145 */           if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 146 */             JOptionPane.showMessageDialog(null, "死亡日期输入有误。", 
/* 147 */               "错误提示", 0);
/* 148 */             return;
/*     */           }
/*     */           
/* 151 */           if (!new BirthdayDeathdayCheck(year, month, day, birthday).DateCheckResult()) {
/* 152 */             JOptionPane.showMessageDialog(null, "死亡日期先于出生日期，输入有误。", 
/* 153 */               "错误提示", 0); return;
/*     */           }
/*     */         }
/*     */         
///*     */         String deathday;
/*     */         String deathday;
/* 159 */         if (isDead) {
/* 160 */           deathday = year + "-" + month + "-" + day;
/*     */         } else {
/* 162 */           deathday = "";
/*     */         }
/*     */         
/* 165 */         int meter = FamilySpouseFrame.this.informationPanel.getMeterComboBox().getSelectedIndex();
/* 166 */         int decimeter = FamilySpouseFrame.this.informationPanel.getDecimeterComboBox()
/* 167 */           .getSelectedIndex();
/* 168 */         int centimeter = FamilySpouseFrame.this.informationPanel.getCentimeterComboBox()
/* 169 */           .getSelectedIndex();
/* 170 */         double height = meter + decimeter / 10.0D + 
/* 171 */           centimeter / 100.0D;
/* 172 */         DecimalFormat df = new DecimalFormat("#.00");
/* 173 */         height = Double.parseDouble(df.format(height));
/* 174 */         boolean married = false;
/* 175 */         if (FamilySpouseFrame.this.informationPanel.getMarriedButton().isSelected())
/* 176 */           married = true;
/* 177 */         boolean hasChild = false;
/* 178 */         if (FamilySpouseFrame.this.informationPanel.getHasButton().isSelected())
/* 179 */           hasChild = true;
/* 180 */         Node temp = new Node(FamilySpouseFrame.this.informationPanel.getNameTextField()
/* 181 */           .getText().replaceAll(" ", ""), FamilySpouseFrame.this.informationPanel
/* 182 */           .getBornplaceTextField().getText().replaceAll(" ", ""), 
/* 183 */           birthday, deathday, sex, isDead, FamilySpouseFrame.this.informationPanel
/* 184 */           .getJobTextField().getText()
/* 185 */           .replaceAll(" ", ""), FamilySpouseFrame.this.informationPanel
/* 186 */           .getTelephoneTextField().getText().replaceAll(
/* 187 */           " ", ""), FamilySpouseFrame.this.informationPanel
/* 188 */           .getTop_titleTextField().getText().replaceAll(
/* 189 */           " ", ""), FamilySpouseFrame.this.informationPanel
/* 190 */           .getAddressTextField().getText().replaceAll(
/* 191 */           " ", ""), height, 
/*     */           
/* 193 */           (byte)FamilySpouseFrame.this.informationPanel.getEducationComboBox().getSelectedIndex(), married, hasChild);
/* 194 */         nodetree.addSpouseMember(node, temp);
/* 195 */         JOptionPane.showMessageDialog(null, "添加成功。", "提示", 
/* 196 */           1);
/* 197 */         FamilySpouseFrame.this.dispose();
/* 198 */         centerPanel.removeAll();
/* 199 */         centerPanel.add(new ShowAllMemberPanel(centerPanel, textarea, 
/* 200 */           nodetree), "Center");
/* 201 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/*     */       }
/*     */       
/* 204 */     });
/* 205 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 207 */         FamilySpouseFrame.this.dispose();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\add\FamilySpouseFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */