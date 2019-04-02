/*     */ package com.William_Lin.frame;
/*     */ 
/*     */ import com.William_Lin.internalFrame.ShowAllMemberPanel;
/*     */ import com.William_Lin.internalFrame.ShowFindingResultPanel;
/*     */ import com.William_Lin.internalFrame.about.AboutFrame;
/*     */ import com.William_Lin.internalFrame.add.FamilyChildrenFrame;
/*     */ import com.William_Lin.internalFrame.add.FamilyParentFrame;
/*     */ import com.William_Lin.internalFrame.add.FamilyRootFrame;
/*     */ import com.William_Lin.internalFrame.add.FamilySiblingFrame;
/*     */ import com.William_Lin.internalFrame.add.FamilySpouseFrame;
/*     */ import com.William_Lin.internalFrame.modify.ModifyInformationFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByAddressFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByBirthdayFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByBornplaceFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByDeathdayFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByEducationFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByHasChildFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByHeightFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByIsDeadFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByJobFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByLevelFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByMarriedFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByNameFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchBySexFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByTelephoneFrame;
/*     */ import com.William_Lin.internalFrame.search.SearchByTop_titleFrame;
/*     */ import com.William_Lin.node.Node;
/*     */ import com.William_Lin.tool.MyButton;
/*     */ import com.William_Lin.tool.MyLabel;
/*     */ import com.William_Lin.tool.MyPanel;
/*     */ import com.William_Lin.tool.ScreenSize;
/*     */ import com.William_Lin.tree.NodeTree;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.awt.event.WindowStateListener;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URL;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.border.TitledBorder;
/*     */ import javax.swing.event.TreeSelectionEvent;
/*     */ import javax.swing.event.TreeSelectionListener;
/*     */ import javax.swing.filechooser.FileFilter;
/*     */ import javax.swing.filechooser.FileNameExtensionFilter;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.DefaultTreeCellRenderer;
/*     */ import javax.swing.tree.DefaultTreeModel;
/*     */ import javax.swing.tree.TreePath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IndexFrame
/*     */   extends JFrame
/*     */   implements ScreenSize
/*     */ {
/*     */   private static final long serialVersionUID = -7533778308705770327L;
/*     */   private JTree tree;
/*     */   final JPanel centerPanel;
/*  87 */   final JTextArea textarea = new JTextArea();
/*     */   
/*     */ 
/*     */   protected NodeTree nodetree;
/*     */   
/*     */ 
/*     */   final JLabel backgroundLabel;
/*     */   
/*     */ 
/*  96 */   private Node node = null;
/*     */   
/*     */ 
/*     */   private ImageIcon iconForTopPanel;
/*     */   
/*     */ 
/*     */   private ImageIcon iconForLeftPanel;
/*     */   
/*     */ 
/*     */   private ImageIcon iconForRightPanel;
/*     */   
/*     */ 
/*     */   private ImageIcon iconForBackground;
/*     */   
/*     */ 
/*     */   private MyPanel leftPanel;
/*     */   
/*     */ 
/*     */   private MyPanel rightPanel;
/*     */   
/*     */ 
/*     */   private JLabel label;
/*     */   
/*     */ 
/*     */   private JButton newFamilyTreeButton;
/*     */   
/*     */ 
/*     */   private JButton openFileButton;
/*     */   
/*     */ 
/*     */   private JButton saveFamilyTreeButton;
/*     */   
/*     */ 
/*     */   private JButton showTreeButton;
/*     */   
/*     */ 
/*     */   private JButton aboutButton;
/*     */   
/*     */   private JButton exitFamilyTreeButton;
/*     */   
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 141 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
/*     */     } catch (Throwable e) {
/* 143 */       e.printStackTrace();
/*     */     }
/* 145 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/*     */         try {
/* 148 */           IndexFrame frame = new IndexFrame();
/* 149 */           frame.setVisible(true);
/* 150 */           Object[] stringArray = { "新建家谱", "打开家谱" };
/* 151 */           int response = JOptionPane.showOptionDialog(frame, 
/* 152 */             "新建家谱还是打开家谱?", "请选择", 0, 
/* 153 */             3, null, stringArray, 
/* 154 */             stringArray[0]);
/* 155 */           if (response == 0) {
/* 156 */             frame.getNewFamilyTreeButton().doClick();
/*     */           }
/* 158 */           if (response == 1) {
/* 159 */             frame.getOpenFileButton().doClick();
/*     */           }
/* 161 */           if (response == -1) {}
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 165 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public IndexFrame()
/*     */   {
/* 175 */     addWindowListener(new WindowAdapter()
/*     */     {
/*     */       public void windowClosing(WindowEvent e) {
/* 178 */         int result = JOptionPane.showOptionDialog(null, "确认关闭吗？", null, 
/* 179 */           0, 
/* 180 */           3, null, null, null);
/* 181 */         if (result == 0)
/* 182 */           System.exit(0);
/*     */       }
/* 184 */     });
/* 185 */     addWindowStateListener(new WindowStateListener()
/*     */     {
/*     */       public void windowStateChanged(WindowEvent state) {
/* 188 */         if (state.getNewState() != 0)
/*     */         {
/* 190 */           if (state.getNewState() == 6)
/* 191 */             IndexFrame.this.newFamilyTreeButton.setSize(85, 105);
/*     */         }
/*     */       }
/*     */     });
/*     */     try {
/* 196 */       this.nodetree = new NodeTree();
/*     */     } catch (Exception e) {
/* 198 */       e.printStackTrace();
/*     */     }
/* 200 */     setMinimumSize(new Dimension(840, 590));
/* 201 */     setResizable(true);
/* 202 */     setSize(screenWidth, screenHeight);
/* 203 */     setSize(840, 590);
/* 204 */     setLocation((int)((screenWidth - getWidth()) * 0.618D / 1.618D), 
/* 205 */       (int)((screenHeight - getHeight()) * 0.618D / 1.618D));
/* 206 */     setExtendedState(0);
/* 207 */     setTitle("家谱管理系统");
/* 208 */     setDefaultCloseOperation(0);
/*     */     
/* 210 */     URL resource = getClass().getResource("/img/top.png");
/* 211 */     this.iconForTopPanel = new ImageIcon(resource);
/* 212 */     resource = getClass().getResource("/img/left.png");
/* 213 */     this.iconForLeftPanel = new ImageIcon(resource);
/* 214 */     resource = getClass().getResource("/img/right.png");
/* 215 */     this.iconForRightPanel = new ImageIcon(resource);
/* 216 */     resource = getClass().getResource("/img/back.png");
/* 217 */     this.iconForBackground = new ImageIcon(resource);
/*     */     
/* 219 */     this.centerPanel = new MyPanel(this.iconForBackground);
/*     */     
/*     */ 
/* 222 */     JPanel topPanel = new MyPanel(this.iconForTopPanel);
/* 223 */     topPanel.setLayout(new BorderLayout());
/* 224 */     topPanel.setPreferredSize(new Dimension(0, 105));
/* 225 */     getContentPane().add(topPanel, "North");
/*     */     
/* 227 */     resource = getClass().getResource("/img/logo.png");
/* 228 */     ImageIcon icon = new ImageIcon(resource);
/* 229 */     this.label = new MyLabel(icon);
/* 230 */     this.label.setHorizontalAlignment(0);
/* 231 */     this.label.setHorizontalTextPosition(0);
/* 232 */     this.label.setBorder(new TitledBorder(null, "", 
/* 233 */       0, 
/* 234 */       0, null, null));
/* 235 */     this.label.setPreferredSize(new Dimension((int)(getWidth() * 0.25D), 0));
/* 236 */     topPanel.add(this.label, "West");
/*     */     
/* 238 */     JPanel iconPanel = new JPanel();
/* 239 */     iconPanel.setOpaque(false);
/* 240 */     GridLayout gridLayout = new GridLayout(1, 0);
/* 241 */     gridLayout.setVgap(30);
/* 242 */     gridLayout.setHgap(20);
/* 243 */     iconPanel.setLayout(gridLayout);
/* 244 */     iconPanel.setBackground(new Color(90, 130, 189));
/* 245 */     iconPanel.setBorder(new TitledBorder(null, "", 
/* 246 */       0, 
/* 247 */       0, null, null));
/* 248 */     topPanel.add(iconPanel, "Center");
/*     */     
/* 250 */     resource = getClass().getResource("/img/newFamilyTree.png");
/* 251 */     icon = new ImageIcon(resource);
/* 252 */     this.newFamilyTreeButton = new MyButton(icon);
/*     */     
/* 254 */     this.newFamilyTreeButton.setMnemonic(78);
/* 255 */     this.newFamilyTreeButton.setOpaque(false);
/* 256 */     this.newFamilyTreeButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 258 */         if (IndexFrame.this.centerPanel.getComponent(0) != IndexFrame.this.backgroundLabel) {
/* 259 */           int result = JOptionPane.showOptionDialog(null, 
/* 260 */             "需要对现有的家谱进行保存吗？", "新建家谱前", 
/* 261 */             1, 
/* 262 */             3, null, null, null);
/* 263 */           switch (result) {
/*     */           case 0: 
/* 265 */             JFileChooser chooser = new JFileChooser();
/* 266 */             FileFilter filter = new FileNameExtensionFilter(
/* 267 */               "家谱文件(*.dat)", new String[] { "dat" });
/* 268 */             chooser.setFileFilter(filter);
/* 269 */             chooser.setFileSelectionMode(0);
/* 270 */             chooser.setMultiSelectionEnabled(false);
/* 271 */             int result1 = chooser.showSaveDialog(IndexFrame.this.getContentPane());
/* 272 */             if (result1 == 0) {
/* 273 */               File file = chooser.getSelectedFile();
/* 274 */               IndexFrame.this.nodetree.saveNodeTree(file.getAbsolutePath());
/*     */             }
/* 276 */             new FamilyRootFrame(IndexFrame.this.centerPanel, IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 277 */             break;
/*     */           case 1: 
/* 279 */             new FamilyRootFrame(IndexFrame.this.centerPanel, IndexFrame.this.textarea, IndexFrame.this.nodetree);
/*     */           }
/*     */           
/*     */         }
/*     */         else
/*     */         {
/* 285 */           new FamilyRootFrame(IndexFrame.this.centerPanel, IndexFrame.this.textarea, IndexFrame.this.nodetree);
/*     */         }
/*     */       }
/* 288 */     });
/* 289 */     iconPanel.add(this.newFamilyTreeButton);
/*     */     
/* 291 */     resource = getClass().getResource("/img/saveFamilyTree.png");
/* 292 */     icon = new ImageIcon(resource);
/* 293 */     this.saveFamilyTreeButton = new MyButton(icon);
/* 294 */     this.saveFamilyTreeButton.setMnemonic(83);
/* 295 */     this.saveFamilyTreeButton.setOpaque(false);
/* 296 */     this.saveFamilyTreeButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 298 */         if (IndexFrame.this.centerPanel.getComponent(0) == IndexFrame.this.backgroundLabel) {
/* 299 */           JOptionPane.showMessageDialog(null, "还未打开文件，不能保存家谱。");
/* 300 */           return;
/*     */         }
/* 302 */         JFileChooser chooser = new JFileChooser();
/* 303 */         FileFilter filter = new FileNameExtensionFilter("家谱文件(*.dat)", new String[] {
/* 304 */           "dat" });
/* 305 */         chooser.setFileFilter(filter);
/* 306 */         chooser.setFileSelectionMode(0);
/* 307 */         chooser.setMultiSelectionEnabled(false);
/* 308 */         int result = chooser.showSaveDialog(IndexFrame.this.getContentPane());
/* 309 */         if (result == 0) {
/* 310 */           File file = chooser.getSelectedFile();
/* 311 */           IndexFrame.this.nodetree.saveNodeTree(file.getAbsolutePath());
/*     */         }
/*     */       }
/* 314 */     });
/* 315 */     iconPanel.add(this.saveFamilyTreeButton);
/*     */     
/* 317 */     resource = getClass().getResource("/img/openFile.png");
/* 318 */     icon = new ImageIcon(resource);
/* 319 */     this.openFileButton = new MyButton(icon);
/* 320 */     this.openFileButton.setMnemonic(79);
/* 321 */     this.openFileButton.setOpaque(false);
/* 322 */     this.openFileButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 324 */         if (IndexFrame.this.centerPanel.getComponent(0) != IndexFrame.this.backgroundLabel) {
/* 325 */           int result = JOptionPane.showOptionDialog(null, 
/* 326 */             "需要对现有的家谱进行保存吗？", "新建家谱前", 
/* 327 */             1, 
/* 328 */             3, null, null, null);
/* 329 */           if (result == 0) {
/* 330 */             JFileChooser chooser = new JFileChooser();
/* 331 */             FileFilter filter = new FileNameExtensionFilter(
/* 332 */               "家谱文件(*.dat)", new String[] { "dat" });
/* 333 */             chooser.setFileFilter(filter);
/* 334 */             chooser.setFileSelectionMode(0);
/* 335 */             chooser.setMultiSelectionEnabled(false);
/* 336 */             int result1 = chooser.showSaveDialog(IndexFrame.this.getContentPane());
/* 337 */             if (result1 == 0) {
/* 338 */               File file = chooser.getSelectedFile();
/* 339 */               IndexFrame.this.nodetree.saveNodeTree(file.getAbsolutePath());
/*     */             }
/*     */           }
/* 342 */           if (result == 2) {
/* 343 */             return;
/*     */           }
/*     */         }
/*     */         
/* 347 */         JFileChooser chooser = new JFileChooser();
/* 348 */         FileFilter filter = new FileNameExtensionFilter("家谱文件(*.dat)", new String[] {
/* 349 */           "dat" });
/* 350 */         chooser.setFileFilter(filter);
/* 351 */         chooser.setFileSelectionMode(0);
/* 352 */         chooser.setMultiSelectionEnabled(false);
/* 353 */         int result = chooser.showOpenDialog(IndexFrame.this.getContentPane());
/* 354 */         if (result == 0) {
/* 355 */           File file = chooser.getSelectedFile();
/* 356 */           IndexFrame.this.nodetree.readNodeTree(file.getAbsolutePath());
/* 357 */           IndexFrame.this.centerPanel.removeAll();
/* 358 */           IndexFrame.this.centerPanel.add(new ShowAllMemberPanel(IndexFrame.this.centerPanel, 
/* 359 */             IndexFrame.this.textarea, IndexFrame.this.nodetree), "Center");
/* 360 */           SwingUtilities.updateComponentTreeUI(IndexFrame.this.centerPanel);
/*     */         }
/*     */       }
/* 363 */     });
/* 364 */     iconPanel.add(this.openFileButton);
/*     */     
/* 366 */     resource = getClass().getResource("/img/showTree.png");
/* 367 */     icon = new ImageIcon(resource);
/* 368 */     this.showTreeButton = new MyButton(icon);
/* 369 */     this.showTreeButton.setMnemonic(68);
/* 370 */     this.showTreeButton.setOpaque(false);
/* 371 */     this.showTreeButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 373 */         if (IndexFrame.this.nodetree.getRootNode() == null) {
/* 374 */           JOptionPane.showMessageDialog(null, "还未打开文件，不能显示家谱。");
/* 375 */           return;
/*     */         }
/* 377 */         IndexFrame.this.centerPanel.removeAll();
/* 378 */         IndexFrame.this.centerPanel.add(new ShowAllMemberPanel(IndexFrame.this.centerPanel, IndexFrame.this.textarea, 
/* 379 */           IndexFrame.this.nodetree), "Center");
/* 380 */         SwingUtilities.updateComponentTreeUI(IndexFrame.this.centerPanel);
/*     */       }
/* 382 */     });
/* 383 */     iconPanel.add(this.showTreeButton);
/*     */     
/* 385 */     resource = getClass().getResource("/img/about.png");
/* 386 */     icon = new ImageIcon(resource);
/* 387 */     this.aboutButton = new MyButton(icon);
/* 388 */     this.aboutButton.setMnemonic(73);
/* 389 */     this.aboutButton.setOpaque(false);
/* 390 */     this.aboutButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 392 */         new AboutFrame();
/*     */       }
/* 394 */     });
/* 395 */     iconPanel.add(this.aboutButton);
/*     */     
/* 397 */     resource = getClass().getResource("/img/exitFamilyTree.png");
/* 398 */     icon = new ImageIcon(resource);
/* 399 */     this.exitFamilyTreeButton = new MyButton(icon);
/* 400 */     this.exitFamilyTreeButton.setMnemonic(81);
/* 401 */     this.exitFamilyTreeButton.setOpaque(false);
/* 402 */     this.exitFamilyTreeButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 404 */         System.exit(0);
/*     */       }
/* 406 */     });
/* 407 */     iconPanel.add(this.exitFamilyTreeButton);
/*     */     
/* 409 */     this.leftPanel = new MyPanel(this.iconForLeftPanel);
/* 410 */     this.leftPanel.setBackground(new Color(90, 130, 189));
/* 411 */     this.leftPanel.setLayout(new BorderLayout());
/* 412 */     this.leftPanel.setBorder(new TitledBorder(null, "", 
/* 413 */       0, 
/* 414 */       0, null, null));
/* 415 */     this.leftPanel.setPreferredSize(new Dimension((int)(getWidth() * 0.25D), 0));
/* 416 */     getContentPane().add(this.leftPanel, "West");
/*     */     
/* 418 */     JScrollPane scrollPane = new JScrollPane();
/* 419 */     this.leftPanel.add(scrollPane);
/*     */     
/* 421 */     DefaultMutableTreeNode root = new DefaultMutableTreeNode("操作选择");
/*     */     
/* 423 */     DefaultMutableTreeNode addNode = new DefaultMutableTreeNode("添加");
/* 424 */     addNode.add(new DefaultMutableTreeNode("添加父亲"));
/* 425 */     addNode.add(new DefaultMutableTreeNode("添加兄弟姐妹"));
/* 426 */     addNode.add(new DefaultMutableTreeNode("添加孩子"));
/* 427 */     addNode.add(new DefaultMutableTreeNode("添加配偶"));
/* 428 */     root.add(addNode);
/*     */     
/* 430 */     DefaultMutableTreeNode deleteNode = new DefaultMutableTreeNode("删除");
/* 431 */     deleteNode.add(new DefaultMutableTreeNode("删除整个家谱"));
/* 432 */     deleteNode.add(new DefaultMutableTreeNode("删除家谱文件"));
/* 433 */     deleteNode.add(new DefaultMutableTreeNode("删除部分家谱"));
/* 434 */     deleteNode.add(new DefaultMutableTreeNode("删除配偶"));
/* 435 */     root.add(deleteNode);
/*     */     
/* 437 */     DefaultMutableTreeNode modifyNode = new DefaultMutableTreeNode("修改");
/* 438 */     modifyNode.add(new DefaultMutableTreeNode("修改个人信息"));
/* 439 */     modifyNode.add(new DefaultMutableTreeNode("修改配偶信息"));
/* 440 */     root.add(modifyNode);
/*     */     
/* 442 */     DefaultMutableTreeNode findNode = new DefaultMutableTreeNode("查找");
/* 443 */     findNode.add(new DefaultMutableTreeNode("查找父亲"));
/* 444 */     findNode.add(new DefaultMutableTreeNode("查找孩子"));
/* 445 */     findNode.add(new DefaultMutableTreeNode("查找亲兄弟姐妹"));
/* 446 */     findNode.add(new DefaultMutableTreeNode("查找堂兄弟姐妹"));
/* 447 */     findNode.add(new DefaultMutableTreeNode("查找祖父"));
/* 448 */     findNode.add(new DefaultMutableTreeNode("查找孙子"));
/* 449 */     findNode.add(new DefaultMutableTreeNode("查找曾祖父"));
/* 450 */     findNode.add(new DefaultMutableTreeNode("查找曾孙子"));
/* 451 */     root.add(findNode);
/*     */     
/* 453 */     DefaultMutableTreeNode searchNode = new DefaultMutableTreeNode("搜索");
/* 454 */     searchNode.add(new DefaultMutableTreeNode("按姓名"));
/* 455 */     searchNode.add(new DefaultMutableTreeNode("按出生地"));
/* 456 */     searchNode.add(new DefaultMutableTreeNode("按出生日期"));
/* 457 */     searchNode.add(new DefaultMutableTreeNode("按死亡日期"));
/* 458 */     searchNode.add(new DefaultMutableTreeNode("按性别"));
/* 459 */     searchNode.add(new DefaultMutableTreeNode("按身高"));
/* 460 */     searchNode.add(new DefaultMutableTreeNode("按工作"));
/* 461 */     searchNode.add(new DefaultMutableTreeNode("按学历程度"));
/* 462 */     searchNode.add(new DefaultMutableTreeNode("按最高职称"));
/* 463 */     searchNode.add(new DefaultMutableTreeNode("按是否死亡"));
/* 464 */     searchNode.add(new DefaultMutableTreeNode("按是否结婚"));
/* 465 */     searchNode.add(new DefaultMutableTreeNode("按是否有孩子"));
/* 466 */     searchNode.add(new DefaultMutableTreeNode("按电话号码"));
/* 467 */     searchNode.add(new DefaultMutableTreeNode("按住址"));
/* 468 */     searchNode.add(new DefaultMutableTreeNode("按第几代"));
/* 469 */     root.add(searchNode);
/*     */     
/* 471 */     DefaultMutableTreeNode statisticNode = new DefaultMutableTreeNode(
/* 472 */       "统计信息查询");
/* 473 */     statisticNode.add(new DefaultMutableTreeNode("平均寿命"));
/* 474 */     statisticNode.add(new DefaultMutableTreeNode("平均身高"));
/* 475 */     statisticNode.add(new DefaultMutableTreeNode("男女比例"));
/* 476 */     statisticNode.add(new DefaultMutableTreeNode("家庭平均人口"));
/* 477 */     statisticNode.add(new DefaultMutableTreeNode("平均学历"));
/* 478 */     statisticNode.add(new DefaultMutableTreeNode("最高学历"));
/* 479 */     statisticNode.add(new DefaultMutableTreeNode("最低学历"));
/* 480 */     root.add(statisticNode);
/*     */     
/* 482 */     DefaultTreeModel treeModel = new DefaultTreeModel(root);
/*     */     
/* 484 */     this.tree = new JTree(treeModel);
/* 485 */     this.tree.setBackground(Color.WHITE);
/* 486 */     this.tree.setRootVisible(false);
/* 487 */     this.tree.setRowHeight(22);
/* 488 */     this.tree.setFont(new Font("null", 0, 15));
/*     */     
/* 490 */     DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
/* 491 */     renderer.setLeafIcon(null);
/* 492 */     renderer.setClosedIcon(null);
/* 493 */     renderer.setOpenIcon(null);
/* 494 */     this.tree.setCellRenderer(renderer);
/* 495 */     int count = root.getChildCount();
/* 496 */     for (int i = 0; i < count; i++) {
/* 497 */       DefaultMutableTreeNode node = (DefaultMutableTreeNode)root
/* 498 */         .getChildAt(i);
/* 499 */       TreePath path = new TreePath(node.getPath());
/* 500 */       this.tree.expandPath(path);
/*     */     }
/* 502 */     this.tree.addTreeSelectionListener(new TreeSelectionListener() {
/*     */       public void valueChanged(TreeSelectionEvent e) {
/* 504 */         TreePath treePath = e.getPath();
/* 505 */         if (treePath.getPathCount() == 2) {
/* 506 */           IndexFrame.this.centerPanel.add(IndexFrame.this.backgroundLabel, 
/* 507 */             "Center");
/*     */         } else {
/* 509 */           String selectedNode = treePath
/* 510 */             .getLastPathComponent().toString();
/* 511 */           String parentNode = treePath.getParentPath()
/* 512 */             .getLastPathComponent().toString();
/* 513 */           IndexFrame.this.tree.setSelectionPath(treePath.getParentPath());
/* 514 */           if (parentNode.equals("添加")) {
/* 515 */             System.out.println("添加");
/*     */             
/* 517 */             if ((IndexFrame.this.centerPanel.getComponent(0) instanceof ShowAllMemberPanel)) {
/* 518 */               IndexFrame.this.node = ShowAllMemberPanel.getTemp();
/*     */             }
/* 520 */             if ((IndexFrame.this.centerPanel.getComponent(0) instanceof ShowFindingResultPanel)) {
/* 521 */               IndexFrame.this.node = 
/* 522 */                 ShowFindingResultPanel.getFindingResultNode();
/*     */             }
/* 524 */             if (selectedNode.equals("添加父亲")) {
/* 525 */               if (IndexFrame.this.node == null) {
/* 526 */                 JOptionPane.showMessageDialog(null, 
/* 527 */                   "请先在家谱中选择需添加祖先的成员。");
/* 528 */                 return;
/*     */               }
/* 530 */               if (IndexFrame.this.node.getFatherNode() != null) {
/* 531 */                 JOptionPane.showMessageDialog(null, 
/* 532 */                   "该成员已有父亲，不能再添加父亲。", "错误提示", 
/* 533 */                   0);
/* 534 */                 return;
/*     */               }
/* 536 */               new FamilyParentFrame(IndexFrame.this.centerPanel, 
/* 537 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree, IndexFrame.this.node);
/* 538 */             } else if (selectedNode.equals("添加兄弟姐妹")) {
/* 539 */               if (IndexFrame.this.node == null) {
/* 540 */                 JOptionPane.showMessageDialog(null, 
/* 541 */                   "请先在家谱中选择需添加兄弟的成员。");
/* 542 */                 return;
/*     */               }
/* 544 */               new FamilySiblingFrame(IndexFrame.this.centerPanel, 
/* 545 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree, IndexFrame.this.node);
/* 546 */             } else if (selectedNode.equals("添加孩子")) {
/* 547 */               if (IndexFrame.this.node == null) {
/* 548 */                 JOptionPane.showMessageDialog(null, 
/* 549 */                   "请先在家谱中选择需添加孩子的成员。");
/* 550 */                 return;
/*     */               }
/* 552 */               if (IndexFrame.this.node.getSex() == 1) {
/* 553 */                 JOptionPane.showMessageDialog(null, 
/* 554 */                   "所选成员为女性，不可添加孩子。");
/* 555 */                 return;
/*     */               }
/* 557 */               new FamilyChildrenFrame(IndexFrame.this.centerPanel, 
/* 558 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree, IndexFrame.this.node);
/*     */             } else {
/* 560 */               if (IndexFrame.this.node == null) {
/* 561 */                 JOptionPane.showMessageDialog(null, 
/* 562 */                   "请先在家谱中选择需添加配偶的成员。");
/* 563 */                 return;
/*     */               }
/* 565 */               if (IndexFrame.this.node.getSpouseNode() != null) {
/* 566 */                 JOptionPane.showMessageDialog(null, 
/* 567 */                   "所选成员已有配偶，不可添加配偶。");
/* 568 */                 return;
/*     */               }
/* 570 */               if (IndexFrame.this.node.getSex() == 1) {
/* 571 */                 JOptionPane.showMessageDialog(null, 
/* 572 */                   "所选成员为女性，不可添加配偶。");
/* 573 */                 return;
/*     */               }
/* 575 */               new FamilySpouseFrame(IndexFrame.this.centerPanel, 
/* 576 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree, IndexFrame.this.node);
/*     */             }
/* 578 */           } else if (parentNode.equals("删除")) {
/* 579 */             System.out.println("删除");
/* 580 */             if (selectedNode.equals("删除整个家谱")) {
/* 581 */               if (IndexFrame.this.centerPanel.getComponent(0) == IndexFrame.this.backgroundLabel) {
/* 582 */                 JOptionPane.showMessageDialog(null, 
/* 583 */                   "还未打开文件，不能删除整个家谱。");
/* 584 */                 return;
/*     */               }
/* 586 */               int result = JOptionPane.showOptionDialog(
/* 587 */                 null, "确定要删除整个家谱？", "确定提示", 
/* 588 */                 0, 
/* 589 */                 3, null, 
/* 590 */                 null, null);
/* 591 */               if (result == 0) {
/* 592 */                 IndexFrame.this.nodetree.destroyNodeTree();
/* 593 */                 IndexFrame.this.centerPanel.removeAll();
/* 594 */                 IndexFrame.this.centerPanel.add(IndexFrame.this.backgroundLabel, 
/* 595 */                   "Center");
/*     */                 
/* 597 */                 SwingUtilities.updateComponentTreeUI(IndexFrame.this.centerPanel);
/*     */               }
/* 599 */               return; }
/* 600 */             if (selectedNode.equals("删除家谱文件")) {
/* 601 */               JFileChooser chooser = new JFileChooser();
/* 602 */               FileFilter filter = new FileNameExtensionFilter(
/* 603 */                 "家谱文件(*.dat)", new String[] { "dat" });
/* 604 */               chooser.setFileFilter(filter);
/* 605 */               chooser
/* 606 */                 .setFileSelectionMode(0);
/* 607 */               chooser.setMultiSelectionEnabled(false);
/* 608 */               int result = chooser.showDialog(
/* 609 */                 IndexFrame.this.getContentPane(), "删除家谱文件");
/* 610 */               if (result == 0) {
/* 611 */                 File file = chooser.getSelectedFile();
/* 612 */                 int response = 
/* 613 */                   JOptionPane.showOptionDialog(
/* 614 */                   null, 
/* 615 */                   "确定删除该家谱文件？", 
/* 616 */                   "删除提示", 
/* 617 */                   0, 
/* 618 */                   3, 
/* 619 */                   null, null, null);
/* 620 */                 if (response == 0) {
/* 621 */                   file.delete();
/*     */                 }
/*     */               }
/*     */             }
/* 625 */             else if (selectedNode.equals("删除部分家谱")) {
/* 626 */               if ((IndexFrame.this.centerPanel.getComponent(0) instanceof ShowAllMemberPanel)) {
/* 627 */                 IndexFrame.this.node = ShowAllMemberPanel.getTemp();
/*     */               }
/* 629 */               if ((IndexFrame.this.centerPanel.getComponent(0) instanceof ShowFindingResultPanel)) {
/* 630 */                 IndexFrame.this.node = 
/* 631 */                   ShowFindingResultPanel.getFindingResultNode();
/*     */               }
/* 633 */               if (IndexFrame.this.node == null) {
/* 634 */                 JOptionPane.showMessageDialog(null, 
/* 635 */                   "请先在家谱中选择需删除的成员。");
/* 636 */                 return;
/*     */               }
/* 638 */               IndexFrame.this.nodetree.deleteMember(IndexFrame.this.node);
/* 639 */               IndexFrame.this.centerPanel.removeAll();
/* 640 */               IndexFrame.this.centerPanel.add(new ShowAllMemberPanel(
/* 641 */                 IndexFrame.this.centerPanel, IndexFrame.this.textarea, IndexFrame.this.nodetree), 
/* 642 */                 "Center");
/* 643 */               if (IndexFrame.this.nodetree.getRootNode() == null) {
/* 644 */                 IndexFrame.this.centerPanel.add(IndexFrame.this.backgroundLabel, 
/* 645 */                   "Center");
/*     */               }
/*     */               
/* 648 */               SwingUtilities.updateComponentTreeUI(IndexFrame.this.centerPanel);
/*     */             } else {
/* 650 */               if ((IndexFrame.this.centerPanel.getComponent(0) instanceof ShowAllMemberPanel)) {
/* 651 */                 IndexFrame.this.node = ShowAllMemberPanel.getTemp();
/*     */               }
/* 653 */               if ((IndexFrame.this.centerPanel.getComponent(0) instanceof ShowFindingResultPanel)) {
/* 654 */                 IndexFrame.this.node = 
/* 655 */                   ShowFindingResultPanel.getFindingResultNode();
/*     */               }
/* 657 */               if (IndexFrame.this.node == null) {
/* 658 */                 JOptionPane.showMessageDialog(null, 
/* 659 */                   "请先在家谱中选择需删除配偶的成员。");
/* 660 */                 return;
/*     */               }
/* 662 */               if (IndexFrame.this.node.getSpouseNode() == null) {
/* 663 */                 JOptionPane.showMessageDialog(null, 
/* 664 */                   "该人没有配偶，不能进行删除操作。", "错误提示", 
/* 665 */                   0);
/*     */               }
/* 667 */               IndexFrame.this.nodetree.deleteSpouse(IndexFrame.this.node);
/* 668 */               IndexFrame.this.centerPanel.removeAll();
/* 669 */               IndexFrame.this.centerPanel.add(new ShowAllMemberPanel(
/* 670 */                 IndexFrame.this.centerPanel, IndexFrame.this.textarea, IndexFrame.this.nodetree), 
/* 671 */                 "Center");
/*     */               
/* 673 */               SwingUtilities.updateComponentTreeUI(IndexFrame.this.centerPanel);
/*     */             }
/* 675 */           } else if (parentNode.equals("修改")) {
/* 676 */             System.out.println("修改");
/* 677 */             if ((IndexFrame.this.centerPanel.getComponent(0) instanceof ShowAllMemberPanel)) {
/* 678 */               IndexFrame.this.node = ShowAllMemberPanel.getTemp();
/*     */             }
/* 680 */             if ((IndexFrame.this.centerPanel.getComponent(0) instanceof ShowFindingResultPanel)) {
/* 681 */               IndexFrame.this.node = 
/* 682 */                 ShowFindingResultPanel.getFindingResultNode();
/*     */             }
/* 684 */             if (selectedNode.equals("修改个人信息")) {
/* 685 */               if (IndexFrame.this.node == null) {
/* 686 */                 JOptionPane.showMessageDialog(null, 
/* 687 */                   "请先在家谱中选择需修改个人信息的成员。");
/* 688 */                 return;
/*     */               }
/* 690 */               new ModifyInformationFrame(IndexFrame.this.centerPanel, 
/* 691 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree, IndexFrame.this.node);
/*     */             } else {
/* 693 */               if (IndexFrame.this.node == null) {
/* 694 */                 JOptionPane.showMessageDialog(null, 
/* 695 */                   "请先在家谱中选择需修改配偶的成员。");
/* 696 */                 return;
/*     */               }
/* 698 */               if (IndexFrame.this.node.getSpouseNode() != null) {
/* 699 */                 new ModifyInformationFrame(IndexFrame.this.centerPanel, 
/* 700 */                   IndexFrame.this.textarea, IndexFrame.this.nodetree, IndexFrame.this.node
/* 701 */                   .getSpouseNode());
/*     */               } else {
/* 703 */                 JOptionPane.showMessageDialog(null, 
/* 704 */                   "该人没有配偶，不能进行修改操作。", "错误提示", 
/* 705 */                   0);
/*     */               }
/*     */             }
/* 708 */           } else if (parentNode.equals("查找")) {
/* 709 */             System.out.println("查找");
/* 710 */             if ((IndexFrame.this.centerPanel.getComponent(0) instanceof ShowAllMemberPanel)) {
/* 711 */               IndexFrame.this.node = ShowAllMemberPanel.getTemp();
/*     */             }
/* 713 */             if ((IndexFrame.this.centerPanel.getComponent(0) instanceof ShowFindingResultPanel)) {
/* 714 */               IndexFrame.this.node = 
/* 715 */                 ShowFindingResultPanel.getFindingResultNode();
/*     */             }
/* 717 */             if (IndexFrame.this.node == null) {
/* 718 */               JOptionPane.showMessageDialog(null, 
/* 719 */                 "请先在家谱中选择需查找亲戚关系的成员。");
/* 720 */               return;
/*     */             }
/* 722 */             ArrayList<Node> list = new ArrayList();
/* 723 */             if (selectedNode.equals("查找父亲")) {
/* 724 */               IndexFrame.this.nodetree.findParent(list, IndexFrame.this.node);
/* 725 */             } else if (selectedNode.equals("查找孩子")) {
/* 726 */               IndexFrame.this.nodetree.findChildren(list, IndexFrame.this.node);
/* 727 */             } else if (selectedNode.equals("查找亲兄弟姐妹")) {
/* 728 */               IndexFrame.this.nodetree.findSibling(list, IndexFrame.this.node);
/* 729 */             } else if (selectedNode.equals("查找堂兄弟姐妹")) {
/* 730 */               IndexFrame.this.nodetree.findCousin(list, IndexFrame.this.node);
/* 731 */             } else if (selectedNode.equals("查找祖父")) {
/* 732 */               IndexFrame.this.nodetree.findGrandpa(list, IndexFrame.this.node);
/* 733 */             } else if (selectedNode.equals("查找孙子")) {
/* 734 */               IndexFrame.this.nodetree.findGrandson(list, IndexFrame.this.node);
/* 735 */             } else if (selectedNode.equals("查找曾祖父")) {
/* 736 */               IndexFrame.this.nodetree.findGreatGrandpa(list, IndexFrame.this.node);
/*     */             } else {
/* 738 */               IndexFrame.this.nodetree.findGreatGrandson(list, IndexFrame.this.node);
/*     */             }
/* 740 */             IndexFrame.this.centerPanel.removeAll();
/* 741 */             IndexFrame.this.centerPanel.add(new ShowFindingResultPanel(
/* 742 */               list, IndexFrame.this.textarea), "Center");
/*     */             
/* 744 */             SwingUtilities.updateComponentTreeUI(IndexFrame.this.centerPanel);
/* 745 */           } else if (parentNode.equals("搜索")) {
/* 746 */             System.out.println("搜索");
/* 747 */             if (IndexFrame.this.nodetree.getRootNode() == null) {
/* 748 */               JOptionPane.showMessageDialog(null, 
/* 749 */                 "请先添加家谱。");
/* 750 */               return;
/*     */             }
/* 752 */             if (selectedNode.equals("按姓名")) {
/* 753 */               new SearchByNameFrame(IndexFrame.this.centerPanel, 
/* 754 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 755 */             } else if (selectedNode.equals("按出生地")) {
/* 756 */               new SearchByBornplaceFrame(IndexFrame.this.centerPanel, 
/* 757 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 758 */             } else if (selectedNode.equals("按出生日期")) {
/* 759 */               new SearchByBirthdayFrame(IndexFrame.this.centerPanel, 
/* 760 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 761 */             } else if (selectedNode.equals("按死亡日期")) {
/* 762 */               new SearchByDeathdayFrame(IndexFrame.this.centerPanel, 
/* 763 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 764 */             } else if (selectedNode.equals("按性别")) {
/* 765 */               new SearchBySexFrame(IndexFrame.this.centerPanel, IndexFrame.this.textarea, 
/* 766 */                 IndexFrame.this.nodetree);
/* 767 */             } else if (selectedNode.equals("按身高")) {
/* 768 */               new SearchByHeightFrame(IndexFrame.this.centerPanel, 
/* 769 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 770 */             } else if (selectedNode.equals("按工作")) {
/* 771 */               new SearchByJobFrame(IndexFrame.this.centerPanel, IndexFrame.this.textarea, 
/* 772 */                 IndexFrame.this.nodetree);
/* 773 */             } else if (selectedNode.equals("按学历程度")) {
/* 774 */               new SearchByEducationFrame(IndexFrame.this.centerPanel, 
/* 775 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 776 */             } else if (selectedNode.equals("按最高职称")) {
/* 777 */               new SearchByTop_titleFrame(IndexFrame.this.centerPanel, 
/* 778 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 779 */             } else if (selectedNode.equals("按是否死亡")) {
/* 780 */               new SearchByIsDeadFrame(IndexFrame.this.centerPanel, 
/* 781 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 782 */             } else if (selectedNode.equals("按是否结婚")) {
/* 783 */               new SearchByMarriedFrame(IndexFrame.this.centerPanel, 
/* 784 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 785 */             } else if (selectedNode.equals("按是否有孩子")) {
/* 786 */               new SearchByHasChildFrame(IndexFrame.this.centerPanel, 
/* 787 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 788 */             } else if (selectedNode.equals("按电话号码")) {
/* 789 */               new SearchByTelephoneFrame(IndexFrame.this.centerPanel, 
/* 790 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 791 */             } else if (selectedNode.equals("按住址")) {
/* 792 */               new SearchByAddressFrame(IndexFrame.this.centerPanel, 
/* 793 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/* 794 */             } else if (selectedNode.equals("按第几代")) {
/* 795 */               new SearchByLevelFrame(IndexFrame.this.centerPanel, 
/* 796 */                 IndexFrame.this.textarea, IndexFrame.this.nodetree);
/*     */             }
/*     */           } else {
/* 799 */             System.out.println("统计信息查询");
/* 800 */             if (IndexFrame.this.nodetree.getRootNode() == null) {
/* 801 */               JOptionPane.showMessageDialog(null, 
/* 802 */                 "请先添加家谱。");
/* 803 */               return;
/*     */             }
/* 805 */             if (selectedNode.equals("平均寿命")) {
/* 806 */               if (IndexFrame.this.nodetree.AllDeadMember(IndexFrame.this.nodetree
/* 807 */                 .getRootNode()) == 0) {
/* 808 */                 JOptionPane.showMessageDialog(null, 
/* 809 */                   "该家谱中因成员均未死亡，故不能计算家族平均寿命。");
/* 810 */                 return;
/*     */               }
/*     */               
/* 813 */               JOptionPane.showMessageDialog(
/* 814 */                 null, 
/* 815 */                 "家族平均寿命为" + 
/* 816 */                 IndexFrame.this.nodetree
/* 817 */                 .AverageLife(IndexFrame.this.nodetree
/* 818 */                 .getRootNode()) + 
/* 819 */                 "岁");
/* 820 */             } else if (selectedNode.equals("平均身高")) {
/* 821 */               DecimalFormat df = new DecimalFormat(
/* 822 */                 "#0.00");
/* 823 */               String height = df.format(IndexFrame.this.nodetree
/* 824 */                 .AverageHeight(IndexFrame.this.nodetree
/* 825 */                 .getRootNode()));
/* 826 */               if (Double.parseDouble(height) == 0.0D) {
/* 827 */                 JOptionPane.showMessageDialog(null, 
/* 828 */                   "该家谱中成员未录入身高，故不能计算家族平均身高。");
/* 829 */                 return;
/*     */               }
/* 831 */               JOptionPane.showMessageDialog(null, 
/* 832 */                 "家族平均身高为 " + height + "米");
/* 833 */             } else if (selectedNode.equals("男女比例"))
/*     */             {
/* 835 */               JOptionPane.showMessageDialog(
/* 836 */                 null, 
/* 837 */                 "家族男性比例为：" + 
/* 838 */                 IndexFrame.this.nodetree
/* 839 */                 .MalePercentage(IndexFrame.this.nodetree
/* 840 */                 .getRootNode()) + 
/* 841 */                 " ；女性比例为：" + 
/* 842 */                 IndexFrame.this.nodetree
/* 843 */                 .FemalePercentage(IndexFrame.this.nodetree
/* 844 */                 .getRootNode()));
/* 845 */             } else if (selectedNode.equals("家庭平均人口"))
/*     */             {
/* 847 */               JOptionPane.showMessageDialog(
/* 848 */                 null, 
/* 849 */                 "家庭平均人口为" + 
/* 850 */                 IndexFrame.this.nodetree
/* 851 */                 .AverageFamilyMember(IndexFrame.this.nodetree
/* 852 */                 .getRootNode()));
/* 853 */             } else if (selectedNode.equals("平均学历"))
/*     */             {
/* 855 */               JOptionPane.showMessageDialog(
/* 856 */                 null, 
/* 857 */                 "家族平均学历为" + 
/* 858 */                 IndexFrame.this.nodetree
/* 859 */                 .AverageEducation(IndexFrame.this.nodetree
/* 860 */                 .getRootNode()));
/* 861 */             } else if (selectedNode.equals("最高学历"))
/*     */             {
/* 863 */               JOptionPane.showMessageDialog(
/* 864 */                 null, 
/* 865 */                 "家族最高学历为" + 
/* 866 */                 IndexFrame.this.nodetree
/* 867 */                 .TopestEducation(IndexFrame.this.nodetree
/* 868 */                 .getRootNode()));
/*     */             }
/*     */             else {
/* 871 */               JOptionPane.showMessageDialog(
/* 872 */                 null, 
/* 873 */                 "家族最低学历为" + 
/* 874 */                 IndexFrame.this.nodetree
/* 875 */                 .LowestEducation(IndexFrame.this.nodetree
/* 876 */                 .getRootNode()));
/*     */             }
/*     */           }
/*     */         }
/* 880 */         IndexFrame.this.node = null;
/*     */       }
/* 882 */     });
/* 883 */     scrollPane.setViewportView(this.tree);
/*     */     
/* 885 */     this.rightPanel = new MyPanel(this.iconForRightPanel);
/* 886 */     this.rightPanel.setBackground(new Color(90, 130, 189));
/* 887 */     this.rightPanel.setLayout(new BorderLayout());
/* 888 */     this.rightPanel.setBorder(new TitledBorder(null, "", 
/* 889 */       0, 
/* 890 */       0, null, null));
/* 891 */     this.rightPanel
/* 892 */       .setPreferredSize(new Dimension((int)(getWidth() * 0.31D), 0));
/* 893 */     getContentPane().add(this.rightPanel, "East");
/*     */     
/* 895 */     JScrollPane scrollPane1 = new JScrollPane();
/* 896 */     this.rightPanel.add(scrollPane1);
/*     */     
/* 898 */     this.textarea.setLineWrap(true);
/* 899 */     scrollPane1.setViewportView(this.textarea);
/* 900 */     this.textarea.setEditable(false);
/* 901 */     this.textarea.setFont(new Font("null", 0, 14));
/*     */     
/* 903 */     this.centerPanel.setLayout(new BorderLayout());
/* 904 */     this.centerPanel
/* 905 */       .setPreferredSize(new Dimension((int)(getWidth() * 0.44D), 0));
/* 906 */     this.centerPanel.setBackground(Color.WHITE);
/* 907 */     this.centerPanel.setBorder(new TitledBorder(null, "", 
/* 908 */       0, 
/* 909 */       0, null, null));
/* 910 */     getContentPane().add(this.centerPanel, "Center");
/*     */     
/* 912 */     this.backgroundLabel = new JLabel();
/* 913 */     this.backgroundLabel.setBackground(Color.WHITE);
/* 914 */     this.backgroundLabel.setOpaque(true);
/* 915 */     this.centerPanel.add(this.backgroundLabel, "Center");
/*     */   }
/*     */   
/*     */   public JButton getOpenFileButton() {
/* 919 */     return this.openFileButton;
/*     */   }
/*     */   
/*     */   public JButton getNewFamilyTreeButton() {
/* 923 */     return this.newFamilyTreeButton;
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\frame\IndexFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */