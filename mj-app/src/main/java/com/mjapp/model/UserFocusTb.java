package com.mjapp.model;

import java.sql.Timestamp;

public class UserFocusTb extends ParentModel{

	private Integer id; //
	private Integer activeUserId; //主动点击关注者
	private Integer passiveUserId; //被关注者
	private Integer deleteFlag; //是否删除1为未删除2为已删除
	private Timestamp createTime; //

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getActiveUserId() {
		return activeUserId;
	}
	public void setActiveUserId (Integer activeUserId) {
		this.activeUserId = activeUserId;
	}
	public Integer getPassiveUserId() {
		return passiveUserId;
	}
	public void setPassiveUserId (Integer passiveUserId) {
		this.passiveUserId = passiveUserId;
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

    @Override
    public String toString() {
        return "UserFocusTb{" +
            "\nid=" + id +
            "\nactiveUserId=" + activeUserId +
            "\npassiveUserId=" + passiveUserId +
            "\ndeleteFlag=" + deleteFlag +
            "\ncreateTime=" + createTime +
            '}';
    }
}