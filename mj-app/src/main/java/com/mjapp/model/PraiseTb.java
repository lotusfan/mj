package com.mjapp.model;

import com.mjapp.model.view.UserView;

import java.sql.Timestamp;

public class PraiseTb extends ParentModel{

	private Integer id; //
	private Integer userId; //点赞者ID
	private Integer userNewsId; //动态发布者ID
	private Integer deleteFlag; //
	private Integer newsId; //用户发布动态的ID
	private Timestamp createTime; //
	private Timestamp updateTime; //

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
	public Integer getUserNewsId() {
		return userNewsId;
	}
	public void setUserNewsId (Integer userNewsId) {
		this.userNewsId = userNewsId;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag (Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId (Integer newsId) {
		this.newsId = newsId;
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
        return "PraiseTb{" +
            "\nid=" + id +
            "\nuserId=" + userId +
            "\nuserNewsId=" + userNewsId +
            "\ndeleteFlag=" + deleteFlag +
            "\nnewsId=" + newsId +
            "\ncreateTime=" + createTime +
            "\nupdateTime=" + updateTime +
            '}';
    }
}