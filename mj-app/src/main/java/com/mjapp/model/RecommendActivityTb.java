package com.mjapp.model;

import java.sql.Timestamp;

public class RecommendActivityTb extends ParentModel{

	private Integer id; //
	private Integer activityId; //推荐活动Id
	private Integer deleteFlag; //
	private Timestamp createTime; //
	private Integer sort; //排序

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId (Integer activityId) {
		this.activityId = activityId;
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

    @Override
    public String toString() {
        return "RecommendActivityTb{" +
            "\nid=" + id +
            "\nactivityId=" + activityId +
            "\ndeleteFlag=" + deleteFlag +
            "\ncreateTime=" + createTime +
            "\nsort=" + sort +
            '}';
    }
}