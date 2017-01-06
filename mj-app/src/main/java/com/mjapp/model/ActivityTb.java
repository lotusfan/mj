package com.mjapp.model;

import com.mjapp.model.view.UserView;

import java.sql.Timestamp;
import java.util.List;

public class ActivityTb extends ParentModel{

	private Integer id; //
	private String name; //活动名称
	private String place; //活动地点
	private String detail; //活动详情
	private Integer createUserId; //创建者ID
	private String time; //活动时间
	private String storeJson; //选择的商家
	private String headPic; //活动顶图
	private Integer deleteFlag; //
	private Integer status; //活动状态
	private String qrcode; //二维码
	private Timestamp createTime; //
	private Timestamp deadline; //报名截止时间
	private Integer peopleNum; //活动人数

	//非数据库字段
	private UserView userView;
	private List<UserView> members;
	private List<StoreTb> storeTbs;

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName (String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace (String place) {
		this.place = place;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail (String detail) {
		this.detail = detail;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId (Integer createUserId) {
		this.createUserId = createUserId;
	}
	public String getTime() {
		return time;
	}
	public void setTime (String time) {
		this.time = time;
	}
	public String getStoreJson() {
		return storeJson;
	}
	public void setStoreJson (String storeJson) {
		this.storeJson = storeJson;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic (String headPic) {
		this.headPic = headPic;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag (Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus (Integer status) {
		this.status = status;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode (String qrcode) {
		this.qrcode = qrcode;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getDeadline() {
		return deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

	public UserView getUserView() {
		return userView;
	}

	public void setUserView(UserView userView) {
		this.userView = userView;
	}

	public List<UserView> getMembers() {
		return members;
	}

	public void setMembers(List<UserView> members) {
		this.members = members;
	}

	public List<StoreTb> getStoreTbs() {
		return storeTbs;
	}

	public void setStoreTbs(List<StoreTb> storeTbs) {
		this.storeTbs = storeTbs;
	}

	@Override
	public String toString() {
		return "ActivityTb{" +
				"id=" + id +
				", name='" + name + '\'' +
				", place='" + place + '\'' +
				", detail='" + detail + '\'' +
				", createUserId=" + createUserId +
				", time='" + time + '\'' +
				", storeJson='" + storeJson + '\'' +
				", headPic='" + headPic + '\'' +
				", deleteFlag=" + deleteFlag +
				", status=" + status +
				", qrcode='" + qrcode + '\'' +
				", createTime=" + createTime +
				", deadline=" + deadline +
				", peopleNum=" + peopleNum +
				", userView=" + userView +
				", members=" + members +
				", storeTbs=" + storeTbs +
				'}';
	}
}