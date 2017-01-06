package com.mjapp.model;

import com.alibaba.fastjson.JSONArray;
import com.mjapp.model.view.UserView;

import java.sql.Timestamp;
import java.util.List;

public class UserNewsTb extends ParentModel{

	private Integer id; //
	private String content; //内容
	private String picJson; //图片
	private Integer forwardFlag; //是否为转发
	private Integer forwardNewsId; //转发关联的ID
	private Integer userId; //创建者ID
	private Timestamp createTime; //
	private Integer deleteFlag;

	//非数据字段
	private JSONArray picJsonArray;

	//前端展显字段
	private UserNewsTb forwardUserNewsTb;
	private Integer forwardNum;
	private List<UserNewsTb> forwardUserNewss;
	private Integer praiseNum;
	private List<UserView> praiseUserViews;
	private Integer commentNum;
	private List<NewsCommentTb> newsCommentTbs;
	private UserView userView;

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent (String content) {
		this.content = content;
	}
	public String getPicJson() {
		return picJson;
	}
	public void setPicJson (String picJson) {
		this.picJson = picJson;
	}
	public Integer getForwardFlag() {
		return forwardFlag;
	}
	public void setForwardFlag (Integer forwardFlag) {
		this.forwardFlag = forwardFlag;
	}
	public Integer getForwardNewsId() {
		return forwardNewsId;
	}
	public void setForwardNewsId (Integer forwardNewsId) {
		this.forwardNewsId = forwardNewsId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId (Integer userId) {
		this.userId = userId;
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

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public JSONArray getPicJsonArray() {
		return picJsonArray;
	}

	public void setPicJsonArray(JSONArray picJsonArray) {
		this.picJsonArray = picJsonArray;
	}

	public UserNewsTb getForwardUserNewsTb() {
		return forwardUserNewsTb;
	}

	public void setForwardUserNewsTb(UserNewsTb forwardUserNewsTb) {
		this.forwardUserNewsTb = forwardUserNewsTb;
	}

	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public List<NewsCommentTb> getNewsCommentTbs() {
		return newsCommentTbs;
	}

	public void setNewsCommentTbs(List<NewsCommentTb> newsCommentTbs) {
		this.newsCommentTbs = newsCommentTbs;
	}

	public UserView getUserView() {
		return userView;
	}

	public void setUserView(UserView userView) {
		this.userView = userView;
	}

	public Integer getForwardNum() {
		return forwardNum;
	}

	public void setForwardNum(Integer forwardNum) {
		this.forwardNum = forwardNum;
	}

	public List<UserNewsTb> getForwardUserNewss() {
		return forwardUserNewss;
	}

	public void setForwardUserNewss(List<UserNewsTb> forwardUserNewss) {
		this.forwardUserNewss = forwardUserNewss;
	}

	public List<UserView> getPraiseUserViews() {
		return praiseUserViews;
	}

	public void setPraiseUserViews(List<UserView> praiseUserViews) {
		this.praiseUserViews = praiseUserViews;
	}

	@Override
	public String toString() {
		return "UserNewsTb{" +
				"id=" + id +
				", content='" + content + '\'' +
				", picJson='" + picJson + '\'' +
				", forwardFlag=" + forwardFlag +
				", forwardNewsId=" + forwardNewsId +
				", userId=" + userId +
				", createTime=" + createTime +
				", deleteFlag=" + deleteFlag +
				", picJsonArray=" + picJsonArray +
				", forwardUserNewsTb=" + forwardUserNewsTb +
				", forwardNum=" + forwardNum +
				", forwardUserNewss=" + forwardUserNewss +
				", praiseNum=" + praiseNum +
				", praiseUserViews=" + praiseUserViews +
				", commentNum=" + commentNum +
				", newsCommentTbs=" + newsCommentTbs +
				", userView=" + userView +
				'}';
	}
}