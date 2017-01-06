package com.mjapp.model;

import java.sql.Timestamp;

public class ActivityQrcodeTb extends ParentModel{

	private Integer id; //
	private Integer activityId; //
	private String qrcodeUrl; //
	private String activityMd5; //
	private Integer deleteFlag; //
	private Timestamp createTime; //

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
	public String getQrcodeUrl() {
		return qrcodeUrl;
	}
	public void setQrcodeUrl (String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}
	public String getActivityMd5() {
		return activityMd5;
	}
	public void setActivityMd5 (String activityMd5) {
		this.activityMd5 = activityMd5;
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
        return "ActivityQrcodeTb{" +
            "\nid=" + id +
            "\nactivityId=" + activityId +
            "\nqrcodeUrl=" + qrcodeUrl +
            "\nactivityMd5=" + activityMd5 +
            "\ndeleteFlag=" + deleteFlag +
            "\ncreateTime=" + createTime +
            '}';
    }
}