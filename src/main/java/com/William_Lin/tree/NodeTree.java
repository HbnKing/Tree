/*     */ package com.William_Lin.tree;
/*     */ 
/*     */ import com.William_Lin.node.Node;
/*     */ import com.William_Lin.tool.NumberForReference;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ public class NodeTree
/*     */ {
/*     */   private Node root;
/*     */   
/*     */   public Node getRootNode()
/*     */   {
/*  22 */     return this.root;
/*     */   }
/*     */   
/*     */   public void setRootNode(Node node) {
/*  26 */     this.root = node;
/*     */   }
/*     */   
/*     */   public NodeTree()
/*     */   {
/*     */     try {
/*  32 */       this.root = null;
/*     */     } catch (Exception e) {
/*  34 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void destroyNodeTree()
/*     */   {
/*  40 */     deleteMemberHelper(this.root);
/*  41 */     setRootNode(null);
/*     */   }
/*     */   
/*     */ 
/*     */   public void newNodeTree()
/*     */   {
/*  47 */     destroyNodeTree();
/*     */     try {
/*  49 */       this.root = null;
/*     */     } catch (Exception e) {
/*  51 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addChildMember(Node parent, Node addNode)
/*     */   {
/*  57 */     addNode.setFatherNode(parent);
/*  58 */     addNode.setLevel(parent.getLevel() + 1);
/*  59 */     parent.setHasChild(true);
/*  60 */     if (parent.getLeftNode() == null) {
/*  61 */       parent.setLeftNode(addNode);
/*  62 */       if (parent.getSpouseNode() != null) {
/*  63 */         parent.getSpouseNode().setLeftNode(addNode);
/*  64 */         parent.getSpouseNode().setHasChild(true);
/*     */       }
/*  66 */       return;
/*     */     }
/*  68 */     Node temp = parent.getLeftNode();
/*  69 */     while (temp.getRightNode() != null)
/*     */     {
/*  71 */       temp = temp.getRightNode(); }
/*  72 */     temp.setRightNode(addNode);
/*     */   }
/*     */   
/*     */   public void addParentMember(Node child, Node addNode)
/*     */   {
/*  77 */     if (child.getFatherNode() != null)
/*  78 */       return;
/*  79 */     Node temp = this.root;
/*  80 */     while (temp != null) {
/*  81 */       temp.setFatherNode(addNode);
/*  82 */       temp = temp.getRightNode();
/*     */     }
/*  84 */     addNode.setLevel(1);
/*  85 */     addNode.setLeftNode(this.root);
/*  86 */     addNode.setHasChild(true);
/*  87 */     setRootNode(addNode);
/*  88 */     AddLevel(this.root.getLeftNode());
/*     */   }
/*     */   
/*     */   private void AddLevel(Node node) {
/*  92 */     if (node == null) {
/*  93 */       return;
/*     */     }
/*  95 */     node.setLevel(node.getLevel() + 1);
/*  96 */     AddLevel(node.getLeftNode());
/*  97 */     AddLevel(node.getRightNode());
/*     */   }
/*     */   
/*     */ 
/*     */   public void addSiblingMember(Node sibling, Node addNode)
/*     */   {
/* 103 */     addNode.setFatherNode(sibling.getFatherNode());
/* 104 */     addNode.setLevel(sibling.getLevel());
/* 105 */     while (sibling.getRightNode() != null)
/*     */     {
/* 107 */       sibling = sibling.getRightNode(); }
/* 108 */     sibling.setRightNode(addNode);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRootMember(Node addNode)
/*     */   {
/* 114 */     setRootNode(addNode);
/* 115 */     this.root.setFatherNode(null);
/* 116 */     this.root.setLevel(1);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addSpouseMember(Node spouse, Node addSpouse)
/*     */   {
/* 122 */     spouse.setMarried(true);
/* 123 */     addSpouse.setMarried(true);
/* 124 */     addSpouse.setLeftNode(spouse.getLeftNode());
/* 125 */     if (spouse.getHasChild()) {
/* 126 */       addSpouse.setHasChild(true);
/* 127 */       if (spouse.getLeftNode() != null) {
/* 128 */         addSpouse.setLeftNode(spouse.getLeftNode());
/*     */       }
/*     */     }
/* 131 */     spouse.setSpouseNode(addSpouse);
/* 132 */     addSpouse.setSpouseNode(spouse);
/*     */   }
/*     */   
/*     */   public void deleteMember(Node node)
/*     */   {
/* 137 */     if (node == null)
/* 138 */       return;
/* 139 */     if (node == this.root) {
/* 140 */       destroyNodeTree();
/* 141 */       return;
/*     */     }
/* 143 */     if (node.getFatherNode() == null) {
/* 144 */       deleteMemberHelper(node);
/* 145 */       return;
/*     */     }
/* 147 */     Node temp = node.getFatherNode();
/* 148 */     if (temp.getLeftNode() == node) {
/* 149 */       temp.setLeftNode(node.getRightNode());
/*     */     } else {
/* 151 */       temp = temp.getLeftNode();
/* 152 */       while (temp.getRightNode() != node)
/* 153 */         temp = temp.getRightNode();
/* 154 */       temp.setRightNode(node.getRightNode());
/* 155 */       node.setRightNode(null);
/*     */     }
/* 157 */     deleteMemberHelper(node);
/*     */   }
/*     */   
/*     */ 
/*     */   private void deleteMemberHelper(Node node)
/*     */   {
/* 163 */     if (node == null)
/* 164 */       return;
/* 165 */     deleteMemberHelper(node.getLeftNode());
/* 166 */     deleteMemberHelper(node.getRightNode());
/* 167 */     if (node.getSpouseNode() != null)
/*     */     {
/* 169 */       node.setSpouseNode(null);
/*     */     }
/* 171 */     node = null;
/*     */   }
/*     */   
/*     */   public void deleteSpouse(Node node)
/*     */   {
/* 176 */     node.setSpouseNode(null);
/*     */   }
/*     */   
/*     */ 
/*     */   public void modifyMember(Node oldone, Node newone)
/*     */   {
/* 182 */     oldone.setName(newone.getName());
/* 183 */     oldone.setBornplace(newone.getBornplace());
/* 184 */     oldone.setBirthday(newone.getBirthday());
/* 185 */     oldone.setDeathday(newone.getDeathday());
/* 186 */     oldone.setEducation(newone.getEducation());
/* 187 */     oldone.setHasChild(newone.getHasChild());
/* 188 */     oldone.setHeight(newone.getHeight());
/* 189 */     oldone.setJob(newone.getJob());
/* 190 */     oldone.setMarried(newone.getMarried());
/* 191 */     oldone.setSex(newone.getSex());
/* 192 */     oldone.setTop_title(newone.getTop_title());
/* 193 */     oldone.setAddress(newone.getAddress());
/* 194 */     oldone.setTelephone(newone.getTelephone());
/* 195 */     oldone.setIsDead(newone.getIsDead());
/* 196 */     newone = null;
/*     */   }
/*     */   
/*     */   public void saveNodeTree(String AbsolutePath)
/*     */   {
/*     */     try {
/*     */       String AbsolutePathTemp;
///*     */       String AbsolutePathTemp;
/* 204 */       if (AbsolutePath.endsWith(".dat")) {
/* 205 */         AbsolutePathTemp = AbsolutePath;
/*     */       } else {
/* 207 */         AbsolutePathTemp = AbsolutePath + ".dat";
/*     */       }
/* 209 */       File file = new File(AbsolutePathTemp);
/* 210 */       if (!file.exists())
/* 211 */         file.createNewFile();
/* 212 */       FileOutputStream fos = new FileOutputStream(file);
/* 213 */       ObjectOutputStream oos = new ObjectOutputStream(fos);
/* 214 */       saveNodeTreeHelper(this.root, oos);
/* 215 */       oos.flush();
/* 216 */       oos.close();
/*     */     } catch (Exception e) {
/* 218 */       JOptionPane.showMessageDialog(null, "个人信息输入文件时发生错误", "错误提示", 
/* 219 */         0);
/* 220 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private void saveNodeTreeHelper(Node node, ObjectOutputStream oos) throws Exception
/*     */   {
/* 226 */     if (node == null)
/* 227 */       return;
/* 228 */     oos.writeObject(node);
/* 229 */     oos.writeObject(node.getSpouseNode());
/* 230 */     saveNodeTreeHelper(node.getLeftNode(), oos);
/* 231 */     saveNodeTreeHelper(node.getRightNode(), oos);
/*     */   }
/*     */   
/*     */ 
/*     */   public void readNodeTree(String AbsolutePath)
/*     */   {
/*     */     try
/*     */     {
/* 239 */       FileInputStream fis = new FileInputStream(AbsolutePath);
/* 240 */       ObjectInputStream ois = new ObjectInputStream(fis);
/* 241 */       Node temp = (Node)ois.readObject();
/* 242 */       ois.close();
/* 243 */       setRootNode(temp);
/*     */     } catch (Exception e) {
/* 245 */       JOptionPane.showMessageDialog(null, "个人信息文件读取时发生错误", "错误提示", 
/* 246 */         0);
/*     */     }
/*     */   }
/*     */   
/*     */   public void findParent(ArrayList<Node> list, Node node)
/*     */   {
/* 252 */     if (node == null)
/* 253 */       return;
/* 254 */     if (node.getFatherNode() == null)
/* 255 */       return;
/* 256 */     list.add(node.getFatherNode());
/*     */   }
/*     */   
/*     */ 
/*     */   public void findSibling(ArrayList<Node> list, Node node)
/*     */   {
/* 262 */     if (node == null)
/* 263 */       return;
/* 264 */     if (node.getFatherNode() != null) {
/* 265 */       Node temp = node.getFatherNode().getLeftNode();
/* 266 */       if (temp != node)
/* 267 */         list.add(temp);
/* 268 */       while (temp.getRightNode() != null) {
/* 269 */         temp = temp.getRightNode();
/* 270 */         if (temp != node)
/* 271 */           list.add(temp);
/*     */       }
/* 273 */       return;
/*     */     }
/* 275 */     Node temp = this.root;
/* 276 */     while (temp != null) {
/* 277 */       if (temp != node)
/* 278 */         list.add(temp);
/* 279 */       temp = temp.getRightNode();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void findChildren(ArrayList<Node> list, Node node)
/*     */   {
/* 287 */     if (node == null)
/* 288 */       return;
/* 289 */     if (node.getLeftNode() == null)
/* 290 */       return;
/* 291 */     list.add(node.getLeftNode());
/* 292 */     Node temp = node.getLeftNode();
/* 293 */     while (temp.getRightNode() != null) {
/* 294 */       list.add(temp.getRightNode());
/* 295 */       temp = temp.getRightNode();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void findCousin(ArrayList<Node> list, Node node)
/*     */   {
/* 302 */     if (node == null)
/* 303 */       return;
/* 304 */     if (node.getFatherNode() == null)
/* 305 */       return;
/* 306 */     ArrayList<Node> listTemp = new ArrayList();
/* 307 */     findSibling(listTemp, node.getFatherNode());
/* 308 */     Iterator<Node> it = listTemp.iterator();
/* 309 */     while (it.hasNext()) {
/* 310 */       findChildren(list, (Node)it.next());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void findGrandpa(ArrayList<Node> list, Node node)
/*     */   {
/* 317 */     if ((node.getFatherNode() == null) || 
/* 318 */       (node.getFatherNode().getFatherNode() == null))
/* 319 */       return;
/* 320 */     list.add(node.getFatherNode().getFatherNode());
/*     */   }
/*     */   
/*     */ 
/*     */   public void findGrandson(ArrayList<Node> list, Node node)
/*     */   {
/* 326 */     if (node.getLeftNode() == null)
/* 327 */       return;
/* 328 */     ArrayList<Node> listTemp = new ArrayList();
/* 329 */     findChildren(listTemp, node);
/* 330 */     Iterator<Node> it = listTemp.iterator();
/* 331 */     while (it.hasNext()) {
/* 332 */       findChildren(list, (Node)it.next());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void findGreatGrandpa(ArrayList<Node> list, Node node)
/*     */   {
/* 339 */     if ((node.getFatherNode() == null) || 
/* 340 */       (node.getFatherNode().getFatherNode() == null) || 
/* 341 */       (node.getFatherNode().getFatherNode().getFatherNode() == null))
/* 342 */       return;
/* 343 */     list.add(node.getFatherNode().getFatherNode().getFatherNode());
/*     */   }
/*     */   
/*     */ 
/*     */   public void findGreatGrandson(ArrayList<Node> list, Node node)
/*     */   {
/* 349 */     ArrayList<Node> listTemp = new ArrayList();
/* 350 */     findGrandson(listTemp, node);
/* 351 */     Iterator<Node> it = listTemp.iterator();
/* 352 */     while (it.hasNext()) {
/* 353 */       findChildren(list, (Node)it.next());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void findByName(ArrayList<Node> list, Node node, String name)
/*     */   {
/* 360 */     if (node == null)
/* 361 */       return;
/* 362 */     if (node.getName().indexOf(name) != -1)
/* 363 */       list.add(node);
/* 364 */     findByName(list, node.getLeftNode(), name);
/* 365 */     findByName(list, node.getRightNode(), name);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void findByBornplace(ArrayList<Node> list, Node node, String bornplace)
/*     */   {
/* 372 */     if (node == null)
/* 373 */       return;
/* 374 */     if (node.getBornplace().indexOf(bornplace) != -1)
/* 375 */       list.add(node);
/* 376 */     findByBornplace(list, node.getLeftNode(), bornplace);
/* 377 */     findByBornplace(list, node.getRightNode(), bornplace);
/*     */   }
/*     */   
/*     */ 
/*     */   public void findByBirthday(ArrayList<Node> list, Node node, String birthday)
/*     */   {
/* 383 */     if (node == null)
/* 384 */       return;
/* 385 */     if (node.getBirthday().equals(birthday))
/* 386 */       list.add(node);
/* 387 */     findByBirthday(list, node.getLeftNode(), birthday);
/* 388 */     findByBirthday(list, node.getRightNode(), birthday);
/*     */   }
/*     */   
/*     */ 
/*     */   public void findByDeathday(ArrayList<Node> list, Node node, String deathday)
/*     */   {
/* 394 */     if (node == null)
/* 395 */       return;
/* 396 */     if (node.getDeathday().equals(deathday))
/* 397 */       list.add(node);
/* 398 */     findByDeathday(list, node.getLeftNode(), deathday);
/* 399 */     findByDeathday(list, node.getRightNode(), deathday);
/*     */   }
/*     */   
/*     */ 
/*     */   public void findBySex(ArrayList<Node> list, Node node, byte sex)
/*     */   {
/* 405 */     if (node == null)
/* 406 */       return;
/* 407 */     if (node.getSex() == sex)
/* 408 */       list.add(node);
/* 409 */     findBySex(list, node.getLeftNode(), sex);
/* 410 */     findBySex(list, node.getRightNode(), sex);
/*     */   }
/*     */   
/*     */ 
/*     */   public void findByHeight(ArrayList<Node> list, Node node, double height)
/*     */   {
/* 416 */     if (node == null)
/* 417 */       return;
/* 418 */     if (node.getHeight() == height)
/* 419 */       list.add(node);
/* 420 */     findByHeight(list, node.getLeftNode(), height);
/* 421 */     findByHeight(list, node.getRightNode(), height);
/*     */   }
/*     */   
/*     */ 
/*     */   public void findByTelephone(ArrayList<Node> list, Node node, String telephone)
/*     */   {
/* 427 */     if (node == null)
/* 428 */       return;
/* 429 */     if (node.getTelephone().indexOf(telephone) != -1)
/* 430 */       list.add(node);
/* 431 */     findByTelephone(list, node.getLeftNode(), telephone);
/* 432 */     findByTelephone(list, node.getRightNode(), telephone);
/*     */   }
/*     */   
/*     */   public void findByAddress(ArrayList<Node> list, Node node, String address)
/*     */   {
/* 437 */     if (node == null)
/* 438 */       return;
/* 439 */     if (node.getAddress().indexOf(address) != -1)
/* 440 */       list.add(node);
/* 441 */     findByAddress(list, node.getLeftNode(), address);
/* 442 */     findByAddress(list, node.getRightNode(), address);
/*     */   }
/*     */   
/*     */ 
/*     */   public void findByJob(ArrayList<Node> list, Node node, String job)
/*     */   {
/* 448 */     if (node == null)
/* 449 */       return;
/* 450 */     if (node.getJob().indexOf(job) != -1)
/* 451 */       list.add(node);
/* 452 */     findByJob(list, node.getLeftNode(), job);
/* 453 */     findByJob(list, node.getRightNode(), job);
/*     */   }
/*     */   
/*     */ 
/*     */   public void findByEducation(ArrayList<Node> list, Node node, byte education)
/*     */   {
/* 459 */     if (node == null)
/* 460 */       return;
/* 461 */     if (node.getEducation() == education)
/* 462 */       list.add(node);
/* 463 */     findByEducation(list, node.getLeftNode(), education);
/* 464 */     findByEducation(list, node.getRightNode(), education);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void findByTop_title(ArrayList<Node> list, Node node, String top_title)
/*     */   {
/* 471 */     if (node == null)
/* 472 */       return;
/* 473 */     if (node.getTop_title().indexOf(top_title) != -1)
/* 474 */       list.add(node);
/* 475 */     findByTop_title(list, node.getLeftNode(), top_title);
/* 476 */     findByTop_title(list, node.getRightNode(), top_title);
/*     */   }
/*     */   
/*     */   public void findByLevel(ArrayList<Node> list, Node node, int level)
/*     */   {
/* 481 */     if (node == null)
/* 482 */       return;
/* 483 */     if (node.getLevel() == level)
/* 484 */       list.add(node);
/* 485 */     findByLevel(list, node.getLeftNode(), level);
/* 486 */     findByLevel(list, node.getRightNode(), level);
/*     */   }
/*     */   
/*     */ 
/*     */   public void findByMarried(ArrayList<Node> list, Node node, boolean married)
/*     */   {
/* 492 */     if (node == null)
/* 493 */       return;
/* 494 */     if (node.getMarried() == married)
/* 495 */       list.add(node);
/* 496 */     findByMarried(list, node.getLeftNode(), married);
/* 497 */     findByMarried(list, node.getRightNode(), married);
/*     */   }
/*     */   
/*     */ 
/*     */   public void findByIsDead(ArrayList<Node> list, Node node, boolean IsDead)
/*     */   {
/* 503 */     if (node == null)
/* 504 */       return;
/* 505 */     if (node.getIsDead() == IsDead)
/* 506 */       list.add(node);
/* 507 */     findByIsDead(list, node.getLeftNode(), IsDead);
/* 508 */     findByIsDead(list, node.getRightNode(), IsDead);
/*     */   }
/*     */   
/*     */ 
/*     */   public void findByHasChild(ArrayList<Node> list, Node node, boolean hasChild)
/*     */   {
/* 514 */     if (node == null)
/* 515 */       return;
/* 516 */     if (node.getHasChild() == hasChild)
/* 517 */       list.add(node);
/* 518 */     findByHasChild(list, node.getLeftNode(), hasChild);
/* 519 */     findByHasChild(list, node.getRightNode(), hasChild);
/*     */   }
/*     */   
/*     */ 
/*     */   public double AverageHeight(Node node)
/*     */   {
/* 525 */     if (node == null)
/* 526 */       return 0.0D;
/* 527 */     NumberForReference<Double> AllMemberHeight = new NumberForReference(
/* 528 */       Double.valueOf(0.0D));
/* 529 */     NumberForReference<Integer> MemberNumber = new NumberForReference(
/* 530 */       Integer.valueOf(0));
/* 531 */     AverageHeightHelper(node, AllMemberHeight, MemberNumber);
/* 532 */     if (((Integer)MemberNumber.getNumber()).intValue() == 0) {
/* 533 */       return 0.0D;
/*     */     }
/* 535 */     return ((Double)AllMemberHeight.getNumber()).doubleValue() / ((Integer)MemberNumber.getNumber()).intValue();
/*     */   }
/*     */   
/*     */ 
/*     */   public void AverageHeightHelper(Node node, NumberForReference<Double> AllMemberHeight, NumberForReference<Integer> MemberNumber)
/*     */   {
/* 541 */     if (node == null)
/* 542 */       return;
/* 543 */     if (node.getHeight() != 0.0D) {
/* 544 */       AllMemberHeight.setNumber(
/* 545 */         Double.valueOf(((Double)AllMemberHeight.getNumber()).doubleValue() + node.getHeight()));
/* 546 */       MemberNumber.setNumber(Integer.valueOf(((Integer)MemberNumber.getNumber()).intValue() + 1));
/*     */     }
/* 548 */     AverageHeightHelper(node.getLeftNode(), AllMemberHeight, MemberNumber);
/* 549 */     AverageHeightHelper(node.getRightNode(), AllMemberHeight, MemberNumber);
/*     */   }
/*     */   
/*     */ 
/*     */   public int AverageLife(Node node)
/*     */   {
/* 555 */     return DeadMemberLife(node) / AllDeadMember(node);
/*     */   }
/*     */   
/*     */   public int AllDeadMember(Node node)
/*     */   {
/* 560 */     if (node == null)
/* 561 */       return 0;
/* 562 */     if (!node.getIsDead()) {
/* 563 */       return AllDeadMember(node.getLeftNode()) + 
/* 564 */         AllDeadMember(node.getRightNode());
/*     */     }
/* 566 */     return 1 + AllDeadMember(node.getLeftNode()) + 
/* 567 */       AllDeadMember(node.getRightNode());
/*     */   }
/*     */   
/*     */   public int DeadMemberLife(Node node)
/*     */   {
/* 572 */     if (node == null)
/* 573 */       return 0;
/* 574 */     return node.getLife() + DeadMemberLife(node.getLeftNode()) + 
/* 575 */       DeadMemberLife(node.getRightNode());
/*     */   }
/*     */   
/*     */   public String AverageEducation(Node node)
/*     */   {
/* 580 */     if (node == null)
/* 581 */       return "没上学";
/* 582 */     return new Node().educationToString(AverageEdacationHelper(node) / 
/* 583 */       FamilyMember(node));
/*     */   }
/*     */   
/*     */   private int AverageEdacationHelper(Node node)
/*     */   {
/* 588 */     if (node == null)
/* 589 */       return 0;
/* 590 */     if (node.getSpouseNode() != null) {
/* 591 */       return node.getEducation() + node.getSpouseNode().getEducation() + 
/* 592 */         AverageEdacationHelper(node.getLeftNode()) + AverageEdacationHelper(node
/* 593 */         .getRightNode());
/*     */     }
/* 595 */     return node.getEducation() + 
/* 596 */       AverageEdacationHelper(node.getLeftNode()) + AverageEdacationHelper(node
/* 597 */       .getRightNode());
/*     */   }
/*     */   
/*     */   public int AllMarriedOrHasChildMale(Node node)
/*     */   {
/* 602 */     if (node == null)
/* 603 */       return 0;
/* 604 */     if (node.getSex() == 1)
/* 605 */       return AllMarriedOrHasChildMale(node.getRightNode());
/* 606 */     if ((!node.getMarried()) && (!node.getHasChild()))
/* 607 */       return AllMarriedOrHasChildMale(node.getRightNode());
/* 608 */     if ((node.getMarried()) || (node.getHasChild())) {
/* 609 */       return 1 + AllMarriedOrHasChildMale(node.getLeftNode()) + 
/* 610 */         AllMarriedOrHasChildMale(node.getRightNode());
/*     */     }
/* 612 */     return 0;
/*     */   }
/*     */   
/*     */   public String TopestEducation(Node node)
/*     */   {
/* 617 */     if (node == null)
/* 618 */       return "没上学";
/* 619 */     NumberForReference<Byte> number = new NumberForReference(Byte.valueOf((byte)0));
/* 620 */     TopestEducationHelper(node, number);
/* 621 */     return new Node().educationToString(((Byte)number.getNumber()).byteValue());
/*     */   }
/*     */   
/*     */   private void TopestEducationHelper(Node node, NumberForReference<Byte> number)
/*     */   {
/* 626 */     if (node == null)
/* 627 */       return;
/* 628 */     if (((Byte)number.getNumber()).byteValue() < node.getEducation())
/* 629 */       number.setNumber(Byte.valueOf(node.getEducation()));
/* 630 */     TopestEducationHelper(node.getLeftNode(), number);
/* 631 */     TopestEducationHelper(node.getRightNode(), number);
/*     */   }
/*     */   
/*     */ 
/*     */   private void LowestEducationHelper(Node node, NumberForReference<Byte> number)
/*     */   {
/* 637 */     if (node == null)
/* 638 */       return;
/* 639 */     if (((Byte)number.getNumber()).byteValue() > node.getEducation())
/* 640 */       number.setNumber(Byte.valueOf(node.getEducation()));
/* 641 */     LowestEducationHelper(node.getLeftNode(), number);
/* 642 */     LowestEducationHelper(node.getRightNode(), number);
/*     */   }
/*     */   
/*     */ 
/*     */   public String LowestEducation(Node node)
/*     */   {
/* 648 */     if (node == null)
/* 649 */       return "没上学";
/* 650 */     NumberForReference<Byte> number = new NumberForReference(Byte.valueOf((byte)8));
/* 651 */     LowestEducationHelper(node, number);
/* 652 */     return new Node().educationToString(((Byte)number.getNumber()).byteValue());
/*     */   }
/*     */   
/*     */   public String MalePercentage(Node node)
/*     */   {
/* 657 */     double male = getMale(node) * 1.0D;
/* 658 */     double member = getMember(node) * 1.0D;
/* 659 */     DecimalFormat percentage = new DecimalFormat("#0.00%");
/* 660 */     return percentage.format(male / member);
/*     */   }
/*     */   
/*     */   public String FemalePercentage(Node node) {
/* 664 */     double female = getFemale(node) * 1.0D;
/* 665 */     double member = getMember(node) * 1.0D;
/* 666 */     DecimalFormat percentage = new DecimalFormat("#0.00%");
/* 667 */     return percentage.format(female / member);
/*     */   }
/*     */   
/*     */   public int getMale(Node node)
/*     */   {
/* 672 */     if (node == null)
/* 673 */       return 0;
/* 674 */     if (node.getSex() == 1)
/* 675 */       return 0 + getMale(node.getLeftNode()) + 
/* 676 */         getMale(node.getRightNode());
/* 677 */     return 1 + getMale(node.getLeftNode()) + getMale(node.getRightNode());
/*     */   }
/*     */   
/*     */   public int getFemale(Node node)
/*     */   {
/* 682 */     return getMember(node) - getMale(node);
/*     */   }
/*     */   
/*     */   public int getMember(Node node)
/*     */   {
/* 687 */     if (node == null)
/* 688 */       return 0;
/* 689 */     return 1 + getMember(node.getLeftNode()) + 
/* 690 */       getMember(node.getRightNode());
/*     */   }
/*     */   
/*     */   public int FamilyMember(Node node)
/*     */   {
/* 695 */     NumberForReference<Integer> number = new NumberForReference(Integer.valueOf(0));
/* 696 */     FamilyMemberHelper(node, number);
/* 697 */     return ((Integer)number.getNumber()).intValue();
/*     */   }
/*     */   
/*     */   public double AverageFamilyMember(Node node)
/*     */   {
/* 702 */     int numberTemp = AllMarriedOrHasChildMale(node);
/*     */     double number;
/* 704 */     if (numberTemp == 0)
/*     */     {
/* 706 */       number = FamilyMember(node) * 1.0D;
/*     */     }
/*     */     else
/*     */     {
/* 710 */       number = FamilyMember(node) / numberTemp;
/*     */     }
/* 712 */     DecimalFormat df = new DecimalFormat("#.00");
/* 713 */    number = Double.parseDouble(df.format(number));
/* 714 */     return number;
/*     */   }
/*     */   
/*     */   private void FamilyMemberHelper(Node node, NumberForReference<Integer> number)
/*     */   {
/* 719 */     if (node == null)
/* 720 */       return;
/* 721 */     if (node.getMarried()) {
/* 722 */       number.setNumber(Integer.valueOf(((Integer)number.getNumber()).intValue() + 2));
/*     */     } else
/* 724 */       number.setNumber(Integer.valueOf(((Integer)number.getNumber()).intValue() + 1));
/* 725 */     FamilyMemberHelper(node.getLeftNode(), number);
/* 726 */     FamilyMemberHelper(node.getRightNode(), number);
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\tree\NodeTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */