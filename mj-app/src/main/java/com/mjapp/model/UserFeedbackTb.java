package com.mjapp.model;

import java.sql.Timestamp;

public class UserFeedbackTb extends ParentModel{

	private Integer id; //
	private Integer userId; //
	private String content; //反馈内容
	private Timestamp createTime; //

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
	public String getContent() {
		return content;
	}
	public void setContent (String content) {
		this.content = content;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}

    @Override
    public String toString() {
        return "UserFeedbackTb{" +
            "\nid=" + id +
            "\nuserId=" + userId +
            "\ncontent=" + content +
            "\ncreateTime=" + createTime +
            '}';
    }
}