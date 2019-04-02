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
/*     */ public class FamilyChildrenFrame
/*     */   extends JFrame
/*     */   implements ScreenSize
/*     */ {
/*     */   private static final long serialVersionUID = -6665783558471352605L;
/*     */   private NoticePanel noticePanel;
/*     */   private InformationPanel informationPanel;
/*     */   private ButtonPanel buttonPanel;
/*     */   private ImageIcon iconForNoticePanel;
/*     */   private ImageIcon iconForInformationPanel;
/*     */   private ImageIcon iconForButtonPanel;
/*     */   
/*     */   public FamilyChildrenFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree, final Node node)
/*     */   {
/*  47 */     setTitle("添加选中对象的孩子");
/*  48 */     setLayout(new BorderLayout());
/*  49 */     setSize(430, 520);
/*  50 */     setLocation((int)((screenWidth - getWidth()) * 0.618D / 1.618D), 
/*  51 */       (int)((screenHeight - getHeight()) * 0.618D / 1.618D));
/*  52 */     setDefaultCloseOperation(2);
/*  53 */     setVisible(true);
/*  54 */     setResizable(false);
/*     */     
/*     */ 
/*  57 */     URL resource = getClass().getResource("/img/1.png");
/*  58 */     this.iconForNoticePanel = new ImageIcon(resource);
/*  59 */     resource = getClass().getResource("/img/2.png");
/*  60 */     this.iconForInformationPanel = new ImageIcon(resource);
/*  61 */     resource = getClass().getResource("/img/3.png");
/*  62 */     this.iconForButtonPanel = new ImageIcon(resource);
/*     */     
/*  64 */     this.noticePanel = new NoticePanel(this.iconForNoticePanel);
/*  65 */     this.informationPanel = new InformationPanel(this.iconForInformationPanel);
/*  66 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/*     */     
/*  68 */     getContentPane().add(this.noticePanel, "North");
/*     */     
/*  70 */     getContentPane().add(this.informationPanel, "Center");
/*     */     
/*  72 */     getContentPane().add(this.buttonPanel, "South");
/*     */     
/*     */ 
/*  75 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  77 */         FamilyChildrenFrame.this.informationPanel.getNameTextField().setText("");
/*  78 */         FamilyChildrenFrame.this.informationPanel.getBornplaceTextField().setText("");
/*  79 */         FamilyChildrenFrame.this.informationPanel.getJobTextField().setText("");
/*  80 */         FamilyChildrenFrame.this.informationPanel.getTop_titleTextField().setText("");
/*  81 */         FamilyChildrenFrame.this.informationPanel.getTelephoneTextField().setText("");
/*  82 */         FamilyChildrenFrame.this.informationPanel.getAddressTextField().setText("");
/*  83 */         FamilyChildrenFrame.this.informationPanel.getYearTextField1().setText("");
/*  84 */         FamilyChildrenFrame.this.informationPanel.getYearTextField2().setText("");
/*  85 */         FamilyChildrenFrame.this.informationPanel.getSexButtonGroup().clearSelection();
/*  86 */         FamilyChildrenFrame.this.informationPanel.getMarriedButtonGroup().clearSelection();
/*  87 */         FamilyChildrenFrame.this.informationPanel.getDeadButtonGroup().clearSelection();
/*  88 */         FamilyChildrenFrame.this.informationPanel.getHasChildButtonGroup().clearSelection();
/*  89 */         FamilyChildrenFrame.this.informationPanel.getCentimeterComboBox().setSelectedIndex(0);
/*  90 */         FamilyChildrenFrame.this.informationPanel.getMeterComboBox().setSelectedIndex(0);
/*  91 */         FamilyChildrenFrame.this.informationPanel.getDecimeterComboBox().setSelectedIndex(0);
/*  92 */         FamilyChildrenFrame.this.informationPanel.getMonthComboBox1().setSelectedIndex(0);
/*  93 */         FamilyChildrenFrame.this.informationPanel.getDayComboBox1().setSelectedIndex(0);
/*  94 */         FamilyChildrenFrame.this.informationPanel.getMonthComboBox2().setSelectedIndex(0);
/*  95 */         FamilyChildrenFrame.this.informationPanel.getDayComboBox2().setSelectedIndex(0);
/*  96 */         FamilyChildrenFrame.this.informationPanel.getEducationComboBox().setSelectedIndex(0);
/*     */       }
/*     */       
/*     */ 
/* 100 */     });
/* 101 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 103 */         if ((FamilyChildrenFrame.this.informationPanel.getNameTextField().getText().equals("")) || 
/*     */         
/* 105 */           (FamilyChildrenFrame.this.informationPanel.getBornplaceTextField().getText().equals("")) || 
/*     */           
/* 107 */           (FamilyChildrenFrame.this.informationPanel.getYearTextField1().getText().equals("")) || 
/* 108 */           ((!FamilyChildrenFrame.this.informationPanel.getMaleButton().isSelected()) && 
/* 109 */           (!FamilyChildrenFrame.this.informationPanel.getFemaleButton().isSelected())) || (
/* 110 */           (!FamilyChildrenFrame.this.informationPanel.getIsDeadButton().isSelected()) && 
/* 111 */           (!FamilyChildrenFrame.this.informationPanel.getIsAliveButton().isSelected()))) {
/* 112 */           JOptionPane.showMessageDialog(null, "请填写全部信息。", "错误提示", 
/* 113 */             0);
/* 114 */           return;
/*     */         }
/* 116 */         String year = FamilyChildrenFrame.this.informationPanel.getYearTextField1().getText()
/* 117 */           .trim();
/* 118 */         String month = FamilyChildrenFrame.this.informationPanel.getMonthComboBox1()
/* 119 */           .getSelectedItem().toString();
/* 120 */         String day = FamilyChildrenFrame.this.informationPanel.getDayComboBox1()
/* 121 */           .getSelectedItem().toString();
/* 122 */         if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 123 */           JOptionPane.showMessageDialog(null, "出生日期输入有误。", "错误提示", 
/* 124 */             0);
/* 125 */           return;
/*     */         }
/* 127 */         String birthday = year + "-" + month + "-" + day;
///*     */         byte sex;
/* 129 */         byte sex; if (FamilyChildrenFrame.this.informationPanel.getMaleButton().isSelected()) {
/* 130 */           sex = 0;
/*     */         } else
/* 132 */           sex = 1;
/* 133 */         boolean isDead = false;
/* 134 */         if (FamilyChildrenFrame.this.informationPanel.getIsDeadButton().isSelected()) {
/* 135 */           isDead = true;
/* 136 */           if (FamilyChildrenFrame.this.informationPanel.getYearTextField2().getText().equals(
/* 137 */             "")) {
/* 138 */             JOptionPane.showMessageDialog(null, "请填写死亡日期时间。", 
/* 139 */               "错误提示", 0);
/* 140 */             return;
/*     */           }
/* 142 */           year = 
/* 143 */             FamilyChildrenFrame.this.informationPanel.getYearTextField2().getText().trim();
/* 144 */           month = FamilyChildrenFrame.this.informationPanel.getMonthComboBox2()
/* 145 */             .getSelectedItem().toString();
/* 146 */           day = FamilyChildrenFrame.this.informationPanel.getDayComboBox2().getSelectedItem()
/* 147 */             .toString();
/* 148 */           if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 149 */             JOptionPane.showMessageDialog(null, "死亡日期输入有误。", 
/* 150 */               "错误提示", 0);
/* 151 */             return;
/*     */           }
/*     */           
/* 154 */           if (!new BirthdayDeathdayCheck(year, month, day, birthday).DateCheckResult()) {
/* 155 */             JOptionPane.showMessageDialog(null, "死亡日期先于出生日期，输入有误。", 
/* 156 */               "错误提示", 0); return;
/*     */           }
/*     */         }
/*     */         
/*     */         String deathday;
///*     */         String deathday;
/* 162 */         if (isDead) {
/* 163 */           deathday = year + "-" + month + "-" + day;
/*     */         } else {
/* 165 */           deathday = "";
/*     */         }
/*     */         
/* 168 */         int meter = FamilyChildrenFrame.this.informationPanel.getMeterComboBox().getSelectedIndex();
/* 169 */         int decimeter = FamilyChildrenFrame.this.informationPanel.getDecimeterComboBox()
/* 170 */           .getSelectedIndex();
/* 171 */         int centimeter = FamilyChildrenFrame.this.informationPanel.getCentimeterComboBox()
/* 172 */           .getSelectedIndex();
/* 173 */         double height = meter + decimeter / 10.0D + 
/* 174 */           centimeter / 100.0D;
/* 175 */         DecimalFormat df = new DecimalFormat("#.00");
/* 176 */         height = Double.parseDouble(df.format(height));
/* 177 */         boolean married = false;
/* 178 */         if (FamilyChildrenFrame.this.informationPanel.getMarriedButton().isSelected())
/* 179 */           married = true;
/* 180 */         boolean hasChild = false;
/* 181 */         if (FamilyChildrenFrame.this.informationPanel.getHasButton().isSelected())
/* 182 */           hasChild = true;
/* 183 */         Node temp = new Node(FamilyChildrenFrame.this.informationPanel.getNameTextField()
/* 184 */           .getText().replaceAll(" ", ""), FamilyChildrenFrame.this.informationPanel
/* 185 */           .getBornplaceTextField().getText().replaceAll(" ", ""), 
/* 186 */           birthday, deathday, sex, isDead, FamilyChildrenFrame.this.informationPanel
/* 187 */           .getJobTextField().getText()
/* 188 */           .replaceAll(" ", ""), FamilyChildrenFrame.this.informationPanel
/* 189 */           .getTelephoneTextField().getText().replaceAll(
/* 190 */           " ", ""), FamilyChildrenFrame.this.informationPanel
/* 191 */           .getTop_titleTextField().getText().replaceAll(
/* 192 */           " ", ""), FamilyChildrenFrame.this.informationPanel
/* 193 */           .getAddressTextField().getText().replaceAll(
/* 194 */           " ", ""), height, 
/*     */           
/* 196 */           (byte)FamilyChildrenFrame.this.informationPanel.getEducationComboBox().getSelectedIndex(), married, hasChild);
/* 197 */         nodetree.addChildMember(node, temp);
/* 198 */         JOptionPane.showMessageDialog(null, "添加成功。", "提示", 
/* 199 */           1);
/* 200 */         FamilyChildrenFrame.this.dispose();
/* 201 */         centerPanel.removeAll();
/* 202 */         centerPanel.add(new ShowAllMemberPanel(centerPanel, textarea, 
/* 203 */           nodetree), "Center");
/* 204 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/*     */       }
/*     */       
/*     */ 
/* 208 */     });
/* 209 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 211 */         FamilyChildrenFrame.this.dispose();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\add\FamilyChildrenFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */