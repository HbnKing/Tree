/*     */ package com.William_Lin.internalFrame.search;
/*     */ 
/*     */ import com.William_Lin.internalFrame.ShowFindingResultPanel;
/*     */ import com.William_Lin.node.Node;
/*     */ import com.William_Lin.tool.ButtonPanel;
/*     */ import com.William_Lin.tool.MyPanel;
/*     */ import com.William_Lin.tool.ScreenSize;
/*     */ import com.William_Lin.tree.NodeTree;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
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
/*     */ import javax.swing.SwingUtilities;
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
/*     */ public class SearchByHeightFrame
/*     */   extends JFrame
/*     */   implements ScreenSize
/*     */ {
/*     */   private static final long serialVersionUID = 962188762919054888L;
/*     */   private ButtonPanel buttonPanel;
/*     */   private JLabel inputLabel;
/*     */   private JComboBox meterComboBox;
/*     */   private JComboBox decimeterComboBox;
/*     */   private JComboBox centimeterComboBox;
/*     */   private JLabel pointLabel;
/*     */   private JPanel inputPanel;
/*     */   private JLabel unitLabel;
/*     */   private ImageIcon iconForHeight;
/*     */   private ImageIcon iconForButtonPanel;
/*     */   
/*     */   public SearchByHeightFrame(final JPanel centerPanel, final JTextArea textarea, final NodeTree nodetree)
/*     */   {
/*  58 */     setResizable(false);
/*  59 */     setTitle("搜索指定的身高");
/*  60 */     setLayout(new BorderLayout());
/*  61 */     setSize(450, 135);
/*  62 */     setLocation((int)((screenWidth - getWidth()) * 0.618D / 1.618D), 
/*  63 */       (int)((screenHeight - getHeight()) * 0.618D / 1.618D));
/*  64 */     setDefaultCloseOperation(2);
/*  65 */     setVisible(true);
/*     */     
/*  67 */     URL resource = getClass().getResource("/img/4.png");
/*  68 */     this.iconForButtonPanel = new ImageIcon(resource);
/*  69 */     resource = getClass().getResource("/img/5.png");
/*  70 */     this.iconForHeight = new ImageIcon(resource);
/*     */     
/*  72 */     this.buttonPanel = new ButtonPanel(this.iconForButtonPanel);
/*     */     
/*  74 */     this.inputPanel = new MyPanel(this.iconForHeight);
/*     */     
/*  76 */     this.inputPanel.setLayout(new FlowLayout(1, 5, 5));
/*  77 */     this.inputPanel.setPreferredSize(new Dimension(230, 0));
/*  78 */     this.inputPanel.setBackground(new Color(255, 255, 255));
/*  79 */     this.inputPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
/*     */     
/*  81 */     this.inputLabel = new JLabel("请输入要搜索的身高：");
/*  82 */     this.inputLabel.setFont(new Font("隶书", 1, 16));
/*  83 */     this.inputPanel.add(this.inputLabel);
/*  84 */     this.meterComboBox = new JComboBox();
/*  85 */     this.meterComboBox.addItem("0");
/*  86 */     this.meterComboBox.addItem("1");
/*  87 */     this.meterComboBox.addItem("2");
/*  88 */     this.inputPanel.add(this.meterComboBox);
/*     */     
/*  90 */     this.pointLabel = new JLabel(".");
/*  91 */     this.inputPanel.add(this.pointLabel);
/*  92 */     this.decimeterComboBox = new JComboBox();
/*  93 */     this.inputPanel.add(this.decimeterComboBox);
/*  94 */     for (int i = 0; i < 10; i++)
/*  95 */       this.decimeterComboBox.addItem(Integer.valueOf(i));
/*  96 */     this.centimeterComboBox = new JComboBox();
/*  97 */     this.inputPanel.add(this.centimeterComboBox);
/*  98 */     for (int i = 0; i < 10; i++)
/*  99 */       this.centimeterComboBox.addItem(Integer.valueOf(i));
/* 100 */     this.unitLabel = new JLabel("米");
/* 101 */     this.inputPanel.add(this.unitLabel);
/* 102 */     this.unitLabel.setFont(new Font("隶书", 1, 16));
/*     */     
/* 104 */     this.buttonPanel.getCancelButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 106 */         SearchByHeightFrame.this.dispose();
/*     */       }
/* 108 */     });
/* 109 */     this.buttonPanel.getResetButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 111 */         SearchByHeightFrame.this.meterComboBox.setSelectedIndex(0);
/* 112 */         SearchByHeightFrame.this.meterComboBox.setSelectedIndex(0);
/* 113 */         SearchByHeightFrame.this.meterComboBox.setSelectedIndex(0);
/*     */       }
/* 115 */     });
/* 116 */     final ArrayList<Node> list = new ArrayList();
/* 117 */     this.buttonPanel.getOkButton().addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 119 */         if (SearchByHeightFrame.this.meterComboBox.getSelectedIndex() + 
/* 120 */           SearchByHeightFrame.this.decimeterComboBox.getSelectedIndex() + SearchByHeightFrame.this.centimeterComboBox
/* 121 */           .getSelectedIndex() == 0) {
/* 122 */           return;
/*     */         }
/* 124 */         int meter = SearchByHeightFrame.this.meterComboBox.getSelectedIndex();
/* 125 */         int decimeter = SearchByHeightFrame.this.decimeterComboBox.getSelectedIndex();
/* 126 */         int centimeter = SearchByHeightFrame.this.centimeterComboBox.getSelectedIndex();
/* 127 */         double height = meter + decimeter / 10.0D + 
/* 128 */           centimeter / 100.0D;
/* 129 */         nodetree.findByHeight(list, nodetree.getRootNode(), height);
/* 130 */         centerPanel.removeAll();
/* 131 */         centerPanel.add(new ShowFindingResultPanel(list, textarea), 
/* 132 */           "Center");
/* 133 */         SwingUtilities.updateComponentTreeUI(centerPanel);
/* 134 */         SearchByHeightFrame.this.dispose();
/*     */       }
/* 136 */     });
/* 137 */     getContentPane().add(this.buttonPanel, "South");
/* 138 */     getContentPane().add(this.inputPanel, "Center");
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\search\SearchByHeightFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */