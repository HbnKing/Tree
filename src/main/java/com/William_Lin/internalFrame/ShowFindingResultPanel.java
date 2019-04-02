/*     */ package com.William_Lin.internalFrame;
/*     */ 
/*     */ import com.William_Lin.node.Node;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JViewport;
/*     */ import javax.swing.ListSelectionModel;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ import javax.swing.table.JTableHeader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShowFindingResultPanel
/*     */   extends JPanel
/*     */ {
/*     */   private static final long serialVersionUID = 1452791334117995833L;
/*  29 */   private Vector<String> columnNameV = new Vector();
/*  30 */   private Vector<Vector<Object>> tableValueV = new Vector();
/*  31 */   private int fixedColumn = 1;
/*  32 */   private static Node nodeTemp = null;
/*     */   
/*     */ 
/*     */   private JTextArea textareaTemp;
/*     */   
/*     */ 
/*     */   private ArrayList<Node> listTemp;
/*     */   
/*     */ 
/*     */   private JTable fixedColumnTable;
/*     */   
/*     */ 
/*     */   private FixedColumnTableModel fixedColumnTableModel;
/*     */   
/*     */ 
/*     */   private JTable floatingColumnTable;
/*     */   
/*     */ 
/*     */   private FloatingColumnTableModel floatingColumnTableModel;
/*     */   
/*     */ 
/*     */   public ShowFindingResultPanel(ArrayList<Node> list, JTextArea textarea)
/*     */   {
/*  55 */     setLayout(new BorderLayout());
/*  56 */     this.columnNameV.add("姓名");
/*  57 */     this.columnNameV.add("出生地");
/*  58 */     this.columnNameV.add("性别");
/*  59 */     this.columnNameV.add("出生日期");
/*  60 */     this.columnNameV.add("死亡日期");
/*  61 */     this.columnNameV.add("身高（米）");
/*  62 */     this.columnNameV.add("工作");
/*  63 */     this.columnNameV.add("最高职称");
/*  64 */     this.columnNameV.add("是否死亡");
/*  65 */     this.columnNameV.add("是否有孩子");
/*  66 */     this.columnNameV.add("是否结婚");
/*  67 */     this.columnNameV.add("学历程度");
/*  68 */     this.columnNameV.add("电话号码");
/*  69 */     this.columnNameV.add("住址");
/*  70 */     this.columnNameV.add("第几代");
/*  71 */     this.fixedColumn = 1;
/*     */     
/*  73 */     this.textareaTemp = textarea;
/*  74 */     this.listTemp = list;
/*     */     
/*  76 */     Iterator<Node> it = list.iterator();
/*  77 */     while (it.hasNext()) {
/*  78 */       Vector<Object> rowV = new Vector();
/*  79 */       Node temp = (Node)it.next();
/*  80 */       rowV.add(temp.getName());
/*  81 */       rowV.add(temp.getBornplace());
/*  82 */       if (temp.getSex() == 0) {
/*  83 */         rowV.add("男");
/*     */       } else
/*  85 */         rowV.add("女");
/*  86 */       rowV.add(temp.getBirthday());
/*  87 */       rowV.add(temp.getDeathday());
/*  88 */       rowV.add(Double.valueOf(temp.getHeight()));
/*  89 */       rowV.add(temp.getJob());
/*  90 */       rowV.add(temp.getTop_title());
/*  91 */       if (temp.getIsDead()) {
/*  92 */         rowV.add("是");
/*     */       } else
/*  94 */         rowV.add("否");
/*  95 */       if (temp.getHasChild()) {
/*  96 */         rowV.add("是");
/*     */       } else
/*  98 */         rowV.add("否");
/*  99 */       if (temp.getMarried()) {
/* 100 */         rowV.add("是");
/*     */       } else
/* 102 */         rowV.add("否");
/* 103 */       rowV.add(temp.educationToString(temp.getEducation()));
/* 104 */       rowV.add(temp.getTelephone());
/* 105 */       rowV.add(temp.getAddress());
/* 106 */       rowV.add(Integer.valueOf(temp.getLevel()));
/* 107 */       this.tableValueV.add(rowV);
/*     */     }
/*     */     
/* 110 */     this.fixedColumnTableModel = new FixedColumnTableModel(null);
/* 111 */     this.fixedColumnTable = new JTable(this.fixedColumnTableModel);
/* 112 */     this.fixedColumnTable.setRowHeight(20);
/* 113 */     JTableHeader header1 = this.fixedColumnTable.getTableHeader();
/* 114 */     header1.setFont(new Font("楷体", 1, 16));
/* 115 */     ListSelectionModel fixed = this.fixedColumnTable.getSelectionModel();
/* 116 */     fixed.setSelectionMode(1);
/* 117 */     fixed.addListSelectionListener(new MListSelectionListener(true));
/*     */     
/* 119 */     this.floatingColumnTableModel = new FloatingColumnTableModel(null);
/* 120 */     this.floatingColumnTable = new JTable(this.floatingColumnTableModel);
/* 121 */     this.floatingColumnTable.setAutoResizeMode(0);
/* 122 */     this.floatingColumnTable.setRowHeight(20);
/* 123 */     JTableHeader header2 = this.floatingColumnTable.getTableHeader();
/* 124 */     header2.setFont(new Font("楷体", 1, 16));
/* 125 */     ListSelectionModel floating = this.floatingColumnTable.getSelectionModel();
/* 126 */     floating.setSelectionMode(1);
/* 127 */     floating.addListSelectionListener(new MListSelectionListener(false));
/*     */     
/* 129 */     JScrollPane scrollPane = new JScrollPane();
/* 130 */     scrollPane.setBackground(Color.WHITE);
/* 131 */     scrollPane.setCorner("UPPER_LEFT_CORNER", this.fixedColumnTable
/* 132 */       .getTableHeader());
/* 133 */     JViewport viewport = new JViewport();
/* 134 */     viewport.setView(this.fixedColumnTable);
/* 135 */     viewport.setPreferredSize(this.fixedColumnTable.getPreferredSize());
/* 136 */     scrollPane.setRowHeaderView(viewport);
/* 137 */     scrollPane.setViewportView(this.floatingColumnTable);
/* 138 */     add(scrollPane, "Center");
/*     */   }
/*     */   
/*     */ 
/*     */   private class FixedColumnTableModel
/*     */     extends AbstractTableModel
/*     */   {
/*     */     private static final long serialVersionUID = -9150581419899711484L;
/*     */     
/*     */     private FixedColumnTableModel(Object object) {}
/*     */     
/*     */     public int getColumnCount()
/*     */     {
/* 151 */       return ShowFindingResultPanel.this.fixedColumn;
/*     */     }
/*     */     
/*     */     public int getRowCount() {
/* 155 */       return ShowFindingResultPanel.this.tableValueV.size();
/*     */     }
/*     */     
/*     */     public Object getValueAt(int rowIndex, int columnIndex) {
/* 159 */       return ((Vector)ShowFindingResultPanel.this.tableValueV.get(rowIndex)).get(columnIndex);
/*     */     }
/*     */     
/*     */     public String getColumnName(int columnIndex) {
/* 163 */       return (String)ShowFindingResultPanel.this.columnNameV.get(columnIndex);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private class FloatingColumnTableModel
/*     */     extends AbstractTableModel
/*     */   {
/*     */     private static final long serialVersionUID = 3934620115287188392L;
/*     */     
/*     */     private FloatingColumnTableModel(Object object) {}
/*     */     
/*     */     public int getColumnCount()
/*     */     {
/* 177 */       return ShowFindingResultPanel.this.columnNameV.size() - ShowFindingResultPanel.this.fixedColumn;
/*     */     }
/*     */     
/*     */     public int getRowCount() {
/* 181 */       return ShowFindingResultPanel.this.tableValueV.size();
/*     */     }
/*     */     
/*     */     public Object getValueAt(int rowIndex, int columnIndex)
/*     */     {
/* 186 */       return ((Vector)ShowFindingResultPanel.this.tableValueV.get(rowIndex)).get(columnIndex + ShowFindingResultPanel.this.fixedColumn);
/*     */     }
/*     */     
/*     */     public String getColumnName(int columnIndex) {
/* 190 */       return (String)ShowFindingResultPanel.this.columnNameV.get(columnIndex + ShowFindingResultPanel.this.fixedColumn);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private class MListSelectionListener
/*     */     implements ListSelectionListener
/*     */   {
/* 198 */     boolean isFixedColumnTable = true;
/*     */     
/*     */     public MListSelectionListener(boolean isFixedColumnTable) {
/* 201 */       this.isFixedColumnTable = isFixedColumnTable;
/*     */     }
/*     */     
/*     */     public void valueChanged(ListSelectionEvent e) {
/*     */       int row;
/* 206 */       if (this.isFixedColumnTable) {
///* 207 */         int
row = ShowFindingResultPanel.this.fixedColumnTable.getSelectedRow();
/*     */         
/* 209 */         ShowFindingResultPanel.this.floatingColumnTable.setRowSelectionInterval(row, row);
/*     */       } else {
/* 211 */         row = ShowFindingResultPanel.this.floatingColumnTable.getSelectedRow();
/*     */         
/* 213 */         ShowFindingResultPanel.this.fixedColumnTable.setRowSelectionInterval(row, row);
/*     */       }
/* 215 */       ShowFindingResultPanel.nodeTemp = (Node)ShowFindingResultPanel.this.listTemp.get(row);
/* 216 */       ShowFindingResultPanel.this.textareaTemp.setText(ShowFindingResultPanel.nodeTemp.toString1());
/* 217 */       if (ShowFindingResultPanel.nodeTemp.getSpouseNode() != null) {
/* 218 */         ShowFindingResultPanel.this.textareaTemp.setText(ShowFindingResultPanel.nodeTemp.toString1() + "\n\n下面为配偶信息：\n\n" + 
/* 219 */           ShowFindingResultPanel.nodeTemp.getSpouseNode().toString2());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static Node getFindingResultNode() {
/* 225 */     return nodeTemp;
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\ShowFindingResultPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */