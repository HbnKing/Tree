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
/*     */ public class ModifySpouseInformationFrame
/*     */   extends JFrame
/*     */   implements ScreenSize
/*     */ {
/*     */   private static final long serialVersionUID = 2489265825547361827L;
/*     */   private InformationPanel informationPanel;
/*     */   private ButtonPanel buttonPanel;
/*     */   private NoticePanel noticePanel;
/*     */   private ImageIcon iconForNoticePanel;
/*     */   private ImageIcon iconForInformationPanel;
/*     */   private ImageIcon iconForButtonPanel;
/*     */   
/*     */   public ModifySpouseInformationFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree, final Node node)
/*     */   {
/*  46 */     setTitle("修改配偶信息");
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
/*  72 */     this.informationPanel.getNameTextField().setText(
/*  73 */       node.getSpouseNode().getName());
/*  74 */     this.informationPanel.getBornplaceTextField().setText(
/*  75 */       node.getSpouseNode().getBornplace());
/*  76 */     this.informationPanel.getJobTextField().setText(
/*  77 */       node.getSpouseNode().getJob());
/*  78 */     this.informationPanel.getTop_titleTextField().setText(
/*  79 */       node.getSpouseNode().getTop_title());
/*  80 */     this.informationPanel.getTelephoneTextField().setText(
/*  81 */       node.getSpouseNode().getTelephone());
/*  82 */     this.informationPanel.getAddressTextField().setText(
/*  83 */       node.getSpouseNode().getAddress());
/*     */     
/*  85 */     String[] birthdayString = node.getSpouseNode().getBirthday().split("-");
/*  86 */     this.informationPanel.getYearTextField1().setText(birthdayString[0]);
/*  87 */     this.informationPanel.getMonthComboBox1().setSelectedIndex(
/*  88 */       Integer.parseInt(birthdayString[1]) - 1);
/*  89 */     this.informationPanel.getDayComboBox1().setSelectedIndex(
/*  90 */       Integer.parseInt(birthdayString[2]) - 1);
/*  91 */     if (node.getSpouseNode().getIsDead()) {
/*  92 */       String[] deathdayString = node.getSpouseNode().getDeathday().split(
/*  93 */         "-");
/*  94 */       this.informationPanel.getYearTextField2().setText(deathdayString[0]);
/*  95 */       this.informationPanel.getMonthComboBox2().setSelectedItem(
/*  96 */         Integer.valueOf(Integer.parseInt(birthdayString[1])));
/*  97 */       this.informationPanel.getDayComboBox2().setSelectedItem(
/*  98 */         Integer.valueOf(Integer.parseInt(birthdayString[2])));
/*     */     } else {
/* 100 */       this.informationPanel.getYearTextField2().setText("");
/* 101 */       this.informationPanel.getMonthComboBox2().setSelectedIndex(0);
/* 102 */       this.informationPanel.getDayComboBox2().setSelectedIndex(0);
/* 103 */       this.informationPanel.getYearTextField2().setEnabled(false);
/* 104 */       this.informationPanel.getMonthComboBox2().setEnabled(false);
/* 105 */       this.informationPanel.getDayComboBox2().setEnabled(false);
/*     */     }
/* 107 */     int height = (int)node.getSpouseNode().getHeight() * 100 / 100;
/* 108 */     this.informationPanel.getMeterComboBox().setSelectedItem(Integer.valueOf(height));
/* 109 */     height = (int)((node.getSpouseNode().getHeight() - height) * 100.0D) / 10;
/* 110 */     this.informationPanel.getDecimeterComboBox().setSelectedItem(Integer.valueOf(height));
/* 111 */     height = (int)(node.getSpouseNode().getHeight() * 100.0D) % 10;
/* 112 */     this.informationPanel.getCentimeterComboBox().setSelectedItem(Integer.valueOf(height));
/* 113 */     this.informationPanel.getEducationComboBox().setSelectedIndex(
/* 114 */       node.getSpouseNode().getEducation());
/* 115 */     if (node.getSpouseNode().getSex() == 0) {
/* 116 */       this.informationPanel.getMaleButton().setSelected(true);
/*     */     } else
/* 118 */       this.informationPanel.getFemaleButton().setSelected(true);
/* 119 */     if (node.getSpouseNode().getMarried()) {
/* 120 */       this.informationPanel.getMarriedButton().setSelected(true);
/*     */     } else
/* 122 */       this.informationPanel.getSingleButton().setSelected(true);
/* 123 */     if (node.getSpouseNode().getHasChild()) {
/* 124 */       this.informationPanel.getHasButton().setSelected(true);
/*     */     } else
/* 126 */       this.informationPanel.getNothaveButton().setSelected(true);
/* 127 */     if (node.getSpouseNode().getIsDead()) {
/* 128 */       this.informationPanel.getIsDeadButton().setSelected(true);
/* 129 */       this.informationPanel.add(this.informationPanel.getDeathdayPanel());
/*     */     } else {
/* 131 */       this.informationPanel.getIsAliveButton().setSelected(true);
/*     */     }
/* 133 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 135 */         ModifySpouseInformationFrame.this.informationPanel.getNameTextField().setText(
/* 136 */           node.getSpouseNode().getName());
/* 137 */         ModifySpouseInformationFrame.this.informationPanel.getBornplaceTextField().setText(
/* 138 */           node.getSpouseNode().getBornplace());
/* 139 */         ModifySpouseInformationFrame.this.informationPanel.getJobTextField().setText(
/* 140 */           node.getSpouseNode().getJob());
/* 141 */         ModifySpouseInformationFrame.this.informationPanel.getTop_titleTextField().setText(
/* 142 */           node.getSpouseNode().getTop_title());
/* 143 */         ModifySpouseInformationFrame.this.informationPanel.getTelephoneTextField().setText(
/* 144 */           node.getSpouseNode().getTelephone());
/* 145 */         ModifySpouseInformationFrame.this.informationPanel.getAddressTextField().setText(
/* 146 */           node.getSpouseNode().getAddress());
/*     */         
/* 148 */         String[] birthdayString = node.getSpouseNode().getBirthday()
/* 149 */           .split("-");
/* 150 */         ModifySpouseInformationFrame.this.informationPanel.getYearTextField1().setText(birthdayString[0]);
/* 151 */         ModifySpouseInformationFrame.this.informationPanel.getMonthComboBox1().setSelectedIndex(
/* 152 */           Integer.parseInt(birthdayString[1]) - 1);
/* 153 */         ModifySpouseInformationFrame.this.informationPanel.getDayComboBox1().setSelectedIndex(
/* 154 */           Integer.parseInt(birthdayString[2]) - 1);
/* 155 */         if (node.getSpouseNode().getDeathday() != "") {
/* 156 */           String[] deathdayString = node.getSpouseNode()
/* 157 */             .getDeathday().split("-");
/* 158 */           ModifySpouseInformationFrame.this.informationPanel.getYearTextField2().setText(
/* 159 */             deathdayString[0]);
/* 160 */           ModifySpouseInformationFrame.this.informationPanel.getMonthComboBox2().setSelectedItem(
/* 161 */             Integer.valueOf(Integer.parseInt(birthdayString[1])));
/* 162 */           ModifySpouseInformationFrame.this.informationPanel.getDayComboBox2().setSelectedItem(
/* 163 */             Integer.valueOf(Integer.parseInt(birthdayString[2])));
/*     */         } else {
/* 165 */           ModifySpouseInformationFrame.this.informationPanel.getYearTextField2().setText("");
/* 166 */           ModifySpouseInformationFrame.this.informationPanel.getMonthComboBox2().setSelectedItem(Integer.valueOf(1));
/* 167 */           ModifySpouseInformationFrame.this.informationPanel.getDayComboBox2().setSelectedItem(Integer.valueOf(1));
/*     */         }
/* 169 */         int height = (int)node.getSpouseNode().getHeight() * 100 / 100;
/* 170 */         ModifySpouseInformationFrame.this.informationPanel.getMeterComboBox().setSelectedItem(Integer.valueOf(height));
/* 171 */         height = (int)((node.getSpouseNode().getHeight() - height) * 100.0D) / 10;
/* 172 */         ModifySpouseInformationFrame.this.informationPanel.getDecimeterComboBox().setSelectedItem(Integer.valueOf(height));
/* 173 */         height = (int)(node.getSpouseNode().getHeight() * 100.0D) % 10;
/* 174 */         ModifySpouseInformationFrame.this.informationPanel.getCentimeterComboBox()
/* 175 */           .setSelectedItem(Integer.valueOf(height));
/* 176 */         ModifySpouseInformationFrame.this.informationPanel.getEducationComboBox().setSelectedIndex(
/* 177 */           node.getSpouseNode().getEducation());
/* 178 */         if (node.getSpouseNode().getSex() == 0) {
/* 179 */           ModifySpouseInformationFrame.this.informationPanel.getMaleButton().setSelected(true);
/*     */         } else
/* 181 */           ModifySpouseInformationFrame.this.informationPanel.getFemaleButton().setSelected(true);
/* 182 */         if (node.getSpouseNode().getMarried()) {
/* 183 */           ModifySpouseInformationFrame.this.informationPanel.getMarriedButton().setSelected(true);
/*     */         } else
/* 185 */           ModifySpouseInformationFrame.this.informationPanel.getSingleButton().setSelected(true);
/* 186 */         if (node.getSpouseNode().getHasChild()) {
/* 187 */           ModifySpouseInformationFrame.this.informationPanel.getHasButton().setSelected(true);
/*     */         } else
/* 189 */           ModifySpouseInformationFrame.this.informationPanel.getNothaveButton().setSelected(true);
/* 190 */         if (node.getSpouseNode().getIsDead()) {
/* 191 */           ModifySpouseInformationFrame.this.informationPanel.getIsDeadButton().setSelected(true);
/* 192 */           ModifySpouseInformationFrame.this.informationPanel.add(ModifySpouseInformationFrame.this.informationPanel.getDeathdayPanel());
/*     */         } else {
/* 194 */           ModifySpouseInformationFrame.this.informationPanel.getIsAliveButton().setSelected(true);
/*     */         }
/* 196 */       } });
/* 197 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 199 */         if ((ModifySpouseInformationFrame.this.informationPanel.getNameTextField().getText().equals("")) || 
/*     */         
/* 201 */           (ModifySpouseInformationFrame.this.informationPanel.getBornplaceTextField().getText().equals("")) || 
/*     */           
/* 203 */           (ModifySpouseInformationFrame.this.informationPanel.getYearTextField1().getText().equals("")) || 
/* 204 */           ((!ModifySpouseInformationFrame.this.informationPanel.getMaleButton().isSelected()) && 
/* 205 */           (!ModifySpouseInformationFrame.this.informationPanel.getFemaleButton().isSelected())) || (
/* 206 */           (!ModifySpouseInformationFrame.this.informationPanel.getIsDeadButton().isSelected()) && 
/* 207 */           (!ModifySpouseInformationFrame.this.informationPanel.getIsAliveButton().isSelected()))) {
/* 208 */           JOptionPane.showMessageDialog(null, "请填写全部信息", "错误提示", 
/* 209 */             0);
/* 210 */           return;
/*     */         }
/* 212 */         String year = ModifySpouseInformationFrame.this.informationPanel.getYearTextField1().getText()
/* 213 */           .trim();
/* 214 */         String month = ModifySpouseInformationFrame.this.informationPanel.getMonthComboBox1()
/* 215 */           .getSelectedItem().toString();
/* 216 */         String day = ModifySpouseInformationFrame.this.informationPanel.getDayComboBox1()
/* 217 */           .getSelectedItem().toString();
/* 218 */         if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 219 */           JOptionPane.showMessageDialog(null, "出生日期输入有误", "错误提示", 
/* 220 */             0);
/* 221 */           return;
/*     */         }
/* 223 */         String birthday = year + "-" + month + "-" + day;
///*     */         byte sex;
/* 225 */         byte sex; if (ModifySpouseInformationFrame.this.informationPanel.getMaleButton().isSelected()) {
/* 226 */           sex = 0;
/*     */         } else
/* 228 */           sex = 1;
/* 229 */         boolean isDead = false;
/* 230 */         if (ModifySpouseInformationFrame.this.informationPanel.getIsDeadButton().isSelected()) {
/* 231 */           isDead = true;
/* 232 */           if (ModifySpouseInformationFrame.this.informationPanel.getYearTextField2().getText().equals(
/* 233 */             "")) {
/* 234 */             JOptionPane.showMessageDialog(null, "请填写死亡日期时间", 
/* 235 */               "错误提示", 0);
/* 236 */             return;
/*     */           }
/* 238 */           year = 
/* 239 */             ModifySpouseInformationFrame.this.informationPanel.getYearTextField2().getText().trim();
/* 240 */           month = ModifySpouseInformationFrame.this.informationPanel.getMonthComboBox2()
/* 241 */             .getSelectedItem().toString();
/* 242 */           day = ModifySpouseInformationFrame.this.informationPanel.getDayComboBox2().getSelectedItem()
/* 243 */             .toString();
/* 244 */           if (!new CalendarCheck(year, month, day).CheckResult()) {
/* 245 */             JOptionPane.showMessageDialog(null, "死亡日期输入有误", "错误提示", 
/* 246 */               0);
/* 247 */             return;
/*     */           }
/*     */           
/* 250 */           if (!new BirthdayDeathdayCheck(year, month, day, birthday).DateCheckResult()) {
/* 251 */             JOptionPane.showMessageDialog(null, "死亡日期先于出生日期，输入有误。", 
/* 252 */               "错误提示", 0); return;
/*     */           }
/*     */         }
///*     */         String deathday;
/*     */         String deathday;
/* 257 */         if (isDead) {
/* 258 */           deathday = year + "-" + month + "-" + day;
/*     */         } else {
/* 260 */           deathday = "";
/*     */         }
/* 262 */         int meter = ModifySpouseInformationFrame.this.informationPanel.getMeterComboBox().getSelectedIndex();
/* 263 */         int decimeter = ModifySpouseInformationFrame.this.informationPanel.getDecimeterComboBox()
/* 264 */           .getSelectedIndex();
/* 265 */         int centimeter = ModifySpouseInformationFrame.this.informationPanel.getCentimeterComboBox()
/* 266 */           .getSelectedIndex();
/* 267 */         double height = meter + decimeter / 10.0D + 
/* 268 */           centimeter / 100.0D;
/* 269 */         boolean married = false;
/* 270 */         if (ModifySpouseInformationFrame.this.informationPanel.getMarriedButton().isSelected())
/* 271 */           married = true;
/* 272 */         boolean hasChild = false;
/* 273 */         if (ModifySpouseInformationFrame.this.informationPanel.getHasButton().isSelected())
/* 274 */           hasChild = true;
/* 275 */         Node temp = new Node(ModifySpouseInformationFrame.this.informationPanel.getNameTextField()
/* 276 */           .getText().replaceAll(" ", ""), ModifySpouseInformationFrame.this.informationPanel
/* 277 */           .getBornplaceTextField().getText().replaceAll(" ", ""), 
/* 278 */           birthday, deathday, sex, isDead, ModifySpouseInformationFrame.this.informationPanel
/* 279 */           .getJobTextField().getText()
/* 280 */           .replaceAll(" ", ""), ModifySpouseInformationFrame.this.informationPanel
/* 281 */           .getTelephoneTextField().getText().replaceAll(
/* 282 */           " ", ""), ModifySpouseInformationFrame.this.informationPanel
/* 283 */           .getTop_titleTextField().getText().replaceAll(
/* 284 */           " ", ""), ModifySpouseInformationFrame.this.informationPanel
/* 285 */           .getAddressTextField().getText().replaceAll(
/* 286 */           " ", ""), height, 
/*     */           
/* 288 */           (byte)ModifySpouseInformationFrame.this.informationPanel.getEducationComboBox().getSelectedIndex(), married, hasChild);
/* 289 */         nodetree.modifyMember(node, temp);
/* 290 */         JOptionPane.showMessageDialog(null, "修改成功", "提示", 
/* 291 */           1);
/* 292 */         ModifySpouseInformationFrame.this.dispose();
/* 293 */         centerPanel.removeAll();
/* 294 */         centerPanel.add(new ShowAllMemberPanel(centerPanel, textarea, 
/* 295 */           nodetree), "Center");
/* 296 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/*     */       }
/*     */       
/* 299 */     });
/* 300 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 302 */         ModifySpouseInformationFrame.this.dispose();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\modify\ModifySpouseInformationFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */