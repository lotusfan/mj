package com.mjapp.model;

import com.mjapp.model.view.UserView;

import java.sql.Timestamp;

public class NewsCommentTb extends ParentModel{

	private Integer id; //
	private Integer newsId; //动态Id
	private Integer newsUserId; //动态发布者ID
	private Integer userId; //评论都ID
	private Integer replyUserId; //回复评论，当前评论发布的用户ID
	private Integer parentCommentId; //评论回复的上级评论ID
	private Integer deleteFlag; //是否被删除1未删除2已删除
	private Timestamp createTime; //
	private String content;

	private UserView userView;

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId (Integer newsId) {
		this.newsId = newsId;
	}
	public Integer getNewsUserId() {
		return newsUserId;
	}
	public void setNewsUserId (Integer newsUserId) {
		this.newsUserId = newsUserId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId (Integer userId) {
		this.userId = userId;
	}
	public Integer getReplyUserId() {
		return replyUserId;
	}
	public void setReplyUserId (Integer replyUserId) {
		this.replyUserId = replyUserId;
	}
	public Integer getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId (Integer parentCommentId) {
		this.parentCommentId = parentCommentId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserView getUserView() {
		return userView;
	}

	public void setUserView(UserView userView) {
		this.userView = userView;
	}

	@Override
	public String toString() {
		return "NewsCommentTb{" +
				"id=" + id +
				", newsId=" + newsId +
				", newsUserId=" + newsUserId +
				", userId=" + userId +
				", replyUserId=" + replyUserId +
				", parentCommentId=" + parentCommentId +
				", deleteFlag=" + deleteFlag +
				", createTime=" + createTime +
				", content='" + content + '\'' +
				'}';
	}
}