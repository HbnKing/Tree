package com.ecjtu.demo.entity;


/**
 * @author wangheng
 * @date 2019-04-02 下午2:15
 * @description
 * 人类的 具体模型属性 
 * 
 *
 * */
public class Node  {

    private static final long serialVersionUID = 4229304909895477970L;
    /**
     * 家谱编号
     */
    private String familyID ;

    /**
     * 微信用户唯一标识
     */

    private String wxID ;

    /**
     * 人物姓名
     */
    private String name;
    /**
     * 出生地
     */
    private String bornplace;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 去世时间
     */
    private String deathday;
    /**
     * 第几代
     */
    private int level;
    /**
     * 性别
     */
    private byte sex;
    /**
     * 身高
     */
    private double height;
    /**
     * 工作
     */
    private String job;
    /**
     * 教育程度
     */
    private byte education;
    /**
     * 最高职称
     */
    private String top_title;
    /**
     * 是否死亡
     */
    private boolean isDead;
    /**
     * 是否已经结婚
     */
    private boolean married;
    /**
     * 是否有小孩
     */
    private boolean hasChild;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 住址
     */
    private String address;
    /**
     * 与 该 Node  相关的人员
     * 孩子
     */
    Node leftNode;
    /**
     * 兄弟
     */
    Node rightNode;
    /**
     * 妻子
     */
    Node spouseNode;
    /**
     * 父亲
     */
    Node fatherNode;

    /**
     * 母亲
     */
    Node motherNode;
    
    
    
}
