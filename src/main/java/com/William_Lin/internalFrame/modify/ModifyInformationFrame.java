/*     */ package com.William_Lin.internalFrame.modify;
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
/*     */ 
/*     */ public class ModifyInformationFrame
/*     */   extends JFrame
/*     */   implements ScreenSize
/*     */ {
/*     */   private static final long serialVersionUID = -2252995179089269443L;
/*     */   private NoticePanel noticePanel;
/*     */   private InformationPanel informationPanel;
/*     */   private ButtonPanel buttonPanel;
/*     */   private ImageIcon iconForNoticePanel;
/*     */   private ImageIcon iconForInformationPanel;
/*     */   private ImageIcon iconForButtonPanel;
/*     */   
/*     */   public ModifyInformationFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree, final Node node)
/*     */   {
/*  46 */     setTitle("修改个人信息");
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
/*     */ 
/*  73 */     this.informationPanel.getNameTextField().setText(node.getName());
/*  74 */     this.informationPanel.getBornplaceTextField().setText(node.getBornplace());
/*  75 */     this.informationPanel.getJobTextField().setText(node.getJob());
/*  76 */     this.informationPanel.getTop_titleTextField().setText(node.getTop_title());
/*  77 */     this.informationPanel.getTelephoneTextField().setText(node.getTelephone());
/*  78 */     this.informationPanel.getAddressTextField().setText(node.getAddress());
/*     */     
/*  80 */     String[] birthdayString = node.getBirthday().split("-");
/*  81 */     this.informationPanel.getYearTextField1().setText(birthdayString[0]);
/*  82 */     this.informationPanel.getMonthComboBox1().setSelectedIndex(
/*  83 */       Integer.parseInt(birthdayString[1]) - 1);
/*  84 */     this.informationPanel.getDayComboBox1().setSelectedIndex(
/*  85 */       Integer.parseInt(birthdayString[2]) - 1);
/*  86 */     if (node.getIsDead()) {
/*  87 */       String[] deathdayString = node.getDeathday().split("-");
/*  88 */       this.informationPanel.getYearTextField2().setText(deathdayString[0]);
/*  89 */       int month = Integer.parseInt(deathdayString[1]);
/*  90 */       this.informationPanel.getMonthComboBox2().setSelectedItem(Integer.valueOf(month));
/*  91 */       int day = Integer.parseInt(deathdayString[2]);
/*  92 */       this.informationPanel.getDayComboBox2().setSelectedItem(Integer.valueOf(day));
/*     */     } else {
/*  94 */       this.informationPanel.getYearTextField2().setText("");
/*  95 */       this.informationPanel.getMonthComboBox2().setSelectedItem(Integer.valueOf(1));
/*  96 */       this.informationPanel.getDayComboBox2().setSelectedItem(Integer.valueOf(1));
/*  97 */       this.informationPanel.getYearTextField2().setEnabled(false);
/*  98 */       this.informationPanel.getMonthComboBox2().setEnabled(false);
/*  99 */       this.informationPanel.getDayComboBox2().setEnabled(false);
/*     */     }
/* 101 */     int height = (int)node.getHeight() * 100 / 100;
/* 102 */     this.informationPanel.getMeterComboBox().setSelectedItem(Integer.valueOf(height));
/* 103 */     height = (int)((node.getHeight() - height) * 100.0D) / 10;
/* 104 */     this.informationPanel.getDecimeterComboBox().setSelectedItem(Integer.valueOf(height));
/* 105 */     height = (int)(node.getHeight() * 100.0D) % 10;
/* 106 */     this.informationPanel.getCentimeterComboBox().setSelectedItem(Integer.valueOf(height));
/* 107 */     this.informationPanel.getEducationComboBox().setSelectedIndex(
/* 108 */       node.getEducation());
/* 109 */     if (node.getSex() == 0) {
/* 110 */       this.informationPanel.getMaleButton().setSelected(true);
/* 111 */       this.informationPanel.getFemaleButton().setEnabled(false);
/*     */     }
/*     */     else {
/* 114 */       this.informationPanel.getFemaleButton().setSelected(true); }
/* 115 */     if (node.getMarried()) {
/* 116 */       this.informationPanel.getMarriedButton().setSelected(true);
/*     */     } else
/* 118 */       this.informationPanel.getSingleButton().setSelected(true);
/* 119 */     if (node.getHasChild()) {
/* 120 */       this.informationPanel.getHasButton().setSelected(true);
/*     */     } else
/* 122 */       this.informationPanel.getNothaveButton().setSelected(true);
/* 123 */     if (node.getIsDead()) {
/* 124 */       this.informationPanel.getIsDeadButton().setSelected(true);
/* 125 */       this.informationPanel.add(this.informationPanel.getDeathdayPanel());
/*     */     } else {
/* 127 */       this.informationPanel.getIsAliveButton().setSelected(true);
/*     */     }
/* 129 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 131 */         if ((ModifyInformationFrame.this.informationPanel.getNameTextField().getText().equals("")) || 
/*     */         
/* 133 */           (ModifyInformationFrame.this.informationPanel.getBornplaceTextField().getText().equals("")) || 
/*     */           
/* 135 */           (ModifyInformationFrame.this.informationPanel.getYearTextField1().getText().equals("")) || 
/* 136 */           ((!ModifyInformationFrame.this.informationPanel.getMaleButton().isSelected()) && 
/* 137 */           (!ModifyInformationFrame.this.informationPanel.getFemaleButton().isSelected())) || (
/* 138 */           (!ModifyInformationFrame.this.informationPanel.getIsDeadButton().isSelected()) && 
/* 139 */           (!ModifyInformationFrame.this.informationPanel.getIsAliveButton().isSelected()))) {
/* 140 */           JOptionPane.showMessageDialog(null, "请填写全部信息", "错误提示", 
/* 141 */             0);
/* 142 */           return;
/*     */         }
/* 144 */         String year = ModifyInformationFrame.this.informationPanel.getYearTextField1().getText()
/* 145 */           .trim();
/* 146 */         String month = ModifyInformationFrame.this.informationPanel.getMonthComboBox1()
/* 147 */           .getSelectedItem().toString();
/* 148 */         String day = ModifyInformationFrame.this.informationPanel.getDayComboBox1()
/* 149 */           .getSelectedItem().toString();
/* 150 */         if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 151 */           JOptionPane.showMessageDialog(null, "出生日期输入有误", "错误提示", 
/* 152 */             0);
/* 153 */           return;
/*     */         }
/* 155 */         String birthday = year + "-" + month + "-" + day;
///*     */         byte sex;
/* 157 */         byte sex; if (ModifyInformationFrame.this.informationPanel.getMaleButton().isSelected()) {
/* 158 */           sex = 0;
/*     */         } else
/* 160 */           sex = 1;
/* 161 */         boolean isDead = false;
/* 162 */         if (ModifyInformationFrame.this.informationPanel.getIsDeadButton().isSelected()) {
/* 163 */           isDead = true;
/* 164 */           if (ModifyInformationFrame.this.informationPanel.getYearTextField2().getText().equals(
/* 165 */             "")) {
/* 166 */             JOptionPane.showMessageDialog(null, "请填写死亡日期时间", 
/* 167 */               "错误提示", 0);
/* 168 */             return;
/*     */           }
/* 170 */           year = 
/* 171 */             ModifyInformationFrame.this.informationPanel.getYearTextField2().getText().trim();
/* 172 */           month = ModifyInformationFrame.this.informationPanel.getMonthComboBox2()
/* 173 */             .getSelectedItem().toString();
/* 174 */           day = ModifyInformationFrame.this.informationPanel.getDayComboBox2().getSelectedItem()
/* 175 */             .toString();
/* 176 */           if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 177 */             JOptionPane.showMessageDialog(null, "死亡日期输入有误", "错误提示", 
/* 178 */               0);
/* 179 */             return;
/*     */           }
/*     */           
/* 182 */           if (!new BirthdayDeathdayCheck(year, month, day, birthday).DateCheckResult()) {
/* 183 */             JOptionPane.showMessageDialog(null, "死亡日期先于出生日期，输入有误。", 
/* 184 */               "错误提示", 0); return;
/*     */           }
/*     */         }
///*     */         String deathday;
/*     */         String deathday;
/* 189 */         if (isDead) {
/* 190 */           deathday = year + "-" + month + "-" + day;
/*     */         } else {
/* 192 */           deathday = "";
/*     */         }
/* 194 */         int meter = ModifyInformationFrame.this.informationPanel.getMeterComboBox().getSelectedIndex();
/* 195 */         int decimeter = ModifyInformationFrame.this.informationPanel.getDecimeterComboBox()
/* 196 */           .getSelectedIndex();
/* 197 */         int centimeter = ModifyInformationFrame.this.informationPanel.getCentimeterComboBox()
/* 198 */           .getSelectedIndex();
/* 199 */         double height = meter + decimeter / 10.0D + 
/* 200 */           centimeter / 100.0D;
/* 201 */         boolean married = false;
/* 202 */         if (ModifyInformationFrame.this.informationPanel.getMarriedButton().isSelected())
/* 203 */           married = true;
/* 204 */         boolean hasChild = false;
/* 205 */         if (ModifyInformationFrame.this.informationPanel.getHasButton().isSelected())
/* 206 */           hasChild = true;
/* 207 */         Node temp = new Node(ModifyInformationFrame.this.informationPanel.getNameTextField()
/* 208 */           .getText().replaceAll(" ", ""), ModifyInformationFrame.this.informationPanel
/* 209 */           .getBornplaceTextField().getText().replaceAll(" ", ""), 
/* 210 */           birthday, deathday, sex, isDead, ModifyInformationFrame.this.informationPanel
/* 211 */           .getJobTextField().getText()
/* 212 */           .replaceAll(" ", ""), ModifyInformationFrame.this.informationPanel
/* 213 */           .getTelephoneTextField().getText().replaceAll(
/* 214 */           " ", ""), ModifyInformationFrame.this.informationPanel
/* 215 */           .getTop_titleTextField().getText().replaceAll(
/* 216 */           " ", ""), ModifyInformationFrame.this.informationPanel
/* 217 */           .getAddressTextField().getText().replaceAll(
/* 218 */           " ", ""), height, 
/*     */           
/* 220 */           (byte)ModifyInformationFrame.this.informationPanel.getEducationComboBox().getSelectedIndex(), married, hasChild);
/* 221 */         nodetree.modifyMember(node, temp);
/* 222 */         JOptionPane.showMessageDialog(null, "修改成功", "提示", 
/* 223 */           1);
/* 224 */         ModifyInformationFrame.this.dispose();
/* 225 */         centerPanel.removeAll();
/* 226 */         centerPanel.add(new ShowAllMemberPanel(centerPanel, textarea, 
/* 227 */           nodetree), "Center");
/* 228 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/*     */       }
/*     */       
/* 231 */     });
/* 232 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 234 */         ModifyInformationFrame.this.dispose();
/*     */       }
/*     */       
/* 237 */     });
/* 238 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 240 */         ModifyInformationFrame.this.informationPanel.getNameTextField().setText(node.getName());
/* 241 */         ModifyInformationFrame.this.informationPanel.getBornplaceTextField().setText(
/* 242 */           node.getBornplace());
/* 243 */         ModifyInformationFrame.this.informationPanel.getJobTextField().setText(node.getJob());
/* 244 */         ModifyInformationFrame.this.informationPanel.getTop_titleTextField().setText(
/* 245 */           node.getTop_title());
/* 246 */         ModifyInformationFrame.this.informationPanel.getTelephoneTextField().setText(
/* 247 */           node.getTelephone());
/* 248 */         ModifyInformationFrame.this.informationPanel.getAddressTextField().setText(
/* 249 */           node.getAddress());
/*     */         
/* 251 */         String[] birthdayString = node.getBirthday().split("-");
/* 252 */         ModifyInformationFrame.this.informationPanel.getYearTextField1().setText(birthdayString[0]);
/* 253 */         ModifyInformationFrame.this.informationPanel.getMonthComboBox1().setSelectedIndex(
/* 254 */           Integer.parseInt(birthdayString[1]) - 1);
/* 255 */         ModifyInformationFrame.this.informationPanel.getDayComboBox1().setSelectedIndex(
/* 256 */           Integer.parseInt(birthdayString[2]) - 1);
/* 257 */         if (node.getIsDead()) {
/* 258 */           String[] deathdayString = node.getDeathday().split("-");
/* 259 */           ModifyInformationFrame.this.informationPanel.getYearTextField2().setText(
/* 260 */             deathdayString[0]);
/* 261 */           int month = Integer.parseInt(deathdayString[1]);
/* 262 */           ModifyInformationFrame.this.informationPanel.getMonthComboBox2().setSelectedItem(Integer.valueOf(month));
/* 263 */           int day = Integer.parseInt(deathdayString[2]);
/* 264 */           ModifyInformationFrame.this.informationPanel.getDayComboBox2().setSelectedItem(Integer.valueOf(day));
/*     */         } else {
/* 266 */           ModifyInformationFrame.this.informationPanel.getYearTextField2().setText("");
/* 267 */           ModifyInformationFrame.this.informationPanel.getMonthComboBox2().setSelectedItem(Integer.valueOf(1));
/* 268 */           ModifyInformationFrame.this.informationPanel.getDayComboBox2().setSelectedItem(Integer.valueOf(1));
/*     */         }
/* 270 */         int height = (int)node.getHeight() * 100 / 100;
/* 271 */         ModifyInformationFrame.this.informationPanel.getMeterComboBox().setSelectedItem(Integer.valueOf(height));
/* 272 */         height = (int)((node.getHeight() - height) * 100.0D) / 10;
/* 273 */         ModifyInformationFrame.this.informationPanel.getDecimeterComboBox().setSelectedItem(Integer.valueOf(height));
/* 274 */         height = (int)(node.getHeight() * 100.0D) % 10;
/* 275 */         ModifyInformationFrame.this.informationPanel.getCentimeterComboBox()
/* 276 */           .setSelectedItem(Integer.valueOf(height));
/* 277 */         ModifyInformationFrame.this.informationPanel.getEducationComboBox().setSelectedIndex(
/* 278 */           node.getEducation());
/* 279 */         if (node.getSex() == 0) {
/* 280 */           ModifyInformationFrame.this.informationPanel.getMaleButton().setSelected(true);
/*     */         } else
/* 282 */           ModifyInformationFrame.this.informationPanel.getFemaleButton().setSelected(true);
/* 283 */         if (node.getMarried()) {
/* 284 */           ModifyInformationFrame.this.informationPanel.getMarriedButton().setSelected(true);
/*     */         } else
/* 286 */           ModifyInformationFrame.this.informationPanel.getSingleButton().setSelected(true);
/* 287 */         if (node.getHasChild()) {
/* 288 */           ModifyInformationFrame.this.informationPanel.getHasButton().setSelected(true);
/*     */         } else
/* 290 */           ModifyInformationFrame.this.informationPanel.getNothaveButton().setSelected(true);
/* 291 */         if (node.getIsDead()) {
/* 292 */           ModifyInformationFrame.this.informationPanel.getIsDeadButton().setSelected(true);
/* 293 */           ModifyInformationFrame.this.informationPanel.add(ModifyInformationFrame.this.informationPanel.getDeathdayPanel());
/*     */         } else {
/* 295 */           ModifyInformationFrame.this.informationPanel.getIsAliveButton().setSelected(true);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\modify\ModifyInformationFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */