/*     */ package com.William_Lin.node;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Node
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 4229304909895477970L;
/*     */   private String name;
/*     */   private String bornplace;
/*     */   private String birthday;
/*     */   private String deathday;
/*     */   private int level;
/*     */   private byte sex;
/*     */   private double height;
/*     */   private String job;
/*     */   private byte education;
/*     */   private String top_title;
/*     */   private boolean isDead;
/*     */   private boolean married;
/*     */   private boolean hasChild;
/*     */   private String telephone;
/*     */   private String address;
/*     */   Node leftNode;
/*     */   Node rightNode;
/*     */   Node spouseNode;
/*     */   Node fatherNode;
/*     */   
/*     */   public void setLevel(int level)
/*     */   {
/*  62 */     this.level = level;
/*     */   }
/*     */   
/*     */   public int getLevel() {
/*  66 */     return this.level;
/*     */   }
/*     */   
/*     */   public String getTelephone() {
/*  70 */     return this.telephone;
/*     */   }
/*     */   
/*     */   public void setTelephone(String telephone) {
/*  74 */     this.telephone = telephone;
/*     */   }
/*     */   
/*     */   public String getAddress() {
/*  78 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/*  82 */     this.address = address;
/*     */   }
/*     */   
/*     */   public Node getLeftNode() {
/*  86 */     return this.leftNode;
/*     */   }
/*     */   
/*     */   public void setLeftNode(Node node) {
/*  90 */     this.leftNode = node;
/*     */   }
/*     */   
/*     */   public void setRightNode(Node node)
/*     */   {
/*  95 */     this.rightNode = node;
/*     */   }
/*     */   
/*     */   public Node getRightNode()
/*     */   {
/* 100 */     return this.rightNode;
/*     */   }
/*     */   
/*     */   public Node getSpouseNode() {
/* 104 */     return this.spouseNode;
/*     */   }
/*     */   
/*     */   public void setSpouseNode(Node node) {
/* 108 */     this.spouseNode = node;
/*     */   }
/*     */   
/*     */   public Node getFatherNode() {
/* 112 */     return this.fatherNode;
/*     */   }
/*     */   
/*     */   public void setFatherNode(Node node) {
/* 116 */     this.fatherNode = node;
/*     */   }
/*     */   
/*     */   public void setIsDead(boolean isDead) {
/* 120 */     this.isDead = isDead;
/*     */   }
/*     */   
/*     */   public boolean getIsDead() {
/* 124 */     return this.isDead;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 128 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 132 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setBornplace(String bornplace) {
/* 136 */     this.bornplace = bornplace;
/*     */   }
/*     */   
/*     */   public String getBornplace() {
/* 140 */     return this.bornplace;
/*     */   }
/*     */   
/*     */   public void setBirthday(String birthday) {
/* 144 */     this.birthday = birthday;
/*     */   }
/*     */   
/*     */   public String getBirthday() {
/* 148 */     return this.birthday;
/*     */   }
/*     */   
/*     */   public void setDeathday(String deathday) {
/* 152 */     this.deathday = deathday;
/*     */   }
/*     */   
/*     */   public String getDeathday() {
/* 156 */     return this.deathday;
/*     */   }
/*     */   
/*     */   public void setSex(byte sex) {
/* 160 */     this.sex = sex;
/*     */   }
/*     */   
/*     */   public byte getSex() {
/* 164 */     return this.sex;
/*     */   }
/*     */   
/*     */   public void setHeight(double height) {
/* 168 */     this.height = height;
/*     */   }
/*     */   
/*     */   public double getHeight() {
/* 172 */     return this.height;
/*     */   }
/*     */   
/*     */   public void setJob(String job) {
/* 176 */     this.job = job;
/*     */   }
/*     */   
/*     */   public String getJob() {
/* 180 */     return this.job;
/*     */   }
/*     */   
/*     */   public void setEducation(byte education) {
/* 184 */     this.education = education;
/*     */   }
/*     */   
/*     */   public byte getEducation() {
/* 188 */     return this.education;
/*     */   }
/*     */   
/*     */   public void setTop_title(String top_title) {
/* 192 */     this.top_title = top_title;
/*     */   }
/*     */   
/*     */   public String getTop_title() {
/* 196 */     return this.top_title;
/*     */   }
/*     */   
/*     */   public void setMarried(boolean married) {
/* 200 */     this.married = married;
/*     */   }
/*     */   
/*     */   public boolean getMarried() {
/* 204 */     return this.married;
/*     */   }
/*     */   
/*     */   public void setHasChild(boolean hasChild) {
/* 208 */     this.hasChild = hasChild;
/*     */   }
/*     */   
/*     */   public boolean getHasChild() {
/* 212 */     return this.hasChild;
/*     */   }
/*     */   
/*     */   public int getLife() {
/* 216 */     if (!getIsDead())
/* 217 */       return 0;
/* 218 */     String[] birthdayString = this.birthday.split("-");
/* 219 */     String[] deathdayString = this.deathday.split("-");
/*     */     
/* 221 */     if (Integer.parseInt(deathdayString[1]) > Integer.parseInt(birthdayString[1])) {
/* 222 */       return Integer.parseInt(deathdayString[0]) - 
/* 223 */         Integer.parseInt(birthdayString[0]);
/*     */     }
/* 225 */     if (Integer.parseInt(deathdayString[1]) < Integer.parseInt(birthdayString[1])) {
/* 226 */       return Integer.parseInt(deathdayString[0]) - 
/* 227 */         Integer.parseInt(birthdayString[0]) - 1;
/*     */     }
/* 229 */     if (Integer.parseInt(deathdayString[2]) >= Integer.parseInt(birthdayString[2])) {
/* 230 */       return Integer.parseInt(deathdayString[0]) - 
/* 231 */         Integer.parseInt(birthdayString[0]);
/*     */     }
/* 233 */     return Integer.parseInt(deathdayString[0]) - 
/* 234 */       Integer.parseInt(birthdayString[0]) - 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Node(String name, String bornplace, String birthday, String deathday, byte sex, boolean isDead, String job, String telephone, String top_title, String address, double height, byte education, boolean married, boolean hasChild)
/*     */   {
/* 242 */     this.name = name;
/* 243 */     this.bornplace = bornplace;
/* 244 */     this.birthday = birthday;
/* 245 */     this.deathday = deathday;
/* 246 */     this.sex = sex;
/* 247 */     this.isDead = isDead;
/* 248 */     this.job = job;
/* 249 */     this.telephone = telephone;
/* 250 */     this.top_title = top_title;
/* 251 */     this.address = address;
/* 252 */     this.height = height;
/* 253 */     this.education = education;
/* 254 */     this.married = married;
/* 255 */     this.hasChild = hasChild;
/* 256 */     this.level = 0;
/* 257 */     this.leftNode = null;
/* 258 */     this.rightNode = null;
/* 259 */     this.spouseNode = null;
/* 260 */     this.fatherNode = null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Node(String name, String bornplace, String birthday, String deathday, byte sex, boolean isDead, String job, String telephone, String top_title, String address, double height, byte education, boolean married, boolean hasChild, int level, Node leftNode, Node rightNode, Node spouseNode, Node fatherNode)
/*     */   {
/* 268 */     this.name = name;
/* 269 */     this.bornplace = bornplace;
/* 270 */     this.birthday = birthday;
/* 271 */     this.deathday = deathday;
/* 272 */     this.sex = sex;
/* 273 */     this.isDead = isDead;
/* 274 */     this.job = job;
/* 275 */     this.telephone = telephone;
/* 276 */     this.top_title = top_title;
/* 277 */     this.address = address;
/* 278 */     this.height = height;
/* 279 */     this.education = education;
/* 280 */     this.married = married;
/* 281 */     this.hasChild = hasChild;
/* 282 */     this.level = 0;
/* 283 */     this.leftNode = leftNode;
/* 284 */     this.rightNode = rightNode;
/* 285 */     this.spouseNode = spouseNode;
/* 286 */     this.fatherNode = fatherNode;
/*     */   }
/*     */   
/*     */   public Node() {
/* 290 */     this.name = "";
/* 291 */     this.bornplace = "";
/* 292 */     this.birthday = "";
/* 293 */     this.deathday = "";
/* 294 */     this.sex = 0;
/* 295 */     this.isDead = false;
/* 296 */     this.level = 0;
/* 297 */     this.height = 0.0D;
/* 298 */     this.job = "null";
/* 299 */     this.education = 0;
/* 300 */     this.top_title = "";
/* 301 */     this.telephone = "";
/* 302 */     this.address = "";
/* 303 */     this.married = false;
/* 304 */     this.hasChild = false;
/* 305 */     this.leftNode = null;
/* 306 */     this.rightNode = null;
/* 307 */     this.spouseNode = null;
/* 308 */     this.fatherNode = null;
/*     */   }
/*     */   
/*     */   public String educationToString(int education) {
/* 312 */     if (education == 0)
/* 313 */       return "没上学";
/* 314 */     if (education == 1)
/* 315 */       return "小学";
/* 316 */     if (education == 2)
/* 317 */       return "初中";
/* 318 */     if (education == 3)
/* 319 */       return "高中";
/* 320 */     if (education == 4)
/* 321 */       return "大学专科";
/* 322 */     if (education == 5)
/* 323 */       return "大学本科";
/* 324 */     if (education == 6)
/* 325 */       return "硕士";
/* 326 */     if (education == 7) {
/* 327 */       return "博士";
/*     */     }
/* 329 */     return "博士以上";
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 334 */     String sexTemp = "男";
/* 335 */     if (this.sex == 1)
/* 336 */       sexTemp = "女";
/* 337 */     return this.name + "       " + sexTemp + "       (第  " + this.level + " 代)";
/*     */   }
/*     */   
/*     */   public String toString1()
/*     */   {
/* 342 */     String sexTemp = "男";
/* 343 */     if (this.sex == 1)
/* 344 */       sexTemp = "女";
/* 345 */     String isDeadTemp = "是";
/* 346 */     if (!this.isDead) {
/* 347 */       isDeadTemp = "否";
/*     */     }
/* 349 */     String marriedTemp = "已婚";
/* 350 */     if (!this.married) {
/* 351 */       marriedTemp = "未婚";
/*     */     }
/* 353 */     String hasChildTemp = "是";
/* 354 */     if (!this.hasChild) {
/* 355 */       hasChildTemp = "否";
/*     */     }
/* 357 */     return 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 362 */       "姓名：" + this.name + "\n出生地：" + this.bornplace + "\n性别：" + sexTemp + "\n出生日期：" + this.birthday + "\n是否死亡：" + isDeadTemp + "\n死亡日期：" + this.deathday + "\n工作：" + this.job + "\n最高职称：" + this.top_title + "\n电话号码：" + this.telephone + "\n住址：" + this.address + "\n身高：" + this.height + "米\n学历程度：" + educationToString(this.education) + "\n婚姻状况：" + marriedTemp + "\n是否有孩子：" + hasChildTemp + "\n第几代：" + this.level;
/*     */   }
/*     */   
/*     */   public String toString2()
/*     */   {
/* 367 */     String sexTemp = "男";
/* 368 */     if (this.sex == 1)
/* 369 */       sexTemp = "女";
/* 370 */     String isDeadTemp = "是";
/* 371 */     if (!this.isDead) {
/* 372 */       isDeadTemp = "否";
/*     */     }
/* 374 */     String marriedTemp = "已婚";
/* 375 */     if (!this.married) {
/* 376 */       marriedTemp = "未婚";
/*     */     }
/* 378 */     String hasChildTemp = "是";
/* 379 */     if (!this.hasChild) {
/* 380 */       hasChildTemp = "否";
/*     */     }
/* 382 */     return 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 387 */       "姓名：" + this.name + "\n出生地：" + this.bornplace + "\n性别：" + sexTemp + "\n出生日期：" + this.birthday + "\n是否死亡：" + isDeadTemp + "\n死亡日期：" + this.deathday + "\n工作：" + this.job + "\n最高职称：" + this.top_title + "\n电话号码：" + this.telephone + "\n住址：" + this.address + "\n身高：" + this.height + "米\n学历程度：" + educationToString(this.education) + "\n婚姻状况：" + marriedTemp + "\n是否有孩子：" + hasChildTemp;
/*     */   }
/*     */ }


/* Location:              C:\Users\90595\Downloads\家谱管理系统.jar!\com\William_Lin\node\Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */