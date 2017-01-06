package com.mjapp.model;

import java.sql.Timestamp;

public class UserTb extends ParentModel{

	private Integer id; //
	private String loginName; //登录名
	private String password; //密码
	private String realName; //真实姓名
	private String cardNum; //身份证号
	private String signature; //个性签名
	private String nickName; //昵称
	private Integer sex; //性别
	private Integer age; //年龄
	private String city; //城市
	private String school; //毕业学校
	private String job; //工作
	private String jobTrade; //工作所在的行业
	private String headPic; //头像pic地址
	private String backgroundPic; //个人主面背景图片
	private Integer authentication; //是否已认证1为未认证2为已认证
	private Integer mjCode; //mj 号
	private Timestamp createTime; //
	private Timestamp updateTime; //

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName (String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword (String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName (String realName) {
		this.realName = realName;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum (String cardNum) {
		this.cardNum = cardNum;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature (String signature) {
		this.signature = signature;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName (String nickName) {
		this.nickName = nickName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex (Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge (Integer age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity (String city) {
		this.city = city;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool (String school) {
		this.school = school;
	}
	public String getJob() {
		return job;
	}
	public void setJob (String job) {
		this.job = job;
	}
	public String getJobTrade() {
		return jobTrade;
	}
	public void setJobTrade (String jobTrade) {
		this.jobTrade = jobTrade;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic (String headPic) {
		this.headPic = headPic;
	}
	public String getBackgroundPic() {
		return backgroundPic;
	}
	public void setBackgroundPic (String backgroundPic) {
		this.backgroundPic = backgroundPic;
	}
	public Integer getAuthentication() {
		return authentication;
	}
	public void setAuthentication (Integer authentication) {
		this.authentication = authentication;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime (Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getMjCode() {
		return mjCode;
	}

	public void setMjCode(Integer mjCode) {
		this.mjCode = mjCode;
	}

	@Override
    public String toString() {
        return "UserTb{" +
            "\nid=" + id +
            "\nloginName=" + loginName +
            "\npassword=" + password +
            "\nrealName=" + realName +
            "\ncardNum=" + cardNum +
            "\nsignature=" + signature +
            "\nnickName=" + nickName +
            "\nsex=" + sex +
            "\nage=" + age +
            "\ncity=" + city +
            "\nschool=" + school +
            "\njob=" + job +
            "\njobTrade=" + jobTrade +
            "\nheadPic=" + headPic +
            "\nbackgroundPic=" + backgroundPic +
            "\nauthentication=" + authentication +
            "\ncreateTime=" + createTime +
            "\nupdateTime=" + updateTime +
            "\nmjCode=" + mjCode +
            '}';
    }
}