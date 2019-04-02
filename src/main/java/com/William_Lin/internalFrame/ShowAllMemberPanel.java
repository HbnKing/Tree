/*     */ package com.William_Lin.internalFrame;
/*     */ 
/*     */ import com.William_Lin.node.Node;
/*     */ import com.William_Lin.tree.NodeTree;
/*     */ import java.awt.BorderLayout;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.event.TreeSelectionEvent;
/*     */ import javax.swing.event.TreeSelectionListener;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.DefaultTreeCellRenderer;
/*     */ import javax.swing.tree.TreePath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShowAllMemberPanel
/*     */   extends JPanel
/*     */ {
/*     */   private static final long serialVersionUID = -5077655774699795319L;
/*     */   private JTree showTree;
/*  27 */   private static Node temp = null;
/*     */   
/*  29 */   private JTextArea textareaTemp = new JTextArea();
/*     */   
/*     */ 
/*     */   public ShowAllMemberPanel(JPanel centerPanel, JTextArea textarea, NodeTree nodetree)
/*     */   {
/*  34 */     setLayout(new BorderLayout());
/*  35 */     this.textareaTemp = textarea;
/*  36 */     JScrollPane scrollPane = new JScrollPane();
/*  37 */     add(scrollPane, "Center");
/*     */     
/*  39 */     if (nodetree.getRootNode() == null)
/*  40 */       return;
/*  41 */     DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(temp);
/*  42 */     BuildTreeHelper(rootNode, nodetree.getRootNode());
/*  43 */     this.showTree = new JTree(rootNode);
/*  44 */     scrollPane.setViewportView(this.showTree);
/*  45 */     this.showTree.setRootVisible(false);
/*  46 */     DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
/*     */     
/*  48 */     renderer.setLeafIcon(null);
/*  49 */     renderer.setClosedIcon(null);
/*  50 */     renderer.setOpenIcon(null);
/*     */     
/*  52 */     this.showTree.setCellRenderer(renderer);
/*  53 */     ExpandPathHelper(rootNode);
/*  54 */     this.showTree.addTreeSelectionListener(new TreeSelectionListener() {
/*     */       public void valueChanged(TreeSelectionEvent e) {
/*  56 */         ShowAllMemberPanel.this.do_tree_valueChanged(e);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void ExpandPathHelper(DefaultMutableTreeNode rootNode) {
/*  62 */     if (rootNode == null)
/*  63 */       return;
/*  64 */     int count = rootNode.getChildCount();
/*  65 */     for (int i = 0; i < count; i++) {
/*  66 */       DefaultMutableTreeNode node = (DefaultMutableTreeNode)rootNode
/*  67 */         .getChildAt(i);
/*  68 */       TreePath path = new TreePath(node.getPath());
/*  69 */       this.showTree.expandPath(path);
/*     */     }
/*  71 */     for (int i = 0; i < count; i++) {
/*  72 */       DefaultMutableTreeNode tempRoot = (DefaultMutableTreeNode)rootNode
/*  73 */         .getChildAt(i);
/*  74 */       ExpandPathHelper(tempRoot);
/*     */     }
/*     */   }
/*     */   
/*     */   private void BuildTreeHelper(DefaultMutableTreeNode rootNode, Node node) {
/*  79 */     Node tempNode = node;
/*  80 */     while (tempNode != null) {
/*  81 */       DefaultMutableTreeNode temp = new DefaultMutableTreeNode(tempNode);
/*  82 */       rootNode.add(temp);
/*  83 */       tempNode = tempNode.getRightNode();
/*  84 */       if (tempNode == null)
/*     */         break;
/*     */     }
/*  87 */     for (int i = 0; i < rootNode.getChildCount(); i++) {
/*  88 */       DefaultMutableTreeNode tempRoot = (DefaultMutableTreeNode)rootNode
/*  89 */         .getChildAt(i);
/*  90 */       Node temp = (Node)tempRoot.getUserObject();
/*  91 */       BuildTreeHelper(tempRoot, temp.getLeftNode());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void do_tree_valueChanged(TreeSelectionEvent e)
/*     */   {
/*  98 */     TreePath path = this.showTree.getSelectionPath();
/*  99 */     if (path == null) {
/* 100 */       return;
/*     */     }
/* 102 */     DefaultMutableTreeNode node = (DefaultMutableTreeNode)path
/* 103 */       .getLastPathComponent();
/* 104 */     temp = (Node)node.getUserObject();
/* 105 */     this.textareaTemp.setText(temp.toString1());
/* 106 */     if (temp.getSpouseNode() != null) {
/* 107 */       this.textareaTemp.setText(temp.toString1() + "\n\n下面为配偶信息：\n\n" + 
/* 108 */         temp.getSpouseNode().toString2());
/*     */     }
/*     */   }
/*     */   
/*     */   public static Node getTemp() {
/* 113 */     return temp;
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\internalFrame\ShowAllMemberPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */