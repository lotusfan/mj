package com.mjapp.model;

import java.sql.Timestamp;

public class ActivityGroupTb extends ParentModel{

	private Integer id; //
	private Integer joinUserId; //活动参加者Id
	private Integer createUserId; //活动创建者ID
	private Integer activityId; //活动Id
	private Timestamp createTime; //
	private Integer deleteFlag; //
	private Timestamp updateTime; //

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getJoinUserId() {
		return joinUserId;
	}
	public void setJoinUserId (Integer joinUserId) {
		this.joinUserId = joinUserId;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId (Integer createUserId) {
		this.createUserId = createUserId;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId (Integer activityId) {
		this.activityId = activityId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag (Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime (Timestamp updateTime) {
		this.updateTime = updateTime;
	}

    @Override
    public String toString() {
        return "ActivityGroupTb{" +
            "\nid=" + id +
            "\njoinUserId=" + joinUserId +
            "\ncreateUserId=" + createUserId +
            "\nactivityId=" + activityId +
            "\ncreateTime=" + createTime +
            "\ndeleteFlag=" + deleteFlag +
            "\nupdateTime=" + updateTime +
            '}';
    }
}