package com.mjapp.model;

import java.sql.Timestamp;

public class StoreTb extends ParentModel{

	private Integer id; //
	private String position1; // 商圈
	private String position2; // 店铺地址
	private String name; //商家名称
	private String type; //店铺类型
	private String position3; //
	private String startTime; //营业时间
	private String endTime; //营业结束时间
	private String general; //概况
	private String recommend; //推荐内容
	private String picJson; //相册
	private String headPic; //顶图
	private Timestamp createTime; //
	private Timestamp updateTime; //


	private GoodsTb goodsTb;   //1.0版本 商家只对应一种商品

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public String getPosition1() {
		return position1;
	}
	public void setPosition1 (String position1) {
		this.position1 = position1;
	}
	public String getPosition2() {
		return position2;
	}
	public void setPosition2 (String position2) {
		this.position2 = position2;
	}
	public String getName() {
		return name;
	}
	public void setName (String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType (String type) {
		this.type = type;
	}
	public String getPosition3() {
		return position3;
	}
	public void setPosition3 (String position3) {
		this.position3 = position3;
	}
	public String getGeneral() {
		return general;
	}
	public void setGeneral (String general) {
		this.general = general;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend (String recommend) {
		this.recommend = recommend;
	}
	public String getPicJson() {
		return picJson;
	}
	public void setPicJson (String picJson) {
		this.picJson = picJson;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic (String headPic) {
		this.headPic = headPic;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public GoodsTb getGoodsTb() {
		return goodsTb;
	}

	public void setGoodsTb(GoodsTb goodsTb) {
		this.goodsTb = goodsTb;
	}

	@Override
	public String toString() {
		return "StoreTb{" +
				"id=" + id +
				", position1='" + position1 + '\'' +
				", position2='" + position2 + '\'' +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", position3='" + position3 + '\'' +
				", startTime='" + startTime + '\'' +
				", endTime='" + endTime + '\'' +
				", general='" + general + '\'' +
				", recommend='" + recommend + '\'' +
				", picJson='" + picJson + '\'' +
				", headPic='" + headPic + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", goodsTb=" + goodsTb +
				'}';
	}
}