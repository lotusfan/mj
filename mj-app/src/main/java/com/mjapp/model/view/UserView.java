package com.mjapp.model.view;

import java.sql.Timestamp;

/**
 * @title: UserView
 * @description: 用户展示基本信息
 * @author: zhangfan
 * @data: 2016年10月23日 16:54
 */
public class UserView {

    private Integer id;
    private String nickName;
    private Integer sex;
    private Integer age;
    private String headPic;
    private Integer authentication;
    private Integer mjCode;
    private Integer focusFlag; // 1为已关注  2为未关注
    private Integer focusedNum; //关注数
    private Integer fansNum; //粉丝数
    private String backgroundPic; //用户背景图片
    private String signature; //个性签名


    private Timestamp relevanceCreateTime; //查询所对应的时间,如返回评论UserView则为评论的创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    public Integer getMjCode() {
        return mjCode;
    }

    public void setMjCode(Integer mjCode) {
        this.mjCode = mjCode;
    }

    public Timestamp getRelevanceCreateTime() {
        return relevanceCreateTime;
    }

    public void setRelevanceCreateTime(Timestamp relevanceCreateTime) {
        this.relevanceCreateTime = relevanceCreateTime;
    }

    public Integer getFocusFlag() {
        return focusFlag;
    }

    public void setFocusFlag(Integer focusFlag) {
        this.focusFlag = focusFlag;
    }


    public Integer getFocusedNum() {
        return focusedNum;
    }

    public void setFocusedNum(Integer focusedNum) {
        this.focusedNum = focusedNum;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public String getBackgroundPic() {
        return backgroundPic;
    }

    public void setBackgroundPic(String backgroundPic) {
        this.backgroundPic = backgroundPic;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "UserView{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", headPic='" + headPic + '\'' +
                ", authentication=" + authentication +
                ", mjCode=" + mjCode +
                ", focusFlag=" + focusFlag +
                ", focusedNum=" + focusedNum +
                ", fansNum=" + fansNum +
                ", backgroundPic='" + backgroundPic + '\'' +
                ", signature='" + signature + '\'' +
                ", relevanceCreateTime=" + relevanceCreateTime +
                '}';
    }
}
