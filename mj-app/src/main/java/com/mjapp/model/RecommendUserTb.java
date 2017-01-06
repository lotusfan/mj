package com.mjapp.model;

import java.sql.Timestamp;

public class RecommendUserTb extends ParentModel{

	private Integer id; //
	private Integer userId; //推荐用户Id
	private Integer deleteFlag; //
	private Timestamp createTime; //
	private Integer sort; //排序
	private Integer sex;

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId (Integer userId) {
		this.userId = userId;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag (Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort (Integer sort) {
		this.sort = sort;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "RecommendUserTb{" +
				"id=" + id +
				", userId=" + userId +
				", deleteFlag=" + deleteFlag +
				", createTime=" + createTime +
				", sort=" + sort +
				", sex=" + sex +
				'}';
	}
}