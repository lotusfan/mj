package com.mjapp.model;

import java.sql.Timestamp;

public class CollectTb extends ParentModel{

	private Integer id; //
	private Integer collectUserId; //收藏者Id
	private Integer collectActivityId; //收藏活动ID
	private Integer deleteFlag; //
	private Timestamp createTime; //
	private Timestamp updateTime; //

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getCollectUserId() {
		return collectUserId;
	}
	public void setCollectUserId (Integer collectUserId) {
		this.collectUserId = collectUserId;
	}
	public Integer getCollectActivityId() {
		return collectActivityId;
	}
	public void setCollectActivityId (Integer collectActivityId) {
		this.collectActivityId = collectActivityId;
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
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime (Timestamp updateTime) {
		this.updateTime = updateTime;
	}

    @Override
    public String toString() {
        return "CollectTb{" +
            "\nid=" + id +
            "\ncollectUserId=" + collectUserId +
            "\ncollectActivityId=" + collectActivityId +
            "\ndeleteFlag=" + deleteFlag +
            "\ncreateTime=" + createTime +
            "\nupdateTime=" + updateTime +
            '}';
    }
}