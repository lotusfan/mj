package com.mjapp.model;

import java.sql.Timestamp;

public class UserLifeLineTb extends ParentModel{

	private Integer id; //
	private Integer relationId; //相关ID
	private Integer type1; //用户操作方式
	private Integer userId; //
	private Timestamp createTime; //
	private Integer type2; //
	private Integer type3; //
	private Integer deleteFlag; //

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getRelationId() {
		return relationId;
	}
	public void setRelationId (Integer relationId) {
		this.relationId = relationId;
	}
	public Integer getType1() {
		return type1;
	}
	public void setType1 (Integer type1) {
		this.type1 = type1;
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
	public Integer getType2() {
		return type2;
	}
	public void setType2 (Integer type2) {
		this.type2 = type2;
	}
	public Integer getType3() {
		return type3;
	}
	public void setType3 (Integer type3) {
		this.type3 = type3;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag (Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

    @Override
    public String toString() {
        return "UserLifeLineTb{" +
            "\nid=" + id +
            "\nrelationId=" + relationId +
            "\ntype1=" + type1 +
            "\nuserId=" + userId +
            "\ncreateTime=" + createTime +
            "\ntype2=" + type2 +
            "\ntype3=" + type3 +
            "\ndeleteFlag=" + deleteFlag +
            '}';
    }
}