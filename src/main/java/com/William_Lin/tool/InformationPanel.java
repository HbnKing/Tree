/*     */ package com.William_Lin.tool;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InformationPanel
/*     */   extends MyPanel
/*     */ {
/*     */   private static final long serialVersionUID = -749830694825686841L;
/*     */   private JTextField nameTextField;
/*     */   private JTextField bornplaceTextField;
/*     */   private JTextField jobTextField;
/*     */   private JTextField top_titleTextField;
/*     */   private JTextField telephoneTextField;
/*     */   private JTextField addressTextField;
/*     */   private JTextField yearTextField1;
/*     */   private JTextField yearTextField2;
/*  44 */   private ButtonGroup sexButtonGroup = new ButtonGroup();
/*     */   
/*  46 */   private ButtonGroup marriedButtonGroup = new ButtonGroup();
/*     */   
/*  48 */   private ButtonGroup hasChildButtonGroup = new ButtonGroup();
/*     */   
/*  50 */   private ButtonGroup deadButtonGroup = new ButtonGroup();
/*     */   
/*     */   private JComboBox centimeterComboBox;
/*     */   
/*     */   private JComboBox meterComboBox;
/*     */   
/*     */   private JComboBox decimeterComboBox;
/*     */   
/*     */   private JComboBox monthComboBox1;
/*     */   
/*     */   private JComboBox dayComboBox1;
/*     */   
/*     */   private JComboBox monthComboBox2;
/*     */   
/*     */   private JComboBox dayComboBox2;
/*     */   
/*     */   private JComboBox educationComboBox;
/*     */   
/*     */   private JRadioButton maleButton;
/*     */   
/*     */   private JRadioButton femaleButton;
/*     */   
/*     */   private JRadioButton marriedButton;
/*     */   
/*     */   private JRadioButton singleButton;
/*     */   
/*     */   private JRadioButton isDeadButton;
/*     */   
/*     */   private JRadioButton isAliveButton;
/*     */   
/*     */   private JRadioButton hasButton;
/*     */   
/*     */   private JRadioButton nothaveButton;
/*     */   
/*  84 */   final JPanel deathdayPanel = new JPanel();
/*     */   
/*     */   public InformationPanel(ImageIcon icon)
/*     */   {
/*  88 */     super(icon);
/*  89 */     setLayout(new GridBagLayout());
/*  90 */     setPreferredSize(new Dimension(480, 0));
/*  91 */     setBackground(new Color(0, 0, 0));
/*  92 */     setBorder(new EmptyBorder(5, 5, 5, 5));
/*     */     
/*  94 */     JLabel nameLabel = new JLabel("* 姓名：");
/*  95 */     setupComponet(nameLabel, 0, 0, 3, 0, false);
/*  96 */     this.nameTextField = new JTextField();
/*  97 */     this.nameTextField.setColumns(5);
/*  98 */     this.nameTextField.setDocument(new LengthLimitedDmt(4));
/*  99 */     setupComponet(this.nameTextField, 3, 0, 2, 0, true);
/*     */     
/* 101 */     setupComponet(new JLabel("* 性别："), 0, 1, 3, 0, false);
/* 102 */     this.maleButton = new JRadioButton("男");
/* 103 */     setupComponet(this.maleButton, 3, 1, 1, 0, true);
/* 104 */     this.femaleButton = new JRadioButton("女");
/* 105 */     setupComponet(this.femaleButton, 4, 1, 1, 0, true);
/* 106 */     this.sexButtonGroup.add(this.maleButton);
/* 107 */     this.sexButtonGroup.add(this.femaleButton);
/*     */     
/* 109 */     setupComponet(new JLabel("* 出生地："), 5, 6, 2, 0, false);
/* 110 */     this.bornplaceTextField = new JTextField();
/* 111 */     this.bornplaceTextField.setColumns(30);
/* 112 */     this.bornplaceTextField.setDocument(new LengthLimitedDmt(9));
/* 113 */     setupComponet(this.bornplaceTextField, 7, 6, 4, 0, true);
/*     */     
/* 115 */     setupComponet(new JLabel("工作："), 0, 7, 3, 0, false);
/* 116 */     this.jobTextField = new JTextField();
/* 117 */     this.jobTextField.setColumns(15);
/* 118 */     this.jobTextField.setDocument(new LengthLimitedDmt(10));
/* 119 */     setupComponet(this.jobTextField, 3, 7, 6, 0, true);
/*     */     
/* 121 */     setupComponet(new JLabel("住址："), 0, 9, 3, 0, false);
/* 122 */     this.addressTextField = new JTextField();
/* 123 */     this.addressTextField.setColumns(30);
/* 124 */     this.addressTextField.setDocument(new LengthLimitedDmt(23));
/* 125 */     setupComponet(this.addressTextField, 3, 9, 13, 0, true);
/*     */     
/* 127 */     setupComponet(new JLabel("电话："), 0, 6, 3, 0, false);
/* 128 */     this.telephoneTextField = new JTextField();
/* 129 */     this.telephoneTextField.setColumns(11);
/* 130 */     this.telephoneTextField.setDocument(new NumberLengthLimitedDmt(11));
/* 131 */     setupComponet(this.telephoneTextField, 3, 6, 2, 0, true);
/*     */     
/* 133 */     setupComponet(new JLabel("最高职称："), 0, 8, 3, 0, false);
/* 134 */     this.top_titleTextField = new JTextField();
/* 135 */     this.top_titleTextField.setColumns(20);
/* 136 */     this.top_titleTextField.setDocument(new LengthLimitedDmt(10));
/* 137 */     setupComponet(this.top_titleTextField, 3, 8, 6, 0, true);
/*     */     
/* 139 */     setupComponet(new JLabel("身高："), 0, 5, 3, 0, false);
/* 140 */     this.meterComboBox = new JComboBox();
/* 141 */     setupComponet(this.meterComboBox, 3, 5, 1, 0, true);
/* 142 */     this.meterComboBox.addItem(Integer.valueOf(0));
/* 143 */     this.meterComboBox.addItem(Integer.valueOf(1));
/* 144 */     this.meterComboBox.addItem(Integer.valueOf(2));
/* 145 */     this.decimeterComboBox = new JComboBox();
/* 146 */     setupComponet(this.decimeterComboBox, 4, 5, 1, 0, true);
/* 147 */     for (int i = 0; i < 10; i++)
/* 148 */       this.decimeterComboBox.addItem(Integer.valueOf(i));
/* 149 */     this.centimeterComboBox = new JComboBox();
/* 150 */     setupComponet(this.centimeterComboBox, 5, 5, 1, 0, true);
/* 151 */     for (int i = 0; i < 10; i++)
/* 152 */       this.centimeterComboBox.addItem(Integer.valueOf(i));
/* 153 */     JLabel unitLabel = new JLabel("厘米");
/* 154 */     setupComponet(unitLabel, 6, 5, 1, 0, true);
/*     */     
/* 156 */     setupComponet(new JLabel("* 出生日期："), 0, 3, 3, 0, false);
/* 157 */     this.yearTextField1 = new JTextField();
/* 158 */     this.yearTextField1.setColumns(4);
/* 159 */     this.yearTextField1.setDocument(new NumberLengthLimitedDmt(4));
/* 160 */     setupComponet(this.yearTextField1, 3, 3, 1, 20, true);
/* 161 */     JLabel yearLabel1 = new JLabel("年");
/* 162 */     setupComponet(yearLabel1, 4, 3, 1, 0, true);
/* 163 */     this.monthComboBox1 = new JComboBox();
/* 164 */     setupComponet(this.monthComboBox1, 5, 3, 1, 0, true);
/* 165 */     for (int i = 1; i <= 12; i++)
/* 166 */       this.monthComboBox1.addItem(Integer.valueOf(i));
/* 167 */     JLabel monthLabel1 = new JLabel("月");
/* 168 */     setupComponet(monthLabel1, 6, 3, 1, 0, true);
/* 169 */     this.dayComboBox1 = new JComboBox();
/* 170 */     setupComponet(this.dayComboBox1, 7, 3, 1, 0, true);
/* 171 */     for (int i = 1; i <= 31; i++)
/* 172 */       this.dayComboBox1.addItem(Integer.valueOf(i));
/* 173 */     JLabel dayLabel1 = new JLabel("日");
/* 174 */     setupComponet(dayLabel1, 8, 3, 1, 0, true);
/*     */     
/* 176 */     setupComponet(new JLabel("* 是否死亡："), 5, 1, 3, 0, false);
/* 177 */     this.isDeadButton = new JRadioButton("是");
/* 178 */     setupComponet(this.isDeadButton, 8, 1, 1, 0, true);
/* 179 */     this.isAliveButton = new JRadioButton("否");
/* 180 */     setupComponet(this.isAliveButton, 9, 1, 1, 0, true);
/* 181 */     this.deadButtonGroup.add(this.isDeadButton);
/* 182 */     this.deadButtonGroup.add(this.isAliveButton);
/*     */     
/* 184 */     setupComponet(new JLabel("是否结婚："), 5, 2, 3, 0, false);
/* 185 */     this.marriedButton = new JRadioButton("是");
/* 186 */     setupComponet(this.marriedButton, 8, 2, 1, 0, true);
/* 187 */     this.singleButton = new JRadioButton("否");
/* 188 */     setupComponet(this.singleButton, 9, 2, 1, 0, true);
/* 189 */     this.marriedButtonGroup.add(this.marriedButton);
/* 190 */     this.marriedButtonGroup.add(this.singleButton);
/*     */     
/* 192 */     setupComponet(new JLabel("是否有孩子："), 0, 2, 3, 0, false);
/* 193 */     this.hasButton = new JRadioButton("有");
/* 194 */     setupComponet(this.hasButton, 3, 2, 1, 0, true);
/* 195 */     this.nothaveButton = new JRadioButton("没有");
/* 196 */     setupComponet(this.nothaveButton, 4, 2, 1, 0, true);
/* 197 */     this.hasChildButtonGroup.add(this.hasButton);
/* 198 */     this.hasChildButtonGroup.add(this.nothaveButton);
/*     */     
/* 200 */     setupComponet(new JLabel("学历程度："), 5, 0, 3, 0, false);
/* 201 */     this.educationComboBox = new JComboBox();
/* 202 */     setupComponet(this.educationComboBox, 8, 0, 3, 0, true);
/* 203 */     this.educationComboBox.addItem("没上学");
/* 204 */     this.educationComboBox.addItem("小学");
/* 205 */     this.educationComboBox.addItem("初中");
/* 206 */     this.educationComboBox.addItem("高中");
/* 207 */     this.educationComboBox.addItem("大学专科");
/* 208 */     this.educationComboBox.addItem("大学本科");
/* 209 */     this.educationComboBox.addItem("研究生");
/* 210 */     this.educationComboBox.addItem("博士");
/* 211 */     this.educationComboBox.addItem("博士以上");
/*     */     
/* 213 */     setupComponet(new JLabel("死亡日期："), 0, 4, 3, 0, false);
/* 214 */     this.yearTextField2 = new JTextField();
/* 215 */     setupComponet(this.yearTextField2, 3, 4, 1, 20, true);
/* 216 */     this.yearTextField2.setColumns(4);
/* 217 */     this.yearTextField2.setDocument(new NumberLengthLimitedDmt(4));
/* 218 */     JLabel yearLabel2 = new JLabel("年");
/* 219 */     setupComponet(yearLabel2, 4, 4, 1, 0, true);
/* 220 */     this.monthComboBox2 = new JComboBox();
/* 221 */     setupComponet(this.monthComboBox2, 5, 4, 1, 0, true);
/* 222 */     for (int i = 1; i <= 12; i++)
/* 223 */       this.monthComboBox2.addItem(Integer.valueOf(i));
/* 224 */     JLabel monthLabel2 = new JLabel("月");
/* 225 */     setupComponet(monthLabel2, 6, 4, 1, 0, true);
/* 226 */     this.dayComboBox2 = new JComboBox();
/* 227 */     setupComponet(this.dayComboBox2, 7, 4, 1, 0, true);
/* 228 */     for (int i = 1; i <= 31; i++)
/* 229 */       this.dayComboBox2.addItem(Integer.valueOf(i));
/* 230 */     JLabel dayLabel2 = new JLabel("日");
/* 231 */     setupComponet(dayLabel2, 8, 4, 1, 0, true);
/*     */     
/* 233 */     this.isDeadButton.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent e) {
/* 235 */         InformationPanel.this.yearTextField2.setEnabled(true);
/* 236 */         InformationPanel.this.monthComboBox2.setEnabled(true);
/* 237 */         InformationPanel.this.dayComboBox2.setEnabled(true);
/*     */       }
/*     */       
/* 240 */     });
/* 241 */     this.isAliveButton.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent e) {
/* 243 */         InformationPanel.this.yearTextField2.setEnabled(false);
/* 244 */         InformationPanel.this.monthComboBox2.setEnabled(false);
/* 245 */         InformationPanel.this.dayComboBox2.setEnabled(false);
/* 246 */         InformationPanel.this.yearTextField2.setText("");
/* 247 */         InformationPanel.this.monthComboBox2.setSelectedIndex(0);
/* 248 */         InformationPanel.this.dayComboBox2.setSelectedIndex(0);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill)
/*     */   {
/* 255 */     GridBagConstraints gridBagConstrains = new GridBagConstraints();
/* 256 */     gridBagConstrains.gridx = gridx;
/* 257 */     gridBagConstrains.gridy = gridy;
/* 258 */     gridBagConstrains.insets = new Insets(5, 1, 3, 1);
/* 259 */     if (gridwidth > 1)
/* 260 */       gridBagConstrains.gridwidth = gridwidth;
/* 261 */     if (ipadx > 0)
/* 262 */       gridBagConstrains.ipadx = ipadx;
/* 263 */     if (fill)
/* 264 */       gridBagConstrains.fill = 2;
/* 265 */     add(component, gridBagConstrains);
/*     */   }
/*     */   
/*     */   public JTextField getNameTextField() {
/* 269 */     return this.nameTextField;
/*     */   }
/*     */   
/*     */   public JTextField getBornplaceTextField() {
/* 273 */     return this.bornplaceTextField;
/*     */   }
/*     */   
/*     */   public JTextField getJobTextField() {
/* 277 */     return this.jobTextField;
/*     */   }
/*     */   
/*     */   public JTextField getTop_titleTextField() {
/* 281 */     return this.top_titleTextField;
/*     */   }
/*     */   
/*     */   public JTextField getTelephoneTextField() {
/* 285 */     return this.telephoneTextField;
/*     */   }
/*     */   
/*     */   public JTextField getAddressTextField() {
/* 289 */     return this.addressTextField;
/*     */   }
/*     */   
/*     */   public JTextField getYearTextField1() {
/* 293 */     return this.yearTextField1;
/*     */   }
/*     */   
/*     */   public JTextField getYearTextField2() {
/* 297 */     return this.yearTextField2;
/*     */   }
/*     */   
/*     */   public ButtonGroup getSexButtonGroup() {
/* 301 */     return this.sexButtonGroup;
/*     */   }
/*     */   
/*     */   public ButtonGroup getMarriedButtonGroup() {
/* 305 */     return this.marriedButtonGroup;
/*     */   }
/*     */   
/*     */   public ButtonGroup getHasChildButtonGroup() {
/* 309 */     return this.hasChildButtonGroup;
/*     */   }
/*     */   
/*     */   public ButtonGroup getDeadButtonGroup() {
/* 313 */     return this.deadButtonGroup;
/*     */   }
/*     */   
/*     */   public JComboBox getCentimeterComboBox() {
/* 317 */     return this.centimeterComboBox;
/*     */   }
/*     */   
/*     */   public JComboBox getMeterComboBox() {
/* 321 */     return this.meterComboBox;
/*     */   }
/*     */   
/*     */   public JComboBox getDecimeterComboBox() {
/* 325 */     return this.decimeterComboBox;
/*     */   }
/*     */   
/*     */   public JComboBox getMonthComboBox1() {
/* 329 */     return this.monthComboBox1;
/*     */   }
/*     */   
/*     */   public JComboBox getDayComboBox1() {
/* 333 */     return this.dayComboBox1;
/*     */   }
/*     */   
/*     */   public JComboBox getMonthComboBox2() {
/* 337 */     return this.monthComboBox2;
/*     */   }
/*     */   
/*     */   public JComboBox getDayComboBox2() {
/* 341 */     return this.dayComboBox2;
/*     */   }
/*     */   
/*     */   public JComboBox getEducationComboBox() {
/* 345 */     return this.educationComboBox;
/*     */   }
/*     */   
/*     */   public JRadioButton getMaleButton() {
/* 349 */     return this.maleButton;
/*     */   }
/*     */   
/*     */   public JRadioButton getFemaleButton() {
/* 353 */     return this.femaleButton;
/*     */   }
/*     */   
/*     */   public JRadioButton getMarriedButton() {
/* 357 */     return this.marriedButton;
/*     */   }
/*     */   
/*     */   public JRadioButton getSingleButton() {
/* 361 */     return this.singleButton;
/*     */   }
/*     */   
/*     */   public JRadioButton getIsDeadButton() {
/* 365 */     return this.isDeadButton;
/*     */   }
/*     */   
/*     */   public JRadioButton getIsAliveButton() {
/* 369 */     return this.isAliveButton;
/*     */   }
/*     */   
/*     */   public JRadioButton getHasButton() {
/* 373 */     return this.hasButton;
/*     */   }
/*     */   
/*     */   public JRadioButton getNothaveButton() {
/* 377 */     return this.nothaveButton;
/*     */   }
/*     */   
/*     */   public JPanel getDeathdayPanel() {
/* 381 */     return this.deathdayPanel;
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tool\InformationPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */